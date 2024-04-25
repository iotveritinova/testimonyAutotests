package ru.neoflex.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;

public class SendPage extends Element {

    public SendPage(WebDriver driver) {
        super(driver);
    }

    private By sendData = By.xpath("//*[@id=\"button\"]");


    public SendPage clickSendButton() {
        click(driver.findElement(sendData));
        return new SendPage(driver);
    }

    private By date = By.xpath("//*[@id=\"date\"]");
    private By coldData = By.xpath("//*[@id=\"coldData\"]");
    private By hotData = By.xpath("//*[@id=\"hotData\"]");
    private By gasData = By.xpath("//*[@id=\"gasData\"]");
    private By elecData = By.xpath("//*[@id=\"elecData\"]");


    public void fillAllData() {
        String value = "678";
        //для даты нужно будет поменять формат но пока так
        String dateValue = String.valueOf(LocalDate.now());
      /*  {
            try {
                dateValue = String.valueOf(new SimpleDateFormat("dd-MM-yyyy")
                        .parse(String.valueOf(java.time.LocalDate.now())));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }*/
        fillDataField(date, dateValue);
        fillDataField(coldData, null);
        fillDataField(hotData, value);
        fillDataField(gasData, value);
        fillDataField(elecData, value);
    }

}
