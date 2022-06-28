package com.cydeo.test.day17_pom_syncronization;

import com.cydeo.pages.ExplicitWait;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpliciteWait {
    @Test
    public void Dynamically_load_page_7(){
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/7");
        ExplicitWait explicitWait = new ExplicitWait();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),20);

        wait.until(ExpectedConditions.titleIs("Dynamic title"));
        Assert.assertEquals(explicitWait.doneMsg.getText(),"Done!");
        Assert.assertTrue(explicitWait.image.isDisplayed());
        //tru

    }
}
