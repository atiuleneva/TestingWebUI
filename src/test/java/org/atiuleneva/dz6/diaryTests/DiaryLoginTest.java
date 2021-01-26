package org.atiuleneva.dz6.diaryTests;

import org.atiuleneva.dz6.BaseTest.BaseTest;
import org.atiuleneva.dz6.pages_diary.DiaryLoginPage;
import org.junit.jupiter.api.Test;

import static org.atiuleneva.dz6.Configuration.Configuration.*;

public class DiaryLoginTest extends BaseTest {
    @Test
    public void diaryLoginTest() {
        driver.get(DIARY_URL);

        new DiaryLoginPage(driver)
                .clickDropLogin()
                .enterLogin(LOGIN_MAIL)
                .enterPassword(PASSWORD_MAIL)
                .clickSubmit()
                .checkUrl(DIARY_URL);
    }
}
