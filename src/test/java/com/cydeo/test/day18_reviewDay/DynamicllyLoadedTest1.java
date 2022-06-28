package com.cydeo.test.day18_reviewDay;

import com.cydeo.pages.DynamicllyLoadedPage1;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicllyLoadedTest1 {

    @Test
    public void dynamically_loaded_page(){
        //1. Go to https://practice.cydeo.com/dynamic_loading/1
//        2. Click to start
//        3. Wait until loading bar disappears
//        4. Assert username inputbox is displayed
//        5. Enter username: tomsmith
//        6. Enter password: incorrectpassword
//        7. Click to Submit button
//        8. Assert “Your password is invalid!” text is displayed.
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");
        DynamicllyLoadedPage1 dynamicllyLoadedPage1 = new DynamicllyLoadedPage1();

        dynamicllyLoadedPage1.startBtn.click();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

        wait.until(ExpectedConditions.invisibilityOf(dynamicllyLoadedPage1.loadingBar));
        Assert.assertTrue(dynamicllyLoadedPage1.userNameInput.isDisplayed());

        dynamicllyLoadedPage1.userNameInput.sendKeys("tomsmith");
        dynamicllyLoadedPage1.passwordInput.sendKeys("incorrectpassword");
        dynamicllyLoadedPage1.submitBtn.click();

//        Assert.assertEquals(dynamicllyLoadedPage1.errorMsg.getText(),"Your password is invalid!","Test failed");
        Assert.assertTrue(dynamicllyLoadedPage1.errorMsg.isDisplayed(),"Test failed");
    }
}
