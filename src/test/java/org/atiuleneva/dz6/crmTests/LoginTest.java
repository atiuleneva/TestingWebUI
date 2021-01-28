package org.atiuleneva.dz6.crmTests;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.atiuleneva.dz6.BaseTest.BaseTest;
import org.atiuleneva.dz6.pages_crm.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.atiuleneva.dz6.Configuration.Configuration.*;

@Feature("CRM: Testing login functionality")
@DisplayName("CRM: Testing login functionality")
public class LoginTest extends BaseTest {

    @DisplayName("Login base scenario - Positive test")
    @Test
    public void loginWithBaseTest() {
        driver.get(CRM_URL + CRM_LOGIN_PATH);

        new LoginPage(driver)
                .enterLogin(LOGIN)
                .enterPassword(PASSWORD)
                .clickSubmit()
                .checkUrl(CRM_URL);
    }

    @DisplayName("Login test to check screenshot - webdriver exception")
    @Test
    public void loginToTestScreenshot() {
        driver.get(CRM_URL + CRM_LOGIN_PATH);

        new LoginPage(driver)
                .enterLogin(LOGIN)
                .enterPassword(PASSWORD)
                .clickSubmit()
                .generateWebDriverException();
    }
}
