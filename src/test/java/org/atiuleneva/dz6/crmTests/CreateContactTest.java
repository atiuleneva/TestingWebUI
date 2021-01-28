package org.atiuleneva.dz6.crmTests;

import io.qameta.allure.Feature;
import org.atiuleneva.dz6.BaseTest.BaseTest;
import org.atiuleneva.dz6.pages_crm.ContactsPage;
import org.atiuleneva.dz6.pages_crm.CreateContactPage;
import org.atiuleneva.dz6.pages_crm.HomePage;
import org.atiuleneva.dz6.pages_crm.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.atiuleneva.dz6.Configuration.Configuration.*;

@Feature("CRM: Testing create contact functionality")
@DisplayName("CRM: Testing create contact functionality")
public class CreateContactTest extends BaseTest {
    @Test
    @DisplayName("Create contact - positive test")
    public void createContactTest() throws InterruptedException {
        //login
        driver.get(CRM_URL + CRM_LOGIN_PATH);

        new LoginPage(driver)
                .enterLogin(LOGIN)
                .enterPassword(PASSWORD)
                .clickSubmit();

        driver.get(CRM_URL);
        HomePage home = new HomePage(driver);
        ContactsPage contactsPg = home.menuBar.navigateToContacts();
        CreateContactPage createContactPg = contactsPg.clickCreateContact();

        createContactPg
                .enterLastName("Ivanov")
                .enterFirstName("Ivan")
                .selectOrganisation()
                .selectJobTitleManager()
                .saveContact()
                .checkContactSave();
    }
}
