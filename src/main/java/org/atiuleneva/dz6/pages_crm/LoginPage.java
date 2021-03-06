package org.atiuleneva.dz6.pages_crm;

import io.qameta.allure.Step;
import org.atiuleneva.dz6.base.Base;
import org.atiuleneva.dz6.pages_crm.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Base {
    @FindBy(css = "input#prependedInput")
    private WebElement inputLogin;

    @FindBy(css = "input#prependedInput2")
    private WebElement inputPassword;

    @FindBy(css = "input#remember_me")
    private WebElement remember;

    @FindBy(css = "button#_submit")
    private WebElement submit;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter Login")
    public LoginPage enterLogin (String login){
        inputLogin.sendKeys(login);
        return this;
    }
    @Step("Enter password")
    public LoginPage enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }
    @Step("Click Submit")
    public HomePage clickSubmit() {
        submit.click();
        return new HomePage(driver);
    }

}
