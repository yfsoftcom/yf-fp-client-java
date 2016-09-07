package biz.yfsoft.api.ae.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by CoderA on 2016/5/21.
 */
public interface AECallback {

    void onStart();

    void onSuccess(JSONObject o);

    void onSuccess(List<JSONObject> a);

    void onError(String errno, String message);

    void onFinally(String originResult);

}
