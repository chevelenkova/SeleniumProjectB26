package com.cydeo.test.day15_upload_actions;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Guru99_Upload_Test {
    //    1. Go to “http://demo.guru99.com/test/upload”
//    2. Upload file into Choose File
//    3. Click terms of service checkbox
//    4. Click Submit File button
//    5. Verify expected message appeared.
//    Expected: “1 file
//    has been successfully uploaded.”

    @Test
    public void upload_file_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("guru99"));
        WebElement chooseFile = Driver.getDriver().findElement(By.id("uploadfile_0"));
        String path = "/Users/annachevelenkova/Desktop/Screen Shot 2022-06-18 at 3.12.19 PM.png";
        chooseFile.sendKeys(path);

        WebElement acceptCheckBox= Driver.getDriver().findElement(By.id("terms"));
        acceptCheckBox.click();

        WebElement submitBtn = Driver.getDriver().findElement(By.id("submitbutton"));
        submitBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//center)[2]")));
        String actual = Driver.getDriver().findElement(By.xpath("(//center)[2]")).getText();
        System.out.println(actual);


        Assert.assertEquals(actual,"1 file\nhas been successfully uploaded.");
        Driver.closeDriver();

    }
}
