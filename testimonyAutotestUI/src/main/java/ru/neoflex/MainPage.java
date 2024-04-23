package ru.neoflex;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By dataSend = By.xpath("//*[@id=\"send_button\"]");
    private By dataHistory = By.xpath("//*[@id=\"history_button\"]");
    private By catalog = By.xpath("//*[@id=\"catalog_button\"]");

    public SendPage clickSend() {
        driver.findElement(dataSend).click();
        return new SendPage(driver);
    }

    public HistoryPage clickHistory() {
        driver.findElement(dataHistory).click();
        return new HistoryPage(driver);
    }

    public PricePage clickPrice() {
        driver.findElement(catalog).click();
        return new PricePage(driver);
    }

    private By header = By.xpath("/html/body/h1");

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }
}
/*dataSend - переменная, представляющая кнопку Передача показаний
        dataHistory - переменная, представляющая кнопку История показаний
        catalog - переменная, представляющая кнопку Справочник
        click() - метод selenium Selenium WebDriver, который выполняет клик по элементу
        clickSend() - метод, с помощью которого нажимается кнопка Передача показаний
        clickHistory() - метод, с помощью которого нажимается кнопка История показаний
        clickPrice() - метод, с помощью которого нажимается кнопка Справочник
 */
