package com.ui.business.page;

import com.ui.business.page.base.ContentPage;
import com.ui.business.page.module.SpecificLetterAssistanceToolbar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpecificLetterPage extends ContentPage {

    @FindBy(xpath = "//div[contains(@class,'ii')]//div[@dir]")
    private WebElement letterBody;

    private SpecificLetterAssistanceToolbar specificLetterAssistanceToolbar;

    public SpecificLetterPage(WebDriver driver) {
        super(driver);
        specificLetterAssistanceToolbar = new SpecificLetterAssistanceToolbar(driver);
    }

    public SpecificLetterAssistanceToolbar specificLetterAssistanceToolbar() {
        return specificLetterAssistanceToolbar;
    }

    public String getBodyText(){
        return wait.waitForElementIsVisible(letterBody).getText();
    }
}
