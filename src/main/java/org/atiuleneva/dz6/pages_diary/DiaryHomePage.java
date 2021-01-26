package org.atiuleneva.dz6.pages_diary;

import org.atiuleneva.dz6.base.Base;
import org.atiuleneva.dz6.views_diary.DiaryMenuBar;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiaryHomePage extends Base {

    public DiaryMenuBar menuBar;

    @FindBy(css = "#page_content > div:nth-child(4) > div:nth-child(3) .item:nth-child(4) a")
    WebElement selectNews;

    public DiaryHomePage(WebDriver driver) {
        super(driver);
        menuBar = new DiaryMenuBar(driver);
    }

    public void checkUrl(String url) {
        Assertions.assertEquals(driver.getCurrentUrl(), url+"/");
    }

    public DiaryNewsPage clickNews(){
        selectNews.click();

        return new DiaryNewsPage(driver);

    }
}
