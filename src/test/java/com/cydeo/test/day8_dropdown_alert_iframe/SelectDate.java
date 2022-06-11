package com.cydeo.test.day8_dropdown_alert_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SelectDate {
//    1. Open Chrome browser
//2. Go to https://practice.cydeo.com/dropdown
//            3. Select “December 1st, 1923” and verify it is selected.
//    Select year using   : visible text
//    Select month using    : value attribute Select
//    day using : index number
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         driver.get("https://practice.cydeo.com/dropdown");

    }
    @Test
    public  void dateDropDownTest(){
        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("1923");
        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByValue("11");
        Select date = new Select(driver.findElement(By.id("day")));
        date.selectByIndex(0);
        String actualYear = year.getFirstSelectedOption().getText();
        String actualMonth= month.getFirstSelectedOption().getText();
        String actualDate = date.getFirstSelectedOption().getText();
        Assert.assertEquals(actualYear,"1923","failed");
        Assert.assertEquals(actualMonth,"December","Failed");
        Assert.assertEquals(actualDate,"1","Failed");
        Assert.assertTrue(actualYear.equals("1923"));
        for (WebElement option : year.getOptions()) {
            System.out.println("option.getText() = " + option.getText());

        }
        driver.quit();



    }

}
