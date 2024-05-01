package ru.neoflex.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
//import org.openqa.selenium.remote.BrowserType;  в либе нет. так понимаю аналог

public class DriverFactory {

    static WebDriver createDriver(String browser) {
        if (browser.equals(Browser.CHROME)) {
            return new ChromeDriver();
        } else if (browser.equals(Browser.FIREFOX)) {
            return new FirefoxDriver();
        } else {
            return new ChromeDriver();
        }
    }
}
