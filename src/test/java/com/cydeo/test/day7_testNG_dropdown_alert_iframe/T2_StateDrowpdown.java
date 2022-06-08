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

import static java.lang.Thread.sleep;

public class T2_StateDrowpdown {
//    . Open Chrome browser
//2. Go to http://practice.cybertekschool.com/dropdown
//            3. Select Illinois
//4. Select Virginia
//5. Select California
//6. Verify
//    final selected option is California.
//    Use all Select options. (visible text, value, index)
WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void stateDropdownTest(){
        Select stateDropDown = new Select(driver.findElement(By.id("state")));
        System.out.println("stateDropDown.isMultiple() = " + stateDropDown.isMultiple());
        stateDropDown.selectByValue("IL");
        stateDropDown.selectByVisibleText("Virginia");
        stateDropDown.selectByIndex(5);
        String expectedResult = "California";
        String actualResult = stateDropDown.getFirstSelectedOption().getText();
        Assert.assertEquals(expectedResult,actualResult,"Failed");


    }
    @Test
    public void selectAll() throws InterruptedException {
//        1. Open Chrome browser
//        2. Go to https://practice.cydeo.com/dropdown
//        3. Select all the options from multiple select dropdown.
//        4. Print out all selected values.
//        5. Deselect all values.
        Select languages = new Select(driver.findElement(By.name("Languages")));
        System.out.println("languages.isMultiple() = " + languages.isMultiple());
        for (WebElement each : languages.getOptions()) {

            each.click();

            System.out.println(each.getText());

        }

        languages.deselectAll();

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
