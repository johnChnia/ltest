package constant;

/**
 * Created by john on 2017/6/19.
 */
public class HeadCons {

    /**
     * 设备渠道：Android(1), Browser(2),Apple(3)
     */
    public static final String SOURCE_ID = "X-Source-Id";


    /**
     * APP版本
     */
    public static final String APP_VERSION = "X-App-Version";

    /**
     * 渠道
     */
    public static final String ORIGIN = "X-origin";

    /**
     * 产品编码
     */
    public static final String PRODUCT_CODE = "X-Product-Code";

    /**
     * 手机号码
     */
    public static final String MOBILE = "X-User-Mobile";

    /**
     * 用户令牌
     */
    public static final String TOKEN = "X-User-Token";

    /**
     * 数据访问令牌
     */
    public static final String ACCESS_TOKEN = "X-Access-Token";

    /**
     * 角色类别：未分类(0)，学生族(1)，工薪(2)
     */
    public static final String IDENTITY = "X-User-Identity";

    /**
     * 合作方简称
     */
    public static final String PARTNER_CODE = "X-Partner-Code";

    /**
     * 内部服务ID，用于内部服务间调用传递调用方标识
     */
    public static final String INTERNAL_SERVICE_ID = "X-Service-Id";
}
