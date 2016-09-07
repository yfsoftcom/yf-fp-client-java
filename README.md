## fpc4j

#### 使用方法

```java
//初始化
AE.me().init("a81bc1bb16bc23bb","3fc4c39d3e59b33b67bcbc359d31e7ee").setMode(AE.MODE_STAGING);
AEClient _client = new AEClient("common.test",new AEParam().set("uid",5).set("中文","001467249347566"));
AERspType result = null;
try {
    result = _client.call();
    System.out.println(result.toString());
    JSONObject jo = JSONObject.parseObject(result.toString());
} catch (IOException e) {
    e.printStackTrace();
}
```

