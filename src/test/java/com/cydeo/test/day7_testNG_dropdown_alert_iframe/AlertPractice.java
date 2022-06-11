package com.cydeo.test.day7_testNG_dropdown_alert_iframe;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertPractice {
//    1. Open browser
//2. Go to website: http://practice.cydeo.com/javascript_alerts
//            3. Click to “Click for JS Alert” button
//4. Click to OK button from the alert
//5. Verify “You successfully clicked an alert” text is displayed.
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cydeo.com/javascript_alerts");
    }
    @Test
    public void alertPractice(){
        WebElement clickOnJSAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        clickOnJSAlert.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement result = driver.findElement(By.id("result"));
        String expected = "You successfully clicked an alert";
        Assert.assertEquals(result.getText(),expected,"Failed");
    }
    @Test
    public void alertPractice2(){
//        1. Open browser
//        2. Go to website: http://practice.cydeo.com/javascript_alerts
//        3. Click to “Click for JS Prompt” button
        WebElement clickOnJsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        clickOnJsPrompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");
        alert.accept();
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        Assert.assertEquals(actualResult,"You entered: hello","Failed");
//        4. Send “hello” text to alert
//        5. Click to OK button from the alert
//        6. Verify “You entered:  hello” text is displayed.
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
