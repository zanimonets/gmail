package com.ui.core.driver;

import com.ui.core.util.GlobalConfiguratorUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    private DriverFactory() {
    }

    private static DriverFactory instance = new DriverFactory();

    public static DriverFactory getInstance() {
        return instance;
    }

    ThreadLocal<WebDriver> driver = ThreadLocal.withInitial(() -> {
        WebDriver webDriver;
        switch (GlobalConfiguratorUtil.BROWSER_TYPE) {
            case "chrome":
                WebDriverManager.chromedriver().version(GlobalConfiguratorUtil.CHROME_DRIVER_VERSION).setup();

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--lang=es");
                webDriver = new ChromeDriver(options);
                break;
            default:
                webDriver = new ChromeDriver();
        }
        return webDriver;
    });

    public WebDriver getDriver() {
        return driver.get();
    }

    public void removeDriver() {
        driver.get().quit();
        driver.remove();
    }
}
