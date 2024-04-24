package ru.neoflex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendPage extends Element {

    public SendPage(WebDriver driver) {
        super(driver);
    }

    private By sendData = By.xpath("//*[@id=\"button\"]");


    public SendPage clickSendButton() {
        click(driver.findElement(sendData));
        return new SendPage(driver);
    }

    private By elecData = By.xpath("//*[@id=\"elecData\"]");
    private CharSequence value = "123";

    /* protected void type(By locator, String text) {
    click(locator);
    if (text != null) {
      String existingText = wd.findElement(locator).getAttribute("value");
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }*/
    public void fillElecData() {
        fillDataField(elecData,value);
    }

    private void fillDataField(By elecData, CharSequence value) {
        if (isElementPresent(this.elecData)) {
            driver.findElement(this.elecData).clear();
            driver.findElement(this.elecData).sendKeys(this.value);
        }
    }

    public String getElecData() {
        return "getElecData()";
    }
}
