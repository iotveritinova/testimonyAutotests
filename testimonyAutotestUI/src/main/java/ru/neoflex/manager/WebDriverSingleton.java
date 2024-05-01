package ru.neoflex.manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class WebDriverSingleton {
    private WebDriverSingleton() throws IllegalAccessException {
        throw new IllegalAccessException("Utility class");
    }

    public static WebDriver driver;

    public static WebDriver getInstance() throws IOException {
        Properties properties = new Properties();
        String target = properties.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/main/resources/%s.properties", target))));
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        if (driver == null) {
            switch (properties.getProperty("browser")) {
                case "chrome":
                    System.out.println("case \"chrome\":");
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    System.out.println("case \"firefox\":");
                    driver = new FirefoxDriver();
                    break;
            }
            driver = new DriverManager().getDriver();
        }
        return driver;
    }
}
