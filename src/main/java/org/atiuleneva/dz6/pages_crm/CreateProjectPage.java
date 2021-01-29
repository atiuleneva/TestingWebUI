package org.atiuleneva.dz6.pages_crm;

import io.qameta.allure.Step;
import org.atiuleneva.dz6.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateProjectPage extends Base {
    @FindBy (name = "crm_project[name]")
    WebElement projectName;

    @FindBy(css = ".select2-default > .select2-chosen")
    WebElement selectOrganisation;

    @FindBy (css = "#select2-drop .select2-input")
    WebElement selectOrganisationFilter;

    @FindBy(css = "#select2-drop ul li.select2-highlighted")
    WebElement filteredOrganisationItem;

    @FindBy(name = "crm_project[businessUnit]")
    WebElement businessUnit;

    @FindBy(name = "crm_project[curator]")
    WebElement curator;

    @FindBy(name="crm_project[rp]")
    WebElement projectRP;

    @FindBy(name = "crm_project[manager]")
    WebElement manager;

    @FindBy(css = ".row-fluid-divider .responsive-cell:nth-child(4) .select2:nth-child(1) a")
    WebElement contact;

    @FindBy(css = "#select2-drop .select2-results li:nth-child(1)")
    WebElement selectContact;

    @FindBy(css = ".btn-group:nth-child(4) > .btn")
    WebElement saveProject;

    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter project name")
    public CreateProjectPage enterProjectName(String name){
        projectName.sendKeys(name);
        return this;
    }

    @Step("Select organisation")
    public CreateProjectPage selectOrganisation(String org){
        selectOrganisation.click();

        selectOrganisationFilter.click();
        selectOrganisationFilter.sendKeys(org);
        wait10second.until(
                ExpectedConditions.visibilityOf(
                        driver.findElement(By.cssSelector("#select2-drop ul li.select2-highlighted"))));
        selectOrganisationFilter.sendKeys(Keys.RETURN);

        return this;
    }

    @Step("Select business unit")
    public  CreateProjectPage selectBusinessUnit(String bunit){
        businessUnit.click();
        businessUnit.sendKeys(bunit);
        businessUnit.click();

        return this;
    }

    @Step("Select curator")
    public CreateProjectPage selectCurator(String curat){
        curator.click();
        curator.sendKeys(curat);
        curator.click();

        return this;
    }

    @Step("Select project manager")
    public CreateProjectPage selectRP(String rp){
        projectRP.click();
        projectRP.sendKeys(rp);
        projectRP.click();

        return this;
    }

    @Step("Select manager")
    public CreateProjectPage selectManager(String manag){
        manager.click();
        manager.sendKeys(manag);
        manager.click();

        return this;
    }

    @Step("Select contact")
    public CreateProjectPage selectContact() throws InterruptedException {
        contact.click();
        Thread.sleep(3000);
        selectContact.click();

        return this;
    }

    @Step("Save project")
    public AllProjectsPage saveProject(){
        saveProject.click();

        return new AllProjectsPage(driver);
    }

}
