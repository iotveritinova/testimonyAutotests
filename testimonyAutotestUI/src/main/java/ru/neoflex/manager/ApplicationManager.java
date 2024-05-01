package ru.neoflex.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Browser;
import ru.neoflex.pages.HistoryPage;
import ru.neoflex.pages.MainPage;
import ru.neoflex.pages.PricePage;
import ru.neoflex.pages.SendPage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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

    public void init() throws IOException {
        Properties properties = new Properties();
        String target = properties.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/main/resources/%s.properties", target))));
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver", "D:\\neoCourseBanking\\ОАТ-Web Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver = DriverFactory.createDriver(String.valueOf(Browser.FIREFOX));
        //deprecated method from the study course
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //not deprecated method
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(properties.getProperty("web.baseUrl"));
        mainPage = new MainPage(driver);
        sendPage = new SendPage(driver);
        historyPage = new HistoryPage(driver);
        pricePage = new PricePage(driver);
    }

    public void close() {
        driver.quit();
    }
}
