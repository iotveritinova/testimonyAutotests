package ru.neoflex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Element extends BasePage{
    private By header = By.xpath("/html/body/h1");
    private By backButton = By.xpath("//*[@id=\"back_button\"]");

    public Element(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public void clickBackButton() {
        waitForElementClickable(driver.findElement(backButton), driver);
        click(driver.findElement(backButton));
    }
}
