package org.atiuleneva.dz6.pages_crm;

import org.atiuleneva.dz6.base.Base;
import org.atiuleneva.dz6.views.MenuBar;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class HomePage extends Base {
    public MenuBar menuBar;

    public void checkUrl(String url) {
        Assertions.assertEquals(driver.getCurrentUrl(), url);
    }

    public HomePage(WebDriver driver) {
        super(driver);
        menuBar = new MenuBar(driver);
    }
}
