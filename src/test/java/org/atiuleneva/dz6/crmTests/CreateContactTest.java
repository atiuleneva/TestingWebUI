package org.atiuleneva.dz6.crmTests;

import org.atiuleneva.dz6.BaseTest.BaseTest;
import org.atiuleneva.dz6.pages_crm.ContactsPage;
import org.atiuleneva.dz6.pages_crm.CreateContactPage;
import org.atiuleneva.dz6.pages_crm.HomePage;
import org.atiuleneva.dz6.pages_crm.LoginPage;
import org.junit.jupiter.api.Test;

import static org.atiuleneva.dz6.Configuration.Configuration.*;

public class CreateContactTest extends BaseTest {
    @Test
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
