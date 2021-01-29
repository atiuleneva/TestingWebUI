package org.atiuleneva.dz6.pages_diary;

import io.qameta.allure.Step;
import org.atiuleneva.dz6.base.Base;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiaryQuotPage extends Base {

    @FindBy(xpath = "//h2[text()='Тату-конвенция']")
    WebElement tatu;

    @FindBy(css = "li.delFromQuote a")
    WebElement delToQuote;

    public DiaryQuotPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check Тату-конвенция quot")
    public DiaryQuotPage checkTatuQuot(String header){
        String quoteTitle = tatu.getText();

        Assertions.assertEquals(header, quoteTitle);
        return this;
    }

    @Step("Click delete Тату-конвенция")
    public DiaryQuotPage delTatu(){
        delToQuote.click();
        driver.navigate().refresh();

        return this;
    }
}
