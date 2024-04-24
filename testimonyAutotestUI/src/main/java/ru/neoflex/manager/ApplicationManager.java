package ru.neoflex.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.neoflex.pages.HistoryPage;
import ru.neoflex.pages.MainPage;
import ru.neoflex.pages.PricePage;
import ru.neoflex.pages.SendPage;

public class ApplicationManager {

    public WebDriver driver;
    public MainPage mainPage;
    public SendPage sendPage;
    public HistoryPage historyPage;
    public PricePage pricePage;


    public MainPage getMainPage() {
        return mainPage;
    }

    public void setMainPage(MainPage mainPage) {
        this.mainPage = mainPage;
    }

    public SendPage getSendPage() {
        return sendPage;
    }

    public void setSendPage(SendPage sendPage) {
        this.sendPage = sendPage;
    }

    public HistoryPage getHistoryPage() {
        return historyPage;
    }

    public void setHistoryPage(HistoryPage historyPage) {
        this.historyPage = historyPage;
    }

    public PricePage getPricePage() {
        return pricePage;
    }

    public void setPricePage(PricePage pricePage) {
        this.pricePage = pricePage;
    }

    public void init() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\neoCourseBanking\\ОАТ-Web Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5500/index.html");
        mainPage = new MainPage(driver);
        sendPage = new SendPage(driver);
        historyPage=new HistoryPage(driver);
        pricePage=new PricePage(driver);

        Thread.sleep(1000);
    }

    public void close() {
        driver.quit();
    }
}
