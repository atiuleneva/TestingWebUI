package org.atiuleneva.dz6.pages_diary;

import org.atiuleneva.dz6.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiaryNewsPage extends Base {

    @FindBy(css = ".addToQuote a")
    WebElement addNewsToQuote;

    @FindBy(css = "div.postTitle.header > h1")
    WebElement tatu;
    public String tatuHeader;

    @FindBy(css = "#myQuotLink a")
    WebElement myQuotLink;

    public DiaryNewsPage(WebDriver driver) {
        super(driver);
    }

    public DiaryNewsPage addNews() throws InterruptedException {
        addNewsToQuote.click();
        Thread.sleep(3000);
        return this;
    }

    public DiaryNewsPage saveNewsHeader(){
        tatuHeader = tatu.getText();
        return this;
    }

    public DiaryQuotPage clickMyQuot(){
        myQuotLink.click();

        return new DiaryQuotPage(driver);
    }
}
