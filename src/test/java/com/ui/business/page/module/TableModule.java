package com.ui.business.page.module;

import com.ui.business.page.base.BasePage;
import com.ui.core.constants.TimeConstants;
import com.ui.core.util.WaitUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class TableModule extends BasePage {

    @FindBy(xpath = "//div[@role='tabpanel']/descendant::table[2]")
    public WebElement baseElement;

    @FindBy(xpath = "//div[@role='tabpanel']//tr")
    public WebElement tableRow;

    public TableModule(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> getSubjectCells() {
        return new TableRow(tableRow, driver).subjectCells();
    }

    public List<String> getSubjects() {
        return getSubjectCells().stream().map(webElement -> wait.waitForElementIsVisible(webElement).getText()).collect(Collectors.toList());
    }

    public boolean isLetterAppearsInTable(String mailSubject) {
        int attemptAmount = 10;
        for (int i = 0; i < attemptAmount; i++) {
            List<String> subjects = getSubjects();
            if (subjects.contains(mailSubject)) {
                return true;
            } else WaitUtil.sleep(TimeConstants.MS._1000);
        }
        return false;
    }

    public void openMailBySubject(String subject) {
        getSubjectCells().stream().filter(webElement -> wait.waitForElementIsVisible(webElement).getText().equals(subject)).findFirst().ifPresent(WebElement::click);
        wait.waitForElementIsInvisible(baseElement);
    }
}
