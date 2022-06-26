package com.cydeo.test.shortVideos;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUpload {
    @Test
    public void testFileUpload() throws InterruptedException {
        Driver.getDriver().get("http://practice.cydeo.com/upload");

        String filePath  = "/Users/annachevelenkova/Desktop";

        Driver.getDriver().findElement(By.id("file-upload")).sendKeys(filePath);

        Thread.sleep(5000);

        WebElement uploadElement  = Driver.getDriver().findElement(By.id("file-submit"));
        uploadElement.click();
        Thread.sleep(5000);
    }
}
