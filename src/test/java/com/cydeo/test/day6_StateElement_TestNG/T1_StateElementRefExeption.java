package com.cydeo.test.day6_StateElement_TestNG;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class T1_StateElementRefExeption {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://practice.cydeo.com/add_remove_elements/");
        WebElement addElBtn = driver.findElement(By.xpath("//div[@class= 'example']//button"));
        addElBtn.click();
        WebElement dltBtn= driver.findElement(By.xpath("//button[@class= 'added-manually']"));
        System.out.println("dltBtn.isDisplayed() = " + dltBtn.isDisplayed());
        dltBtn.click();


        try{
            System.out.println("dltBtn after deleting = " + dltBtn.isDisplayed());
        }catch (StaleElementReferenceException e){
            System.out.println("Not disparaged after clicking");
        }

//        1. Open Chrome browser
//        2. Go to https://practice.cydeo.com/add_remove_elements/ 3. Click to “Add Element” button
//        4. Verify “Delete” button is displayed after clicking.
//        5. Click to “Delete” button.
//        6. Verify “Delete” button is NOT displayed after clicking.
    }
}
