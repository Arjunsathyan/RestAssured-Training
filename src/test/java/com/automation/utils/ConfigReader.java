package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    static Properties pro;

    public static void initConfig()
    {
            pro=new Properties();

            try {
                pro.load(new FileInputStream("src/test/resources/Config/config.properties"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
    }
    public static String getConfigValue(String key) {
        return pro.getProperty(key);
    }

}
