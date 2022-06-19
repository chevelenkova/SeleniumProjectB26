package com.cydeo.test.day14driverutil_javaFaker;

import com.cydeo.test.utilities.BrowserUtils;
import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class GoogleSearch_DriverPractice {
    @Test
    public void google_search_driver_practice(){

        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        WebElement searchBox = Driver.getDriver().findElement(By.name("q"));
        searchBox.sendKeys("apple" + Keys.ENTER);
        BrowserUtils.verifyTittle(Driver.getDriver(),"apple - Google Search");
        Driver.closeDriver();
    }
}
