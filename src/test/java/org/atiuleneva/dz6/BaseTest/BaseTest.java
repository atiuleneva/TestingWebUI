package org.atiuleneva.dz6.BaseTest;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.atiuleneva.dz5.DZ5_Selenium2Test;
import org.atiuleneva.dz6.helpers.Screenshot;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static org.atiuleneva.dz6.Configuration.Configuration.CRM_LOGIN_PATH;
import static org.atiuleneva.dz6.Configuration.Configuration.CRM_URL;

public abstract class BaseTest {

    protected EventFiringWebDriver driver;
    protected RemoteWebDriver realDriver;

    public static Logger logger = LoggerFactory.getLogger(WebDriver.class);

    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        realDriver = new ChromeDriver(options);
        realDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        realDriver.manage().window().maximize();
        realDriver.setLogLevel(Level.INFO);


        driver = new EventFiringWebDriver(realDriver);
        driver.register(new CustomEventListener());

        logger.info("++++++======= beforeTest =========+++++++");
//        logger.info("++++++======= beforeTest =========+++++++");
//        logger.trace("++++++======= trace beforeTest =========+++++++");
//        logger.error("++++++======= trace beforeTest =========+++++++");
    }

    @AfterEach
    public void tearDown() {
        driver
                .manage()
                .logs()
                .get(LogType.BROWSER)
                .getAll()
                .forEach(System.out::println);
        driver.quit();
    }

    public class CustomEventListener implements WebDriverEventListener
    {

        @Override
        public void beforeAlertAccept(WebDriver webDriver) {

        }

        @Override
        public void afterAlertAccept(WebDriver webDriver) {

        }

        @Override
        public void afterAlertDismiss(WebDriver webDriver) {

        }

        @Override
        public void beforeAlertDismiss(WebDriver webDriver) {

        }

        @Override
        public void beforeNavigateTo(String s, WebDriver webDriver) {

        }

        @Override
        public void afterNavigateTo(String s, WebDriver webDriver)
        {
            logger.info("Navigated to: " + s);
        }

        @Override
        public void beforeNavigateBack(WebDriver webDriver) {

        }

        @Override
        public void afterNavigateBack(WebDriver webDriver) {

        }

        @Override
        public void beforeNavigateForward(WebDriver webDriver) {

        }

        @Override
        public void afterNavigateForward(WebDriver webDriver) {

        }

        @Override
        public void beforeNavigateRefresh(WebDriver webDriver) {

        }

        @Override
        public void afterNavigateRefresh(WebDriver webDriver) {

        }

        @Override
        public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

        }

        @Override
        public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

        }

        @Override
        public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

        }

        @Override
        public void afterClickOn(WebElement webElement, WebDriver webDriver) {

        }

        @Override
        public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

        }

        @Override
        public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

        }

        @Override
        public void beforeScript(String s, WebDriver webDriver) {

        }

        @Override
        public void afterScript(String s, WebDriver webDriver) {

        }

        @Override
        public void beforeSwitchToWindow(String s, WebDriver webDriver) {

        }

        @Override
        public void afterSwitchToWindow(String s, WebDriver webDriver) {

        }

        @Override
        public void onException(Throwable throwable, WebDriver webDriver) {
            String fileName = "failure-screenshot-" + System.currentTimeMillis() + ".png";
            Screenshot.makeScreenshot(driver, fileName);
            logger.error("onException: Screenshot saved in target/" + fileName);
        }

        @Override
        public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

        }

        @Override
        public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

        }

        @Override
        public void beforeGetText(WebElement webElement, WebDriver webDriver) {

        }

        @Override
        public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

        }
    }
}
