package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created by john.zhou on 2017/6/16.
 */
public class PropertiesUtil {
    private static final Properties PROP = new Properties();

    /**
     * 读取配置文件
     *
     * @param fileName
     */
    public static void readProperties(String fileName) {
        try {
            InputStream in = PropertiesUtil.class.getResourceAsStream("/" + fileName);
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));
            PROP.load(bf);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据key读取对应的value
     *
     * @param key
     * @return
     */
    public static String getProperty(String key) {
        return PROP.getProperty(key);
    }
}
