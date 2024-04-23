package ru.neoflex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class PageNavigationTest extends TestBase {

    @Test
    public void FromMainToSendAndBack() throws InterruptedException {
        MainPage mainPage = new MainPage(applicationManager.driver);
        SendPage sendPage = new SendPage(applicationManager.driver);
        //mainPage.clickSend();
        MainPage mainPage1 = applicationManager.getMainPage();
        mainPage1.clickSend();
        //applicationManager.getMainPage().clickSend();
        Assertions.assertEquals(sendPage.getHeaderText(), "Передача показаний");
        sendPage.clickBackButton();
        //Assertions.assertEquals(mainPage.getHeaderText(), "Neo ЖКХ");
    }

    @Test

    public void FromMainToHistoryAndBack() throws InterruptedException {

        MainPage mainPage = new MainPage(applicationManager.driver);

        mainPage.clickHistory();

        Assertions.assertEquals(applicationManager.driver.findElement(By.xpath("/html/body/h1")).getText(), "История показаний");

        applicationManager.driver.findElement(By.xpath("//*[@id=\"back_button\"]")).click();

        Assertions.assertEquals(applicationManager.driver.findElement(By.xpath("/html/body/h1")).getText(), "Neo ЖКХ");

    }

    @Test

    public void FromMainToPriceAndBack() {

        MainPage mainPage = new MainPage(applicationManager.driver);

        mainPage.clickPrice();

        Assertions.assertEquals(applicationManager.driver.findElement(By.xpath("/html/body/h1")).getText(), "Справочник стоимости услуг");

        applicationManager.driver.findElement(By.xpath("//*[@id=\"back_button\"]")).click();

        Assertions.assertEquals(applicationManager.driver.findElement(By.xpath("/html/body/h1")).getText(), "Neo ЖКХ");

    }

}

/*
@BeforeEach - метод, помеченный данной аннотацией JUnit, будет выполняться перед каждым тестом
@Test - метод, помеченный данной аннотацией JUnit, является тестом
@AfterEach - метод, помеченный данной аннотацией JUnit, будет выполняться после каждого теста
        Assertions.assertEquals(X, Y) - метод JUnit для проверки эквивалентности результатов, где X - это фактический результат, а Y - это ожидаемый результат
        Работа серии этих тестов заключается в следующем:
        1) Запуск главной страницы сайта
        2) Нажатие на кнопку для перехода на соответствующую страницу
        3) Вычитывание названия страницы
        4) Сравнение текущего названия страницы с ожидаемым
        5) Нажатие на кнопку для перехода на главную страницу
        6) Вычитывание названия страницы
        7) Сравнение текущего названия страницы с ожидаемым
*/