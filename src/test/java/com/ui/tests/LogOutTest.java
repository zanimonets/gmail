package com.ui.tests;

import com.ui.business.page.EmailPage;
import com.ui.business.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends BaseTest{

    private LoginPage loginPage;
    private EmailPage emailPage;

    @BeforeMethod()
    public void setupTest() {
        loginPage = new LoginPage(driver);
        emailPage = new EmailPage(driver);

        loginPage.loginAsDefaultUser();
    }

    @Test()
    public void logOutTest() {
        emailPage.headerModule().signOut();

        Assert.assertTrue(loginPage.isLoginPageVisible() , "Logout failed");
    }
}
