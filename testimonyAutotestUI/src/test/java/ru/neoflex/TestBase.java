package ru.neoflex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.neoflex.manager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager applicationManager = new ApplicationManager();

    @BeforeEach
    public void setupPage() throws InterruptedException {
        applicationManager.init();
    }

    @AfterEach
    public void closePage() throws InterruptedException {
        Thread.sleep(2000);
        applicationManager.close();
    }

}
