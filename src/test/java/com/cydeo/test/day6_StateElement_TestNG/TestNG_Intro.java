package com.cydeo.test.day6_StateElement_TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Intro {
    @BeforeClass
    public void setUp(){
        System.out.println("Before class is running");
    }
    @AfterClass
    public void tearDown(){
        System.out.println("after class running");
    }
    @BeforeMethod
    public void setUpMethod(){
        System.out.println("befor method");
    }
    @AfterMethod
    public void tearDownMethod(){
        System.out.println("after method running");
    }
    @Test(priority = 2)
    public void test1(){
        System.out.println("Test1 is running");
        String actual = "appl";
        String expected = "apple";
        Assert.assertEquals(actual,expected,"failed");
    }
    @Test
    public void test2(){
        System.out.println("Test2 is running");
        Assert.assertEquals("orange","ora","test failed");
    }
}
