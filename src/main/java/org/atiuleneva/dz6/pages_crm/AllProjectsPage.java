package org.atiuleneva.dz6.pages_crm;

import org.atiuleneva.dz6.base.Base;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProjectsPage extends Base {

    @FindBy(css = "a.btn[href='/project/create/']")
    WebElement createProject;

    @FindBy(css = ".message")
    WebElement message;

    public AllProjectsPage(WebDriver driver) {
        super(driver);
    }

    public CreateProjectPage clickCreateProject()
    {
        createProject.click();

        return new CreateProjectPage(driver);
    }

    public AllProjectsPage checkProjectSave()
    {
        String msg = message.getText();
        Assertions.assertEquals(msg, "Проект сохранен");
        return this;
    }
}
