package com.wrike;

import com.wrike.pages.HomePage;
import com.wrike.pages.VerifyPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class FirstTest {
    private static final int TIMEOUT = 10;
    private static final String PATH_TO_DRIVER = "/home/trusienkodv/Загрузки/geckodriver";

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", PATH_TO_DRIVER);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, TIMEOUT);
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void Test() {
        driver.get("https://www.wrike.com");
        HomePage homePage = new HomePage(driver, wait);
        VerifyPage verifyPage =
                homePage
                        .openFreeTrial()
                        .createWrikeAccount(String.format("%s+wpt@wriketask.qaa", Util.generateRandomString()));
        verifyPage
                .chooseRandomAnswers()
                .submitAnswers()
                .checkSuccess()
                .checkTwitter();
    }
}
