package ru.neoflex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element extends BasePage {
    private By header = By.xpath("/html/body/h1");
    private By backButton = By.xpath("//*[@id=\"back_button\"]");

    public Element(WebDriver driver) {
        super(driver);
    }

    public String getHeaderText() {
        return driver.findElement(header).getText();
    }

    public void clickBackButton() {
        waitForElementClickable(driver.findElement(backButton), driver);
        click(driver.findElement(backButton));
    }

    //заменим inputDataField на inputTest чтобы привести код в соответствие с уроком @FindBy и PageFactory
    protected void inputDataField(String fieldId, String value) {
        if (fieldId != null && value != null) {
            By dataField = By.xpath(String.format("//*[@id=\"%s\"]", fieldId));
            if (isElementPresent(dataField)) {
                driver.findElement(dataField).clear();
                driver.findElement(dataField).sendKeys(value);
            }
        }
    }

    protected void inputText(WebElement element, String value) {
        if (value != null) {
            element.clear();
            element.sendKeys(value);
        }
    }


}
