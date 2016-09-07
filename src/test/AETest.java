import biz.yfsoft.api.ae.AE;
import biz.yfsoft.api.ae.api.AEClient;
import biz.yfsoft.api.ae.api.AEParam;
import biz.yfsoft.api.ae.api.AERspType;
import com.alibaba.fastjson.JSONObject;
import org.junit.*;

import java.io.IOException;

/**
 * Created by CoderA on 2016/8/5.
 */
public class AETest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

//        AE.me().init("08d7b0fa132b2880","6026a8e2264e94f8b8dcb57a7b428d6d").setDefaultDevHost("http://192.168.1.115:8080").setMode(AE.MODE_DEV);

        AE.me().init("a81bc1bb16bc23bb","3fc4c39d3e59b33b67bcbc359d31e7ee").setMode(AE.MODE_STAGING);
    }


    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSign(){

        AEClient _client = new AEClient("common.test",new AEParam().set("uid",5).set("中文","001467249347566"));
        AERspType result = null;
        try {
            result = _client.call();
            System.out.println(result.toString());
            JSONObject jo = JSONObject.parseObject(result.toString());
            System.out.println("errno should be 0");
            Assert.assertTrue("0".equals(jo.getString("errno")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
