package biz.yfsoft.api.ae.api;

import biz.yfsoft.api.ae.AE;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by CoderA on 2016/5/20.
 */
public class AEClient {

    private String _method;

    private AEParam _params;

    public AEClient(String _method) {
        this._method = _method;
    }

    public AEClient(String method, AEParam params) {
        _method = method;
        _params = params;
    }
    public void call(AEParam params,final AECallback cb){
        _params = params;
        call(cb);
    }

    public AERspType call() throws IOException{
        if(_params == null)
            _params = new AEParam();
        Call<AERspType> _call = AE.me().call(_method,_params);
        return _call.execute().body();
    }

    public void call(final AECallback cb){
        if(_params == null)
            _params = new AEParam();
        Call<AERspType> _call = AE.me().call(_method,_params);
        cb.onStart();
        _call.enqueue(new Callback<AERspType>() {

            @Override
            public void onResponse(Call<AERspType> call, Response<AERspType> response) {
                AERspType body = response.body();

                if("0".equals(body.getErrno())){
                    Object o = body.getData();
                    if(o instanceof Map){
                        JSONObject jo = new JSONObject();
                        jo.putAll((Map)o);
                        cb.onSuccess(jo);
                    }else if(o instanceof Collection){
                        List<JSONObject> ja = new ArrayList<JSONObject>();
                        for(Iterator it = ((Collection)o).iterator();it.hasNext();){
                            Object subObj = it.next();
                            if(subObj instanceof Map){
                                JSONObject subJo = new JSONObject();
                                subJo.putAll((Map)subObj);
                                ja.add(subJo);
                            }else{
                                //TODO;数据类型错误 抛出异常
                            }
                        }
                        cb.onSuccess(ja);
                    }
                }else{
                    cb.onError(body.getErrno(),body.getMessage());
                }
                cb.onFinally(response.body().toString());

            }

            @Override
            public void onFailure(Call<AERspType> call, Throwable t) {
                cb.onError("-99999",t.getMessage());
                cb.onFinally("{\"errno\":\"-99999\",\"message\":\"" + t.getMessage() + "\"}");
            }
        });

    }
}
