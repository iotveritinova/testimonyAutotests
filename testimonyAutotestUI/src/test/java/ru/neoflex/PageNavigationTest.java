package ru.neoflex;

import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class PageNavigationTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    //add allure
    //@Step - данная аннотация используется для обозначения тестового шага
    //@DisplayName - данная аннотация используется для того, чтобы задать название тестовому шагу
    //@Description - данная аннотация используется для того, чтобы задать описание к тестовому шагу
    //Для того, чтобы после выполнения теста сформировать отчёт и открыть его в браузере,
    // необходимо выполнить следующие действия:
    // 1) Открыть Terminal в IntelliJ IDEA
    // 2) Ввести команду: allure generate --clean
    // 3) Ввести команду: allure serve
    // 4) После выполнения команды allure serve откроется окно браузера
    // с отчётом по запущенным тестам
    @Step
    @DisplayName("Navigation test")
    @Description("Navigation test description")
    @Test
    public void FromMainToSendAndBack() {
        logger.info("Start FromMainToSendAndBack");
        applicationManager.getMainPage().clickSend();
        Assertions.assertEquals(applicationManager.getSendPage().getHeaderText(), "Передача показаний");
        applicationManager.getSendPage().clickBackButton();
        Assertions.assertEquals(applicationManager.getMainPage().getHeaderText(), "Neo ЖКХ");
        logger.info("End FromMainToSendAndBack");
    }

    @Test
    public void FromMainToHistoryAndBack() {
        applicationManager.getMainPage().clickHistory();
        Assertions.assertEquals(applicationManager.getHistoryPage().getHeaderText(), "История показаний");
        applicationManager.getHistoryPage().clickBackButton();
        Assertions.assertEquals(applicationManager.getMainPage().getHeaderText(), "Neo ЖКХ");
    }

    @Test
    public void FromMainToPriceAndBack() {
        applicationManager.getMainPage().clickPrice();
        Assertions.assertEquals(applicationManager.getPricePage().getHeaderText(), "Справочник стоимости услуг");
        applicationManager.getPricePage().clickBackButton();
        Assertions.assertEquals(applicationManager.getMainPage().getHeaderText(), "Neo ЖКХ");
    }
}
