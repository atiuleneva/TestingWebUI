package org.atiuleneva.dz6.pages_diary;

import org.atiuleneva.dz6.base.Base;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DiaryMailPage extends Base {

    @FindBy (linkText = "Входящие")
    WebElement linkInboxFolder;

    @FindBy (linkText = "Добро пожаловать на Diary.ru!")
    WebElement linkWelcomeLetter;

    @FindBy(css = "h1:nth-child(1)")
    WebElement textGoodWishes;

    public DiaryMailPage(WebDriver driver) {super(driver);}

    public DiaryMailPage navigateToInboxFolder(){
        linkInboxFolder.click();

        return this;
    }

    public DiaryMailPage navigateToWelcomeLetter(){
        linkWelcomeLetter.click();

        return this;
    }

    public DiaryMailPage checkTextGoodWishes(){
        String text = textGoodWishes.getText();
        Assertions.assertEquals(text,"Желаем приятных знакомств и легкой работы на сайте!");

        return this;
    }

}
