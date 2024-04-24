package ru.neoflex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendPage extends Element {

    public SendPage(WebDriver driver) {
        super(driver);
    }

    private By backButton = By.xpath("//*[@id=\"back_button\"]");

    public void clickBackButton() {
        click(driver.findElement(backButton));
    }

}
