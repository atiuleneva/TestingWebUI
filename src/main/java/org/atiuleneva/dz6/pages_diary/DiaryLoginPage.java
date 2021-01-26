package org.atiuleneva.dz6.pages_diary;

import org.atiuleneva.dz6.base.Base;
import org.atiuleneva.dz6.pages_crm.HomePage;
import org.jsoup.Connection;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiaryLoginPage extends Base {

    @FindBy(css = "#drop-login")
    WebElement dropLogin;

    @FindBy(css = "#usrlog2")
    WebElement inputLogin;

    @FindBy(css = "#usrpass2")
    WebElement inputPassword;

    @FindBy(css = ".btn-plain:nth-child(7)")
    WebElement submit;

    public DiaryLoginPage(WebDriver driver) { super(driver); }

    public DiaryLoginPage clickDropLogin(){
        dropLogin.click();

        return this;
    }

    public DiaryLoginPage enterLogin(String login){
        inputLogin.sendKeys(login);

        return this;
    }

    public DiaryLoginPage enterPassword(String password){
        inputPassword.sendKeys(password);

        return this;
    }

    public DiaryHomePage clickSubmit() {
        submit.click();
        return new DiaryHomePage(driver);
    }

    public DiaryHomePage loginIfRequired(String user, String password){
        try {
            dropLogin.click();
        }
        catch (NoSuchElementException e){
            return new DiaryHomePage(driver); // пользователь уже залогинен
        }

        enterLogin(user);
        enterPassword(password);
        return clickSubmit();
    }
}
