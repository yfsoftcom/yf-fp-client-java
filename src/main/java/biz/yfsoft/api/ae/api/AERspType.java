package biz.yfsoft.api.ae.api;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by CoderA on 2016/5/21.
 */
public class AERspType<T> {
    private T data;
    private String errno;
    private String message;
    private long timestamp;
    private long starttime;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getStarttime() {
        return starttime;
    }

    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }

    @Override
    public String toString() {
        Object json = JSONObject.toJSON(this);

        return json.toString();
//        return "{" +
//                "data:" + (data==null?"{}":data.toString()) +
//                ",errno:'" + errno + '\'' +
//                ",message:'" + message + '\'' +
//                ",timestamp:" + timestamp +
//                ",starttime:" + starttime +
//                '}';
    }
}
