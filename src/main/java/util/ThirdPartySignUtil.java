package util;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by john.zhou on 2017/6/16.
 */
public class ThirdPartySignUtil {
    private static final String COMPANY_NAME = "welab_test";
    private static final String SECRET = "5b66f77c880df4f9dfee5130686440b2";
    public static final String CHARSET_UTF8 = "UTF-8";


    public static Map<String, String> sign(String mobile) throws IOException {
        String timestamp = String.valueOf(System.currentTimeMillis());
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("company_name", COMPANY_NAME);
        hashMap.put("mobile", mobile);
        hashMap.put("timestamp", timestamp);
        String signRequest = signRequest(hashMap, null, SECRET);
        hashMap.put("sign", signRequest);
        return hashMap;
    }

    private static String signRequest(Map<String, String> params, String body, String secret) throws IOException {
        // 第一步：对参数进行排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        // 第二步：把所有参数名和参数值串在一起
        StringBuilder query = new StringBuilder();

        for (String key : keys) {
            String value = params.get(key);
            if (key != null && value != null) {
                query.append(key).append(value);

            }
        }

        // 第三步：把请求主体拼接在参数后面
        if (body != null) {
            query.append(body);
        }

        // 第四步：使用MD5/HMAC加密
        byte[] bytes;
        bytes = encryptHMAC(query.toString(), secret)
        ;
        // 第五步：把二进制转化为大写的十六进制
        return byte2hex(bytes);
    }

    private static byte[] encryptHMAC(String data, String secret) throws IOException {
        byte[] bytes = null;
        try {
            SecretKey secretKey = new SecretKeySpec(secret.getBytes(CHARSET_UTF8), "HmacMD5");
            Mac mac = Mac.getInstance(secretKey.getAlgorithm());
            mac.init(secretKey);
            bytes = mac.doFinal(data.getBytes(CHARSET_UTF8));
        } catch (GeneralSecurityException gse) {
            throw new IOException(gse.toString());
        }
        return bytes;
    }

    /**
     * 把字节流转换为十六进制表示方式。
     */
    private static String byte2hex(byte[] bytes) {
        StringBuilder sign = new StringBuilder();
        for (int i = 0; i < bytes.length; i++) {
            String hex = Integer.toHexString(bytes[i] & 0xFF);
            if (hex.length() == 1) {
                sign.append("0");
            }
            sign.append(hex.toUpperCase());
        }
        return sign.toString();
    }
}
