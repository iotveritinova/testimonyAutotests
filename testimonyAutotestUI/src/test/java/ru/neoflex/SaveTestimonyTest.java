package ru.neoflex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.ParseException;

public class SaveTestimonyTest extends TestBase {
    //Использовать: Java, Selenium WebDriver
    //Создать java-класс, который будет выполнять перечисленные ниже действия:
    //1) Перейти с главной страницы сайта на страницу передачи показаний
    //2) Заполнить на странице передачи показаний все поля необходимыми данными
    //3) Нажать на кнопку для передачи данных формы

    @Test
    public void SaveTestimony() {
        applicationManager.getMainPage().clickSend();
        Assertions.assertEquals(applicationManager.getSendPage().getHeaderText(), "Передача показаний");
        applicationManager.getSendPage().fillAllData();
        applicationManager.getSendPage().clickSendButton();
        //для тестового приложения проверить значения полей кажется нельзя?
        Assertions.assertEquals(applicationManager.getSendPage().getHeaderText(), "Передача показаний");

    }
}
