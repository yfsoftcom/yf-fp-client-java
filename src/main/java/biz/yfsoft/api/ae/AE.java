package biz.yfsoft.api.ae;

import biz.yfsoft.api.ae.api.AEParam;
import biz.yfsoft.api.ae.api.AERspType;
import biz.yfsoft.api.ae.api.AEService;
import biz.yfsoft.api.ae.utils.EntityUtils;
import biz.yfsoft.api.ae.utils.MD5Kit;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

public class AE {

    private OkHttpClient _client;

    private String _appkey;

    private String _masterkey;

    private String _host;

    private String _v = "0.0.1";

    private AEService _service;

    private AE(){
        _client = new OkHttpClient.Builder()
                .connectTimeout(2, TimeUnit.MINUTES)
                .readTimeout(2,TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .build();
    }

    private static AE _me = new AE();

    public static AE me(){
        return _me;
    }

    private AEService buildService(){
        return new Retrofit.Builder()
                .baseUrl(_host)
                .addConverterFactory(GsonConverterFactory.create(EntityUtils.gson))
                .client(_client)
                .build()
                .create(AEService.class);
    }

    public AE init(String host, String appkey, String masterkey){
        _host = host;
        _appkey = appkey;
        _masterkey = masterkey;
        _service = buildService();
        return this;
    }

    public String getVersion(){
        return _v;
    }

    public AE setVersion(String v){
        _v = v;
        return this;
    }

    public AEService getService(){
        return _service;
    }

    public Call<AERspType> call(String method, AEParam param){

        Long _now = System.currentTimeMillis();

        return _service.call(method,_appkey,String.valueOf(_now),param.toJSONString(),sign(method,param,_now),_v);
    }



    private String sign(String method,AEParam param,Long now) {

        StringBuilder sb = new StringBuilder();
        try {
            String content = sb.append("appkey=").append(_appkey)
                    .append("&masterKey=").append(_masterkey)
                    .append("&method=").append(method)
                    .append("&param=").append(URLEncoder.encode(param.toJSONString(),"utf-8"))
                    .append("&timestamp=").append(now)
                    .append("&v=").append(_v).toString();
            String distCode = MD5Kit.encode(content);
            return distCode;
        } catch (UnsupportedEncodingException e) {

        }
        return "";
    }


}
