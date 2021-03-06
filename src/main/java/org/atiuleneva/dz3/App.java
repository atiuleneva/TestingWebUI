package org.atiuleneva.dz3;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.security.Key;
import java.util.concurrent.TimeUnit;

public class App
{
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";
    private static final String LOGIN = "Applanatest";
    private static final String PASSWORD = "Student2020!";
    private static WebDriver driver;
    private static final String LOGIN_PAGE2_URL = "https://www.diary.ru";
    public static final String LOGIN_MAIL = "bej53625";
    public static final String PASSWORD_MAIL = "859f1#ff4";



    public static void main( String[] args ) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        Test_CreateProject();
        Thread.sleep(5000); //использую, чтобы была видна остановка между тестами
        Test_CreateContact();
        Thread.sleep(5000); // таймаут между тестами
        Test_CreateMail();
        Thread.sleep(5000); // таймаут между тестами
        Test_CheckEmail();
        Thread.sleep(3000); // таймаут между тестами
        driver.quit();
    }

    public static void Test_CreateProject() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver.get(LOGIN_PAGE_URL);

        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement el = null;
        // вход в учетную запись
        el = driver.findElement(new By.ById("prependedInput"));
        el.sendKeys(LOGIN);

        el = driver.findElement(new By.ById("prependedInput2"));
        el.sendKeys(PASSWORD);

        el = driver.findElement(new By.ById("remember_me"));
        el.click();

        el = driver.findElement(new By.ById("_submit"));
        el.click();

        // переход в Создание проекта
        el = driver.findElement(new By.ByCssSelector(".dropdown:nth-child(3) > .unclickable > .title"));
        actions.moveToElement(el).perform();

        el = driver.findElement(new By.ByCssSelector(".dropdown:nth-child(3) .single:nth-child(4) .title"));
        el.click();

        el = driver.findElement(new By.ByCssSelector("a.btn[href='/project/create/']"));
        el.click();

        String projectName = "Test_" + Math.floor(Math.random()*9999);
        el = driver.findElement(new By.ByName("crm_project[name]"));
        el.sendKeys(projectName);

        el = driver.findElement(new By.ByCssSelector(".select2-default > .select2-chosen"));
        el.click();

//        el = driver.findElement(new By.ById("select2-drop-mask"));
//        el.click();

        el = driver.findElement(By.cssSelector("#select2-drop .select2-input"));
        el.click();
        el.sendKeys("Test Organisation_1");
        new WebDriverWait(driver, 3).until(
                ExpectedConditions.visibilityOf(
                        driver.findElement(By.cssSelector("#select2-drop ul li.select2-highlighted"))));
        el.sendKeys(Keys.RETURN);

//        el = driver.findElement(new By.ByCssSelector(".lang-ru"));
//        el.click();

        el = driver.findElement(By.name("crm_project[businessUnit]"));
        el.click();
        el.sendKeys("Research & Development");
        el.click();

        el = driver.findElement(new By.ByName("crm_project[curator]"));
        el.click();
        el.sendKeys("Student Student Stu");
        el.click();

        el = driver.findElement(new By.ByName("crm_project[rp]"));
        el.click();
        el.sendKeys("Student Student Stu");
        el.click();

        el = driver.findElement(new By.ByName("crm_project[manager]"));
        el.click();
        el.sendKeys("Student Student Stu");
        el.click();

        el = driver.findElement(new By.ByCssSelector(".row-fluid-divider .responsive-cell:nth-child(4) .select2:nth-child(1) a"));
        el.click();

        //Thread.sleep(3000);
        el = driver.findElement(new By.ByCssSelector("#select2-drop .select2-results li:nth-child(1)"));
        el.click();

        el = driver.findElement(new By.ByCssSelector(".btn-group:nth-child(4) > .btn"));
        el.click();
    }

    public static void Test_CreateContact(){
        driver.get(LOGIN_PAGE_URL);

        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement el = null;
        el = driver.findElement(new By.ById("prependedInput"));
        el.sendKeys(LOGIN);

        el = driver.findElement(new By.ById("prependedInput2"));
        el.sendKeys(PASSWORD);

        el = driver.findElement(new By.ById("_submit"));
        el.click();

        el = driver.findElement(new By.ByCssSelector(".nav .dropdown.first"));
        actions.moveToElement(el).perform();

        el = driver.findElement(By.cssSelector(".first .last .title"));
        el.click();

        el = driver.findElement(By.linkText("Создать контактное лицо"));
        el.click();

        el = driver.findElement(By.name("crm_contact[lastName]"));
        el.click();
        el.sendKeys("Ivanov");

        el = driver.findElement(By.name("crm_contact[firstName]"));
        el.click();
        el.sendKeys("Ivan");

        el = driver.findElement(By.cssSelector("a.select2-choice"));
        el.click();

        el = driver.findElement(By.cssSelector("#select2-drop .select2-results li:nth-child(2)"));
        el.click();

        el = driver.findElement(By.name("crm_contact[jobTitle]"));
        el.click();
        el.sendKeys("Manager");

        el = driver.findElement(By.cssSelector(".btn-group:nth-child(4) > .btn"));
        el.click();



    }

    public static void Test_CreateMail() {
        driver.get(LOGIN_PAGE2_URL);

        driver.manage().window().maximize();

        WebElement el = null;

        el = driver.findElement(By.id("drop-login"));
        el.click();

        el = driver.findElement(By.id("usrlog2"));
        el.click();
        el.sendKeys(LOGIN_MAIL);

        el = driver.findElement(By.id("usrpass2"));
        el.click();
        el.sendKeys(PASSWORD_MAIL);

        el = driver.findElement(By.cssSelector(".btn-plain:nth-child(7)"));
        el.click();

    }

    public static void Test_CheckEmail () {
        driver.get(LOGIN_PAGE2_URL);

        driver.manage().window().maximize();

        WebElement el = null;

        el = driver.findElement(By.cssSelector(".i-letter"));
        el.click();

        el = driver.findElement(By.linkText("Входящие"));
        el.click();

        el = driver.findElement(By.linkText("Добро пожаловать на Diary.ru!"));
        el.click();

        el = driver.findElement(By.cssSelector("h1:nth-child(1)"));
        el.click();



    }


}
