package org.luv2code.framework.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/config/config.properties");
            properties.load(fis);
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    // method to fetch property value by key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

}
