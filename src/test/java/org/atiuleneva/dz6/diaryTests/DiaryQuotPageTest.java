package org.atiuleneva.dz6.diaryTests;

import org.atiuleneva.dz6.BaseTest.BaseTest;
import org.atiuleneva.dz6.pages_diary.DiaryHomePage;
import org.atiuleneva.dz6.pages_diary.DiaryLoginPage;
import org.atiuleneva.dz6.pages_diary.DiaryQuotPage;
import org.junit.jupiter.api.Test;

import static org.atiuleneva.dz6.Configuration.Configuration.*;

public class DiaryQuotPageTest extends BaseTest {

   // @Test отключен из-за зависимости на DiaryNewsPageTest
    public void diaryDeleteQuotTest () {
        driver.get(DIARY_URL);

        DiaryHomePage homePage = new DiaryLoginPage(driver).loginIfRequired(LOGIN_MAIL, PASSWORD_MAIL);
        homePage.menuBar.navigateToQuot();

        new DiaryQuotPage(driver)
                .delTatu();
    }

}
