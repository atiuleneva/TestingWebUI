package org.atiuleneva.dz6.pages_crm;

import org.atiuleneva.dz6.base.Base;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactsPage extends Base {

    public ContactsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (linkText = "Создать контактное лицо")
    WebElement createContacts;

    @FindBy(css = ".message")
    WebElement message;

    public CreateContactPage clickCreateContact(){
        createContacts.click();

        return new CreateContactPage(driver);
    }
    public ContactsPage checkContactSave()
    {
        String msg = message.getText();
        Assertions.assertEquals(msg, "Контактное лицо сохранено");
        return this;
    }
}
