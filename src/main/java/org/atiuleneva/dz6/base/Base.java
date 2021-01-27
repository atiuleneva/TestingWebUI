package org.atiuleneva.dz6.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Base {
    protected WebDriver driver;
    protected WebDriverWait wait10second;
    protected WebDriverWait wait30second;
    protected Actions actions;

    public Base(WebDriver driver) {
        this.driver = driver;
        this.wait10second = new WebDriverWait(driver, 10);
        this.wait30second = new WebDriverWait(driver, 30);
        this.actions = new Actions(driver);

        PageFactory.initElements(driver, this);
    }
}
