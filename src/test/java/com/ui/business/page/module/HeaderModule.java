package com.ui.business.page.module;

import com.ui.business.page.AccountPage;
import com.ui.business.page.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderModule extends BasePage {

    @FindBy(css = "a[href='#inbox']>img")
    private WebElement logo;

    @FindBy(xpath = "//a[contains(@aria-label, 'Google')]/img")
    private WebElement accountIcon;

    private AccountPage accountPage;

    public HeaderModule(WebDriver driver) {
        super(driver);
        accountPage = new AccountPage(driver);
    }

    public AccountPage accountPage(){
        return accountPage;
    }

    public boolean isLogoDisplayed(){
        return logo.isDisplayed();
    }

    public void clickOnAccountIcon() {
        accountIcon.click();
    }

    public void signOut(){
        clickOnAccountIcon();
        accountPage().clickOnSignOutBtn();
    }
}
