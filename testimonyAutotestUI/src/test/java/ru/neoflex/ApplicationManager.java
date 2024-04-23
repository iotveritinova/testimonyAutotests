package ru.neoflex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApplicationManager {

    //protected
    public WebDriver driver;
    public MainPage mainPage;
    public SendPage sendPage;

    public MainPage getMainPage() {
        //I have no idea why this returns null
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

    protected void init() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\neoCourseBanking\\ОАТ-Web Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5500/index.html");
        //нужно отрефакторить PageNavigationTest пока не понятно почему applicationManager.getMainPage(); возвращает null
        MainPage mainPage = new MainPage(driver);
        SendPage sendPage = new SendPage(driver);
        Thread.sleep(1000);
    }

    protected void close() {
        driver.quit();
    }
}
