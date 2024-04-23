package ru.neoflex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendPage {
    private final WebDriver driver;

    public SendPage(WebDriver driver) {
        this.driver = driver;

    }

    private By header = By.xpath("/html/body/h1");
    private By backButton = By.xpath("//*[@id=\"back_button\"]");


    public String getHeaderText() {
        return driver.findElement(header).getText();

    }

    public void clickBackButton() {
        driver.findElement(backButton).click();

    }
}
