package org.atiuleneva.dz6.diaryTests;

import io.qameta.allure.Feature;
import org.atiuleneva.dz6.BaseTest.BaseTest;
import org.atiuleneva.dz6.pages_diary.DiaryHomePage;
import org.atiuleneva.dz6.pages_diary.DiaryLoginPage;
import org.atiuleneva.dz6.pages_diary.DiaryMailPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.atiuleneva.dz6.Configuration.Configuration.*;
@Feature("Diary: Testing mail ")
@DisplayName("Diary: Testing mail")
public class DiaryMailTests extends BaseTest {
    @Test
    @DisplayName("Checking incoming mail - positive test")
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
