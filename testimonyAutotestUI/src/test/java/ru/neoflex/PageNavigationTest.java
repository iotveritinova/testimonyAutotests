package ru.neoflex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PageNavigationTest extends TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);

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
