package com.ui.tests;

import com.ui.business.model.User;
import com.ui.business.page.EmailPage;
import com.ui.business.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest{

    private LoginPage loginPage;
    private EmailPage emailPage;

    @BeforeMethod()
    public void setupTest() {
        loginPage = new LoginPage(driver);
        emailPage = new EmailPage(driver);
    }

    @Test()
    public void logInTest() {
        loginPage.login(User.DEFAULT_USER.getLogin(), User.DEFAULT_USER.getPassword());

        Assert.assertTrue(emailPage.headerModule().isLogoDisplayed() , "Logging failed");
    }
}




