package org.atiuleneva.dz6.diaryTests;

import org.atiuleneva.dz6.BaseTest.BaseTest;
import org.atiuleneva.dz6.pages_diary.DiaryHomePage;
import org.atiuleneva.dz6.pages_diary.DiaryLoginPage;
import org.atiuleneva.dz6.pages_diary.DiaryNewsPage;
import org.atiuleneva.dz6.pages_diary.DiaryQuotPage;
import org.junit.jupiter.api.Test;

import static org.atiuleneva.dz6.Configuration.Configuration.*;

public class DiaryNewsPageTest extends BaseTest {

    @Test
    public void DearyNewsTest() throws InterruptedException {
        driver.get(DIARY_URL);

        DiaryHomePage homePage = new DiaryLoginPage(driver).loginIfRequired(LOGIN_MAIL,PASSWORD_MAIL);
        DiaryNewsPage newsPage = homePage.clickNews();

        DiaryQuotPage quotPage = newsPage
                .addNews()
                .saveNewsHeader()
                .clickMyQuot();
        quotPage.checkTatuQuot(newsPage.tatuHeader);
    }


}
