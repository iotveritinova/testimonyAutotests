package ru.neoflex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendPage extends Element {

    private By sendData = By.xpath("//*[@id=\"button\"]");

    public SendPage(WebDriver driver) {
        super(driver);
    }

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

    //в приложении отсутствует resultValue поэтому такая аннотация, потом разберусь
    @Deprecated
    public short getResultValue() {
        return 0;
    }
}
