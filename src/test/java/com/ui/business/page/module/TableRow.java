package com.ui.business.page.module;

import com.ui.business.page.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TableRow extends BasePage {

    private WebElement baseElement;
    private By cell = By.xpath("td");

    public TableRow(WebElement row, WebDriver driver) {
        super(driver);
        baseElement = row;
    }

    public List<WebElement> subjectCells() {
        return wait.waitForElementIsVisible(baseElement).findElements(cell).get(5).findElements(By.xpath("//span[@class = 'bog']/span[@data-legacy-last-message-id]"));
    }
}
