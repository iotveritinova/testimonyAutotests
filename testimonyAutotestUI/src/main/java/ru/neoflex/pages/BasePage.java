package ru.neoflex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    //protected final static int WAITING_TIME_IN_SECONDS = 30;
    private static final Duration WAITING_TIME_IN_SECONDS = Duration.ofSeconds(30);
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(WebElement element) {
        element.click();
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public static WebElement waitForElementClickable(WebElement element, WebDriver driver) {
        return (new WebDriverWait(driver, WAITING_TIME_IN_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}
