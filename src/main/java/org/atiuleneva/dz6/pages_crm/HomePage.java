package org.atiuleneva.dz6.pages_crm;

import io.qameta.allure.Step;
import org.atiuleneva.dz6.base.Base;
import org.atiuleneva.dz6.views.MenuBar;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Base {
    @FindBy(css = "#unknownElement")
    WebElement unknownElement;

    public MenuBar menuBar;

    @Step("Check url")
    public void checkUrl(String url) {
        Assertions.assertEquals(driver.getCurrentUrl(), url);
    }

    @Step("Generate WebDriver exception")
    public void generateWebDriverException() {
        unknownElement.click();
    }

    public HomePage(WebDriver driver) {
        super(driver);
        menuBar = new MenuBar(driver);
    }
}
