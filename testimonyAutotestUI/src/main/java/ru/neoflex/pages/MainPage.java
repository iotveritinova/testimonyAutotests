package ru.neoflex.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class MainPage extends Element{

    //private WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
       // this.driver = driver;
    }

    private By dataSend = By.xpath("//*[@id=\"send_button\"]");
    private By dataHistory = By.xpath("//*[@id=\"history_button\"]");
    private By catalog = By.xpath("//*[@id=\"catalog_button\"]");

    public SendPage clickSend() {
        //driver.findElement(dataSend).click();
        click(driver.findElement(dataSend));
        return new SendPage(driver);
    }

    public HistoryPage clickHistory() {
        //driver.findElement(dataHistory).click();
        click(driver.findElement(dataHistory));
        return new HistoryPage(driver);
    }

    public PricePage clickPrice() {
        //driver.findElement(catalog).click();
        click(driver.findElement(catalog));
        return new PricePage(driver);
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
