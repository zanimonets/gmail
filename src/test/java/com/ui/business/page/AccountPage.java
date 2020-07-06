package com.ui.business.page;

import com.ui.business.page.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//a[contains(@href, 'Logout')]")
    private WebElement signOutBtn;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnSignOutBtn() {
        wait.waitForElementIsClickable(signOutBtn).click();
    }
}


