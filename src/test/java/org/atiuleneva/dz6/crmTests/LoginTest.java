package org.atiuleneva.dz6.crmTests;

import org.atiuleneva.dz6.BaseTest.BaseTest;
import org.atiuleneva.dz6.pages_crm.LoginPage;
import org.junit.jupiter.api.Test;

import static org.atiuleneva.dz6.Configuration.Configuration.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithBaseTest() {
        driver.get(CRM_URL + CRM_LOGIN_PATH);

        new LoginPage(driver)
                .enterLogin(LOGIN)
                .enterPassword(PASSWORD)
                .clickSubmit()
                .checkUrl(CRM_URL);
    }
}
