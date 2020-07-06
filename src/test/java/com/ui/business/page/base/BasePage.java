package com.ui.business.page.base;

import com.ui.core.util.ExplicitWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    protected ExplicitWait wait;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        wait = new ExplicitWait(driver);
    }
}
