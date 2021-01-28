package org.atiuleneva.dz6.diaryTests;

import io.qameta.allure.Feature;
import org.atiuleneva.dz6.BaseTest.BaseTest;
import org.atiuleneva.dz6.pages_diary.DiaryHomePage;
import org.atiuleneva.dz6.pages_diary.DiaryLoginPage;
import org.atiuleneva.dz6.pages_diary.DiaryNewsPage;
import org.atiuleneva.dz6.pages_diary.DiaryQuotPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.atiuleneva.dz6.Configuration.Configuration.*;

@Feature("Diary: Testing quotes")
@DisplayName("Diary: Testing quotes")
public class DiaryQuotTest extends BaseTest {

    @Test
    @DisplayName("Adding news to quote - positive test")
    public void diaryAddingNewsTest() throws InterruptedException {
        driver.get(DIARY_URL);

        DiaryHomePage homePage = new DiaryLoginPage(driver).loginIfRequired(LOGIN_MAIL,PASSWORD_MAIL);
        DiaryNewsPage newsPage = homePage.clickNews();

        DiaryQuotPage quotPage = newsPage
                .addNews()
                .saveNewsHeader()
                .clickMyQuot();
        quotPage.checkTatuQuot(newsPage.tatuHeader);
    }

    //отключен из-за зависимости на DiaryNewsPageTest
    @Test
    @DisplayName("Deleting news for a quote")
    public void diaryDeleteQuotTest () {
        driver.get(DIARY_URL);

        DiaryHomePage homePage = new DiaryLoginPage(driver).loginIfRequired(LOGIN_MAIL, PASSWORD_MAIL);
        homePage.menuBar.navigateToQuot();

        new DiaryQuotPage(driver)
                .delTatu();
    }

}
