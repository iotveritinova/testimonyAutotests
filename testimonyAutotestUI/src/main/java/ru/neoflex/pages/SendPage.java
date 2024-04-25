package ru.neoflex.pages;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Iterator;

import static ru.neoflex.utils.DataProvider.sendPageTestData;

public class SendPage extends Element {

    public SendPage(WebDriver driver) {
        super(driver);
    }

    private By sendData = By.xpath("//*[@id=\"button\"]");


    public SendPage clickSubmitButton() {
        click(driver.findElement(sendData));
        return new SendPage(driver);
    }

    public void inputDate(String value) {
        inputDataField("date", value);
    }

    public void inputColdWater(String value) {
        inputDataField("coldData", value);
    }

    public void inputHotWater(String value) {
        inputDataField("hotData", value);

    }

    public void inputGas(String value) {
        inputDataField("gasData", value);

    }

    public void inputElectric(String value) {
        inputDataField("elecData", value);

    }
}
