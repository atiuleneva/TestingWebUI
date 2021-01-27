package org.atiuleneva.dz6.views_diary;

import org.atiuleneva.dz6.base.Base;
import org.atiuleneva.dz6.pages_diary.DiaryMailPage;
import org.atiuleneva.dz6.pages_diary.DiaryQuotPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiaryMenuBar extends Base {

    @FindBy(css = ".i-letter")
    WebElement emailMenuTab;

    @FindBy(css = "#drop")
    WebElement drop;

    @FindBy(css = "a[href=\"https://diary.ru/?quote\"]")
    WebElement quoteMenuItem;



    public DiaryMenuBar(WebDriver driver) { super(driver);}

    public DiaryMailPage navigateToEmailPage(){
        emailMenuTab.click();

        return new DiaryMailPage(driver);
    }

    public DiaryQuotPage navigateToQuot(){
        drop.click();
        quoteMenuItem.click();

        return new DiaryQuotPage(driver);
    }


}
