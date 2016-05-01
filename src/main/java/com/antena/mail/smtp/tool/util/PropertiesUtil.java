package com.antena.mail.smtp.tool.util;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

/**
 * Created by Rickey Huang on 2015/3/4.
 */
@Component
public class PropertiesUtil {

    private static Properties properties;

    private static String filePath = "system.properties";

    private static final Logger log = LogManager.getLogger(PropertiesUtil.class);

    private static void initProperties() {

        InputStream is;
        try {
            log.info("[Run with bat/script] File Path: {}", filePath);
            is = new FileInputStream(filePath);
        } catch (FileNotFoundException e) {
            URL url = ClassLoader.getSystemResource(filePath);
            try {
                is = new FileInputStream(url.getPath());
            } catch (FileNotFoundException e1) {
                throw new RuntimeException("Failed to load property file", e);
            }
        }

        properties = new Properties();

        try {
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load property file", e);
        }

    }

    public static String getString(String key) {

        if (properties == null) {
            initProperties();
        }
        return properties.getProperty(key);
    }

    public static boolean getBoolean(String key) {
        if (properties == null) {
            initProperties();
        }
        String value = properties.getProperty(key);
        return Boolean.parseBoolean(value);
    }

    public static int getInt(String key) {
        if (properties == null) {
            initProperties();
        }
        String value = properties.getProperty(key);
        return Integer.parseInt(value);
    }

    public static void reloadProperties(String path) {

        log.info("reload properties:" + path);
        filePath = path;
        initProperties();
    }

}
