package com.ui.tests;

import com.ui.business.model.Email;
import com.ui.business.model.User;
import com.ui.business.page.EmailPage;
import com.ui.business.page.LoginPage;
import com.ui.business.page.SpecificLetterPage;
import com.ui.core.util.RandomGenerator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReceiveEmailTest extends BaseTest{

    private LoginPage loginPage;
    private EmailPage emailPage;
    private SpecificLetterPage specificLetterPage;

    @BeforeMethod()
    public void setupTest() {
        loginPage = new LoginPage(driver);
        emailPage = new EmailPage(driver);
        specificLetterPage = new SpecificLetterPage(driver);

        loginPage.loginAsDefaultUser();
    }

    @AfterMethod()
    public void tearDownTest() {
        specificLetterPage.specificLetterAssistanceToolbar().clickDeleteBtn();
        emailPage.headerModule().signOut();
    }

    @Test()
    public void receiveEmailTest() {
        String emailSubject = "AutoTestSubject" + RandomGenerator.randomString();
        String emailBody = "AutoTestBody" + RandomGenerator.randomString(15);

        Email letter = new Email.Builder()
                .toField(User.DEFAULT_USER.getEmail())
                .subjectField(emailSubject)
                .emailBody(emailBody)
                .build();

        emailPage.leftPanelModule().clickComposeBtn();
        emailPage.newLetterPage().fillFieldsAndSendLetter(letter);
        boolean result = emailPage.tableModule().isLetterAppearsInTable(emailSubject);

        Assert.assertTrue(result, "Sent a letter did not arrive");

        emailPage.tableModule().openMailBySubject(emailSubject);

        Assert.assertEquals(specificLetterPage.getBodyText(), emailBody, "Received letter has invalid body");
    }
}
