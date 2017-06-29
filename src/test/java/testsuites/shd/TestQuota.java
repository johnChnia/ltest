package testsuites.shd;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.RestUtil;

/**
 * Created by john on 2017/6/19.
 */
public class TestQuota extends ShdBaseTest {

    @BeforeClass
    public void setUp() {
//        RestUtil.setBasePath("applications/api/v1/user/quota");
    }

    @Test
    public void testxx() {
        System.out.println("shd");
        RestUtil.getResponse();
    }


}
