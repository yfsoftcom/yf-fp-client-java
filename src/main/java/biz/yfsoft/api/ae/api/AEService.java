package biz.yfsoft.api.ae.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by CoderA on 2016/5/20.
 */
public interface AEService {

    @POST("api")
    @FormUrlEncoded
    Call<AERspType> call(
            @Field("method") String method,
            @Field("appkey") String appkey,
            @Field("timestamp") String timestamp,
            @Field("param") String param,
            @Field("sign") String sign,
            @Field("v") String v
    );
}
