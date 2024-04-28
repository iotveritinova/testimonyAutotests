package ru.neoflex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.neoflex.utils.Table;

public class SendPage extends Element {

    private By sendData = By.xpath("//*[@id=\"button\"]");

    public SendPage(WebDriver driver) {
        super(driver);
        // для инициализации элементов помеченных аннотацией @FindBy
        PageFactory.initElements(driver, this);
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
    //
    // Все это можно упростить использую аннотацию @FindBy реализовав фабрику веб элементов. Для этого заменим
    //private By coldWaterInput = By.xpath("//*[@id='coldData']");
    //на
    //@FindBy(xpath = "//*[@id='coldData']")
    //private WebElement coldWaterInput;

    @FindBy(xpath = "//*[@id=\"date\"]")
    private WebElement dateInput;

    @FindBy(xpath = "//*[@id='coldData']")
    private WebElement coldWaterInput;

    @FindBy(xpath = "//*[@id=\"hotData\"]")
    private WebElement hotWaterInput;

    @FindBy(xpath = "//*[@id=\"gasData\"]")
    private WebElement gasInput;

    @FindBy(xpath = "//*[@id=\"elecData\"]")
    private WebElement electricInput;

    public void inputDate(String inputValue) {
        waitForElementClickable(dateInput, driver);
        inputText(dateInput, inputValue);
    }

    public void inputColdWater(String inputValue) {
        waitForElementClickable(coldWaterInput, driver);
        inputText(coldWaterInput, inputValue);
    }

    public void inputHotWater(String inputValue) {
        waitForElementClickable(hotWaterInput, driver);
        inputText(hotWaterInput, inputValue);
    }

    public void inputGas(String inputValue) {
        waitForElementClickable(gasInput, driver);
        inputText(gasInput, inputValue);
    }

    public void inputElectric(String inputValue) {
        waitForElementClickable(electricInput, driver);
        inputText(electricInput, inputValue);
    }


    //в приложении отсутствует resultValue поэтому такая аннотация, потом разберусь
    @Deprecated
    public short getResultValue() {
        return 0;
    }

    public Table getResultTable() {
        return new Table(driver.findElement(By.xpath("//*[@id=\"table\"]")), driver);
    }

}
