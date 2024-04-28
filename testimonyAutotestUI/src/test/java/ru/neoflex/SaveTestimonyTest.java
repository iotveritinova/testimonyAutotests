package ru.neoflex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.neoflex.model.SendFormData;
import ru.neoflex.utils.Table;

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
    public void SaveTestimony(SendFormData sendFormData) {
        applicationManager.getMainPage().clickSend();
        applicationManager.getSendPage().inputDate(sendFormData.getDate());
        applicationManager.getSendPage().inputColdWater(sendFormData.getColdWater());
        applicationManager.getSendPage().inputHotWater(sendFormData.getHotWater());
        applicationManager.getSendPage().inputGas(sendFormData.getGas());
        applicationManager.getSendPage().inputElectric(sendFormData.getElectric());
        applicationManager.getSendPage().clickSubmitButton();
        //для тестового приложения проверить значения полей кажется нельзя?,
        //в приложении отсутствует resultValue поэтому такая аннотация, потом разберусь
        //Assertions.assertEquals(applicationManager.getSendPage().getResultValue(), sendFormData.getResultValue());
        //Использовать: Java, JUnit, Selenium WebDriver
        // Создать тест, который будет выполнять перечисленные ниже действия:
        // 1) Перейти с главной страницы сайта на страницу передачи показаний
        // 2) Заполнить на странице передачи показаний все поля необходимыми данными
        // 3) Нажать на кнопку для передачи данных формы
        //---это уже было реализовано, дальше:
        // 4) Проверить каждую ячейку таблицы, на наличие в ней значений (isEmpty())
        Table table = applicationManager.getSendPage().getResultTable();
        Assertions.assertEquals(table.getValueFromCell(0, 1).isEmpty(), false);//Расчётный период
        Assertions.assertEquals(table.getValueFromCell(1, 1).isEmpty(), false);//Холодная вода
        Assertions.assertEquals(table.getValueFromCell(2, 1).isEmpty(), false);//Горячая вода
        Assertions.assertEquals(table.getValueFromCell(3, 1).isEmpty(), false);//Газ
        Assertions.assertEquals(table.getValueFromCell(4, 1).isEmpty(), false);//Электричество
        Assertions.assertEquals(table.getValueFromCell(5, 1).isEmpty(), false);//Итого
    }
}

