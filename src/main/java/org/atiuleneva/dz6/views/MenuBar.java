package org.atiuleneva.dz6.views;

import org.atiuleneva.dz6.base.Base;
import org.atiuleneva.dz6.pages_crm.AllProjectsPage;
import org.atiuleneva.dz6.pages_crm.ContactsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuBar extends Base {

    // menu tabs
    @FindBy(css = ".dropdown:nth-child(3) > .unclickable > .title")
    WebElement menuProjects;

    @FindBy(css = ".nav .dropdown.first")
    public WebElement menuContragents;

    // menu items
    @FindBy(css = ".dropdown:nth-child(3) .single:nth-child(4) .title")
    public WebElement menuAllProjects;

    @FindBy(css = ".first .last .title")
    public WebElement menuContacts;

    public MenuBar(WebDriver driver) {
        super(driver);
    }

    public void moveToMenuTab(WebElement menuTab){
        actions.moveToElement(menuTab).perform();
    }

    public void clickMenuItem(WebElement menuItem){
        menuItem.click();
    }

    public AllProjectsPage navigateToAllProjects() {
        moveToMenuTab(menuProjects);
        clickMenuItem(menuAllProjects);

        return new AllProjectsPage(driver);
    }

    public ContactsPage navigateToContacts(){
        moveToMenuTab(menuContragents);
        clickMenuItem(menuContacts);

        return new ContactsPage(driver);
    }
}
