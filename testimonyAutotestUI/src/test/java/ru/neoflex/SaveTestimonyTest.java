package ru.neoflex;

//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.neoflex.model.SendFormData;

import java.io.IOException;
import java.util.Iterator;

import static ru.neoflex.utils.DataProvider.sendPageTestData;

public class SaveTestimonyTest extends TestBase {
    //Использовать: Java, Selenium WebDriver
    //Создать java-класс, который будет выполнять перечисленные ниже действия:
    //1) Перейти с главной страницы сайта на страницу передачи показаний
    //2) Заполнить на странице передачи показаний все поля необходимыми данными
    //3) Нажать на кнопку для передачи данных формы

    public static Iterator<Object[]> dataRead() throws IOException {
        return sendPageTestData();
    }

    @MethodSource("dataRead")
 @ParameterizedTest
   // @Test
   // public void SaveTestimony() {
       public void SaveTestimony(SendFormData sendFormData) {

            applicationManager.getMainPage().clickSend();
        Assertions.assertEquals(applicationManager.getSendPage().getHeaderText(), "Передача показаний");
        String value="123";
        //String value=sendFormData.getElectric();
        System.out.println(value);
        applicationManager.getSendPage().inputDate(value);
        applicationManager.getSendPage().inputColdWater(value);
        applicationManager.getSendPage().inputHotWater(value);
        applicationManager.getSendPage().inputGas(value);
        applicationManager.getSendPage().inputElectric(value);
        applicationManager.getSendPage().clickSubmitButton();
        //для тестового приложения проверить значения полей кажется нельзя?
        Assertions.assertEquals(applicationManager.getSendPage().getHeaderText(), "Передача показаний");

    }
}
