package ru.neoflex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import ru.neoflex.manager.ApplicationManager;

import java.io.IOException;

public class TestBase {

    protected final ApplicationManager applicationManager = new ApplicationManager();

    @BeforeEach
    public void setupPage() throws IOException {
        applicationManager.init();
    }

    @AfterEach
    public void closePage() throws InterruptedException {
        Thread.sleep(2000);
        applicationManager.close();
    }

}
