package com.cydeo.test.day8_dropdown_alert_iframe;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AlertJs {
//    TC #2: Confirmation alert practice
//1. Open browser
//2. Go to website: http://practice.cydeo.com/javascript_alerts
//            3. Click to “Click for JS Confirm” button
//4. Click to OK button from the alert
//5. Verify “You clicked: Ok” text is displayed.
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
    public void handleAlert(){
        WebElement jsConfirmBtn = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]"));
        jsConfirmBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement clicked = driver.findElement(By.id("result"));
        Assert.assertEquals(clicked.getText(),"You clicked: Ok","failed");
    }
}
