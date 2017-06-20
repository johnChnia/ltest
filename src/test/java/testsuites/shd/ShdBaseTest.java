package testsuites.shd;

import constant.HeadCons;
import org.testng.annotations.BeforeSuite;
import testsuites.BaseTest;
import utils.HeaderUtil;
import utils.RestUtil;

import java.util.Map;

/**
 * Created by john on 2017/6/20.
 */
public class ShdBaseTest extends BaseTest {

    @BeforeSuite
    public void init() {
        Map<String, String> shdHeader = HeaderUtil.fillHeader(HeadCons.class);
        //配置shd请求头-读取配置文件，填充bean

        RestUtil.setHeaders(shdHeader);

    }
}
