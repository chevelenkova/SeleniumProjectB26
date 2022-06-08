package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Dropdown {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.out.println("Before method is running");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/dropdown");
    }
    @Test
    public void dropDown(){

//        TC #1: Verifying “Simple dropdown” and “State selection”
//        dropdown default values
//        1. Open Chrome browser
//        2. Go to https://practice.cydeo.com/dropdown
//        3. Verify “Simple dropdown” default selected value is correct
//        Expected: “Please select an option”
//        4. Verify “State selection” default selected value is correct
//        Expected: “Select a State”
        Select simpleDropDown = new Select(driver.findElement(By.id("dropdown")));
        String actualDefaultValue = simpleDropDown.getFirstSelectedOption().getText();
        String expectedDefaultValue = "Please select an option";
        Assert.assertEquals(actualDefaultValue,expectedDefaultValue,"Test Failed");

    }
    @Test
    public void StateDropDown(){
//        driver.get("https://practice.cydeo.com/dropdown");
        Select stateDropDown = new Select(driver.findElement(By.id("state")));
        String actualStateSelect= stateDropDown.getFirstSelectedOption().getText();
        String expectedSelect = "Select a State";
        Assert.assertEquals(actualStateSelect,expectedSelect,"filed");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
