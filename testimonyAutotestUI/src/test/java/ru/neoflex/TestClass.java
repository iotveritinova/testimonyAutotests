package ru.neoflex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestClass {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\neoCourseBanking\\ОАТ-Web Automation\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://127.0.0.1:5500/index.html");
        WebElement header = driver.findElement(By.xpath("/html/body/h1"));
        System.out.println(header.getText());
        WebElement button = driver.findElement(By.cssSelector("#history_button"));
        System.out.println(button.getAttribute("value"));
        driver.quit();
    }

}
