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

    //заменим inputDataField на inputTest чтобы привести код в соответствие с уроком @FindBy и PageFactory
    // public void inputDate(String value) {     inputDataField("date", value); }
    // public void inputColdWater(String value) {         inputDataField("coldData", value);     }
    // public void inputHotWater(String value) {         inputDataField("hotData", value);     }
    // public void inputGas(String value) {         inputDataField("gasData", value);     }
    // public void inputElectric(String value) {         inputDataField("elecData", value);     }
    private By dateInput = By.xpath("//*[@id=\"date\"]");
    private By coldWaterInput = By.xpath("//*[@id=\"coldData\"]");
    private By hotWaterInput = By.xpath("//*[@id=\"hotData\"]");
    private By gasInput = By.xpath("//*[@id=\"gasData\"]");
    private By electricInput = By.xpath("//*[@id=\"elecData\"]");

    public void inputDate(String inputValue) {
        waitForElementClickable(driver.findElement(dateInput), driver);
        inputText(driver.findElement(dateInput), inputValue);
    }

    public void inputColdWater(String inputValue) {
        waitForElementClickable(driver.findElement(coldWaterInput), driver);
        inputText(driver.findElement(coldWaterInput), inputValue);
    }

    public void inputHotWater(String inputValue) {
        waitForElementClickable(driver.findElement(hotWaterInput), driver);
        inputText(driver.findElement(hotWaterInput), inputValue);
    }

    public void inputGas(String inputValue) {
        waitForElementClickable(driver.findElement(gasInput), driver);
        inputText(driver.findElement(gasInput), inputValue);
    }

    public void inputElectric(String inputValue) {
        waitForElementClickable(driver.findElement(electricInput), driver);
        inputText(driver.findElement(electricInput), inputValue);
    }


    //в приложении отсутствует resultValue поэтому такая аннотация, потом разберусь
    @Deprecated
    public short getResultValue() {
        return 0;
    }
}
