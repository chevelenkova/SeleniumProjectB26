package com.cydeo.test.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

public class BrowserUtils {
    public static void switchWindowAndVerify(WebDriver driver,String expectedUrl,String expectedTittle){
        Set<String> allWindows = driver.getWindowHandles();
        for(String each : allWindows){
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().contains(expectedUrl)){
                System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
                break;
            }
        }
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTittle),"Title verification failed");

    }
    public static void verifyTittle(WebDriver driver,String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle,"Title verification failed");
    }
}
