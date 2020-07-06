package com.ui.business.page.module;

import com.ui.business.page.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftPanelModule extends BasePage {

    @FindBy(xpath = "//div[@class='aic']//div[@role='button']")
    private WebElement composeBtn;

    @FindBy(xpath = "//span/a[contains(@href, 'inbox')]")
    private WebElement inboxBtn;

    public LeftPanelModule(WebDriver driver) {
        super(driver);
    }

    public void clickComposeBtn() {
        wait.waitForElementIsClickable(composeBtn).click();;
    }
}
