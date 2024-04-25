package ru.neoflex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends Element {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private By dataSend = By.xpath("//*[@id=\"send_button\"]");
    private By dataHistory = By.xpath("//*[@id=\"history_button\"]");
    private By catalog = By.xpath("//*[@id=\"catalog_button\"]");

    public SendPage clickSend() {
        click(driver.findElement(dataSend));
        return new SendPage(driver);
    }

    public HistoryPage clickHistory() {
        click(driver.findElement(dataHistory));
        return new HistoryPage(driver);
    }

    public PricePage clickPrice() {
        click(driver.findElement(catalog));
        return new PricePage(driver);
    }

}