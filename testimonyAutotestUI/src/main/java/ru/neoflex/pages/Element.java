package ru.neoflex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Element extends BasePage{
    private By header = By.xpath("/html/body/h1");

    public Element(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
}
