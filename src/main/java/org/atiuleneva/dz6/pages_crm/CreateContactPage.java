package org.atiuleneva.dz6.pages_crm;

import org.atiuleneva.dz6.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateContactPage extends Base {

    @FindBy(name = "crm_contact[lastName]")
    WebElement lastName;

    @FindBy(name = "crm_contact[firstName]")
    WebElement firstName;

    @FindBy(css="a.select2-choice")
    WebElement selectOrganisation;

    @FindBy(css="#select2-drop .select2-results li:nth-child(2)")
    WebElement organisationItem;

    @FindBy(name = "crm_contact[jobTitle]")
    WebElement jobTitle;

    @FindBy(css=".btn-group:nth-child(4) > .btn")
    WebElement createContact;

    public CreateContactPage(WebDriver driver) {
        super(driver);
    }

    public CreateContactPage enterLastName(String name){
        lastName.sendKeys(name);

        return this;
    }

    public CreateContactPage enterFirstName(String name){
        firstName.sendKeys(name);

        return this;
    }

    public CreateContactPage selectOrganisation (){
        selectOrganisation.click();
        organisationItem.click();

        return this;
    }

    public CreateContactPage selectJobTitleManager(){
        jobTitle.click();
        jobTitle.sendKeys("Manager");
        jobTitle.click();

        return this;
    }

    public ContactsPage saveContact(){
        createContact.click();

        return new ContactsPage(driver);

    }

}
