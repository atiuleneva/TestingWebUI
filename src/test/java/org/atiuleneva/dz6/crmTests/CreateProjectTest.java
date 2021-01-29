package org.atiuleneva.dz6.crmTests;

import io.qameta.allure.Feature;
import org.atiuleneva.dz6.BaseTest.BaseTest;
import org.atiuleneva.dz6.base.Base;
import org.atiuleneva.dz6.pages_crm.AllProjectsPage;
import org.atiuleneva.dz6.pages_crm.CreateProjectPage;
import org.atiuleneva.dz6.pages_crm.HomePage;
import org.atiuleneva.dz6.pages_crm.LoginPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.atiuleneva.dz6.Configuration.Configuration.*;

@Feature("CRM: Testing create project functionality")
@DisplayName("CRM: Testing create project functionality")
public class CreateProjectTest extends BaseTest {
    @Test
    @DisplayName("Create project - positive test")
    public void createProjectTest() throws InterruptedException {
        //login
        driver.get(CRM_URL + CRM_LOGIN_PATH);

        new LoginPage(driver)
                .enterLogin(LOGIN)
                .enterPassword(PASSWORD)
                .clickSubmit();

        driver.get(CRM_URL);

        HomePage home = new HomePage(driver);
        AllProjectsPage allPrj = home.menuBar.navigateToAllProjects();
        CreateProjectPage createPrj = allPrj.clickCreateProject();

        String projectName = "Test_" + Math.floor(Math.random()*9999);
        createPrj
                .enterProjectName(projectName)
                .selectOrganisation("Test Organisation_1")
                .selectBusinessUnit("Research & Development")
                .selectCurator("Student Student Stu")
                .selectRP("Student Student Stu")
                .selectManager("Student Student Stu")
                .selectContact()
                .saveProject()
                .checkProjectSave();
    }
}
