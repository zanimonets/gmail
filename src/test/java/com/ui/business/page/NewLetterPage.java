package com.ui.business.page;

import com.ui.business.model.Email;
import com.ui.business.page.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewLetterPage extends BasePage {

    @FindBy(css = "div[role='dialog']")
    private WebElement baseElement;

    @FindBy(xpath = "//textarea[@name='to']")
    private WebElement toField;

    @FindBy(xpath = "//input[@aria-label='Subject']")
    private WebElement subjectField;

    @FindBy(xpath = "//div[@aria-label='Message Body']")
    private WebElement emailBodyField;

    @FindBy(xpath = "//div[@role='dialog']//div[contains(text(),'Send')]")
    private WebElement sendBtn;

    public NewLetterPage(WebDriver driver) {
        super(driver);
    }

    public void createLetterDraft(Email email) {
        wait.waitForElementIsVisible(toField).sendKeys(email.getToField());
        subjectField.sendKeys(email.getSubjectField());
        emailBodyField.sendKeys(email.getEmailBody());
    }

    public void fillFieldsAndSendLetter(Email email){
        createLetterDraft(email);
        sendBtn.click();
        wait.waitForElementIsInvisible(baseElement);
    }
}
