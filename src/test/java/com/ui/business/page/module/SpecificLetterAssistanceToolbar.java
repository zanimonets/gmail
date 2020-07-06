package com.ui.business.page.module;

import com.ui.business.page.base.AssistanceToolbar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpecificLetterAssistanceToolbar extends AssistanceToolbar {

    @FindBy(xpath = "//div[@gh='mtb']//div[@title='Delete']/div")
    public WebElement deleteBtn;

    public SpecificLetterAssistanceToolbar(WebDriver driver) {
        super(driver);
    }

    public void clickDeleteBtn() {
        wait.waitForElementIsVisible(deleteBtn).click();
    }
}
