package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNG_Selenium {


    WebDriver driver;


    @BeforeMethod
    public void setUpMethod(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDownMethod(){
        driver.quit();
    }


    @Test
    public void googleTittle(){

        driver.get("https://google.com");
        String expectedTittle = "Google";
        String actualTittle = driver.getTitle();
        Assert.assertEquals(expectedTittle,actualTittle,"Test Failed");

    }
    @Test
    public void yahooTittle(){
        driver.get("https://yahoo.com");
        String expectedTittle = "Yahoo";
        String actualTittle = driver.getTitle();
        Assert.assertEquals(actualTittle,expectedTittle,"Test failed");

    }


}
