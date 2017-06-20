package testsuites;

import utils.PropertiesUtil;
import utils.RestUtil;

/**
 * Created by john.zhou on 2017/6/16.
 */
public abstract class BaseTest {

    static {
        PropertiesUtil.readProperties("env.properties");
        RestUtil.setBaseURI(PropertiesUtil.getProperty("baseURI"));
        RestUtil.setLogAll();
    }


}
