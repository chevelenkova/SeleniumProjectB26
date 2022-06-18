package com.cydeo.test.day10_windowHandle;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class T3_Windows_Handle extends TestBase {
//    1. Open a chrome browser
//2. Go to : https://practice.cydeo.com/windows
//            3. Assert: Title is “Windows”
//            4. Click to: “Click Here” link
//5. Switch to new Window.
//6. Assert: Title is “New Window”
    @Test
    public void windowHandleTest(){
        driver.get("https://practice.cydeo.com/windows");
        String actualTitle = driver.getTitle();

        String mainWindow = driver.getWindowHandle();

        System.out.println("mainWindow = " + mainWindow);

        String expectedTitle = "Windows";
        Assert.assertEquals(actualTitle,expectedTitle,"Title doesn't match");

        WebElement clickHereLink = driver.findElement(By.xpath("//a[.='Click Here']"));
        clickHereLink.click();

        String secondWindow = driver.getWindowHandle();



        Set<String> allWindowHandles = driver.getWindowHandles();

        for(String each : allWindowHandles){
            driver.switchTo().window(each);
            System.out.println("driver.getTitle() = " + driver.getTitle());
        }
        Assert.assertEquals(driver.getTitle(),"New Window");



    }
}
