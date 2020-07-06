package com.ui.core.util;

import com.ui.core.constants.TimeConstants;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWait {

    private WebDriver driver;
    private Wait<WebDriver> wait;

    public ExplicitWait(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TimeConstants.SEC._10).ignoring(StaleElementReferenceException.class, WebDriverException.class)
                .withMessage("Element was not found by locator");
    }

    public WebElement waitForElementIsClickable(WebElement webElement) {
        return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public WebElement waitForElementIsPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public WebElement waitForElementIsVisible(WebElement webElement) {
        return wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public Boolean waitForElementIsInvisible(WebElement webElement) {
        return wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    public void waitForElementAppear(By locator, int timeoutSec) {
        new FluentWait<WebDriver>(driver) {}.withMessage("Element wasn't found.")
                .withTimeout(timeoutSec, TimeUnit.SECONDS).ignoring(WebDriverException.class)
                .until(driver -> driver.findElement(locator));
    }
}
