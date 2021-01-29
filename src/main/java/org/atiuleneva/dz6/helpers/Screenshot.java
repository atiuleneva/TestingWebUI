package org.atiuleneva.dz6.helpers;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {
    public static void makeScreenshot(WebDriver driver, String filename) {
        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destination = new File("./target/screenshot/" + filename);
        try {
            FileUtils.copyFile(temp, destination);
            Allure.addAttachment("Screenshot: ", FileUtils.openInputStream(destination));
        } catch (IOException exception){
            exception.printStackTrace();
        }

    }
}
