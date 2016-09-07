package biz.yfsoft.api.ae.api;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by CoderA on 2016/7/3.
 */
public class AEParam {
    private JSONObject _map = null;
    public AEParam(){
        _map = new JSONObject();
    }

    public AEParam setJsonStr(String json){
        _map = JSONObject.parseObject(json);
        return this;
    }

    public AEParam set(String k,Object v){
        _map.put(k,v);
        return this;
    }

    public Object get(String key){
        return _map.get(key);
    }

    public String toJSONString(){
        if(_map.size()<1){
            return "{}";
        }
        return _map.toJSONString();
    }
}
