package com.ui.core.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class GlobalConfiguratorUtil {
    public static String URI;
    public static String BROWSER_TYPE;
    public static String CHROME_DRIVER_VERSION;

    public static void loadProperties() {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            URL url = ClassLoader.getSystemResource("config.properties");
            input = new FileInputStream(url.getFile());
            prop.load(input);
            URI = prop.getProperty("uri");
            BROWSER_TYPE = prop.getProperty("browser.type");
            CHROME_DRIVER_VERSION = prop.getProperty("chromedriver.version");

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
