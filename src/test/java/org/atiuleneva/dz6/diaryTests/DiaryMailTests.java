package org.atiuleneva.dz6.diaryTests;

import org.atiuleneva.dz6.BaseTest.BaseTest;
import org.atiuleneva.dz6.pages_diary.DiaryHomePage;
import org.atiuleneva.dz6.pages_diary.DiaryLoginPage;
import org.atiuleneva.dz6.pages_diary.DiaryMailPage;
import org.junit.jupiter.api.Test;

import static org.atiuleneva.dz6.Configuration.Configuration.*;

public class DiaryMailTests extends BaseTest {
    @Test
    public void diaryMailPage(){
        driver.get(DIARY_URL);

        DiaryHomePage homePage = new DiaryLoginPage(driver).loginIfRequired(LOGIN_MAIL,PASSWORD_MAIL);
        DiaryMailPage mailPage = homePage.menuBar.navigateToEmailPage();

        mailPage
                .navigateToInboxFolder()
                .navigateToWelcomeLetter()
                .checkTextGoodWishes();
    }
}
