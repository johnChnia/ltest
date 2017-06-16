package testsuites;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeSuite;
import util.PropertiesUtil;

/**
 * Created by john.zhou on 2017/6/16.
 */
public class BaseTest {

    static {
        PropertiesUtil.readProperties("env.properties");
    }
    @BeforeSuite
    public void init() {
        RestAssured.baseURI = PropertiesUtil.getProperty("baseURI");
    }

}
