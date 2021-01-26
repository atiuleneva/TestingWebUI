package org.atiuleneva.dz6.pages_diary;

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

    public DiaryQuotPage checkTatuQuot(String header){
        String quoteTitle = tatu.getText();

        Assertions.assertEquals(header, quoteTitle);
        return this;
    }

    public DiaryQuotPage delTatu(){
        delToQuote.click();
        driver.navigate().refresh();

        return this;
    }
}
