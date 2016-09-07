package biz.yfsoft.api.ae.api;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public abstract class BaseAECallback implements AECallback {

    private static final String TAG = "BaseAECallback";

    public void onStart(){

    }

    public void onSuccess(JSONObject o){
        //TODO:...
    }

    public void onSuccess(List<JSONObject> a){
        //TODO:...
    }

    public void onError(String errno, String message){
    }

}
