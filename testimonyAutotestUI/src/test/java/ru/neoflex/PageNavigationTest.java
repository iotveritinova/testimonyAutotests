package ru.neoflex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.neoflex.pages.MainPage;
import ru.neoflex.pages.SendPage;

public class PageNavigationTest extends TestBase {

    @Test
    public void TestOfRefactoring() throws InterruptedException {
        MainPage mainPage = new MainPage(applicationManager.driver);
        MainPage mainPage1 = applicationManager.getMainPage();
        if (mainPage1 == null) {
            System.out.println("this is null");
        } else {
            System.out.println(mainPage1.getHeaderText());
        }
    }

    @Test
    public void FromMainToSendAndBack() throws InterruptedException {
        //нужно отрефакторить PageNavigationTest пока не понятно почему applicationManager.getMainPage(); возвращает null
        //тут нужно будет убрать и по тексту заменить mainPage и sendPage по аналогии
        // на applicationManager.getMainPage() и applicationManager.getSendPage()
        // а пока я устал и сдаюсь
        MainPage mainPage = new MainPage(applicationManager.driver);
        SendPage sendPage = new SendPage(applicationManager.driver);
        //
        mainPage.clickSend();
        //applicationManager.getMainPage().clickSend();
        Assertions.assertEquals(sendPage.getHeaderText(), "Передача показаний");
        //эта строка пусть висит ее убрать в рамках урока про ожидание
        Thread.sleep(1000);
        sendPage.clickBackButton();
        Assertions.assertEquals(mainPage.getHeaderText(), "Neo ЖКХ");
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