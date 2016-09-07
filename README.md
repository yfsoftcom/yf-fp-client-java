## fpc4j

#### 使用方法

- 下载jar包，导入到工程中

- 添加需要的依赖

```html
<!-- https://mvnrepository.com/artifact/com.alibaba/fastjson -->
<dependency>
  <groupId>com.alibaba</groupId>
  <artifactId>fastjson</artifactId>
  <version>1.2.15</version>
</dependency>

<!-- https://mvnrepository.com/artifact/com.squareup.okhttp3/okhttp -->
<dependency>
  <groupId>com.squareup.okhttp3</groupId>
  <artifactId>okhttp</artifactId>
  <version>3.4.1</version>
</dependency>


<!-- https://mvnrepository.com/artifact/com.squareup.retrofit2/retrofit -->
<dependency>
  <groupId>com.squareup.retrofit2</groupId>
  <artifactId>retrofit</artifactId>
  <version>2.1.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/com.squareup.retrofit2/converter-gson -->
<dependency>
  <groupId>com.squareup.retrofit2</groupId>
  <artifactId>converter-gson</artifactId>
  <version>2.1.0</version>
</dependency>
```

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

