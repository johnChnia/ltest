package common;

import org.testng.annotations.Test;
import utils.RestUtil;

/**
 * Created by john on 2017/6/21.
 */
public class Login {

    @Test
    public void testB() {
        RestUtil.setBaseURI("");
        RestUtil.setBasePath("");
        RestUtil.setLogAll();
        RestUtil.getResponse();

    }
}
