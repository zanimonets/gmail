package com.ui.tests;

import com.ui.core.driver.DriverFactory;
import com.ui.core.util.GlobalConfiguratorUtil;
import com.ui.core.util.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod()
    public void onStart() {
        Logger.debug("Setup data, driver, open URL at browser");
        GlobalConfiguratorUtil.loadProperties();
        driver = DriverFactory.getInstance().getDriver();
        driver.get(GlobalConfiguratorUtil.URI);
    }

    @AfterMethod(alwaysRun = true)
    public void onFinish() {
        DriverFactory.getInstance().removeDriver();
        Logger.debug("Driver quit");
    }
}


