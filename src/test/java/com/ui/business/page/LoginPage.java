package com.ui.business.page;

import com.ui.business.model.User;
import com.ui.business.page.base.BasePage;
import com.ui.core.constants.TimeConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "#initialView")
    private WebElement baseElement;

    @FindBy(css = "#identifierId")
    private WebElement emailOrPhoneField;

    @FindBy(css = "#identifierNext>div")
    private WebElement firstNextBtn;

    @FindBy(css = "#password input")
    private WebElement passwordField;

    @FindBy(css = "#passwordNext>div")
    private WebElement secondNextBtn;

    @FindBy(xpath = "//div[contains(@id, 'loading')]")
    private WebElement loaderElement;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String login, String password) {
        wait.waitForElementIsVisible(emailOrPhoneField).sendKeys(login);;
        firstNextBtn.click();
        wait.waitForElementIsVisible(passwordField).sendKeys(password);
        secondNextBtn.click();
        wait.waitForElementIsPresent(By.id("loading"));
        wait.waitForElementIsInvisible(loaderElement);
    }

    public void loginAsDefaultUser() {
        login(User.DEFAULT_USER.getLogin(), User.DEFAULT_USER.getPassword());
    }

    public boolean isLoginPageVisible() {
        wait.waitForElementAppear(By.id("initialView"), TimeConstants.SEC._10);
        return baseElement.isDisplayed();
    }
}
