package com.cydeo.test.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_linkTextPractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practice.cydeo.com");
        WebElement abLinkText = driver.findElement(By.linkText("A/B Testing"));
        abLinkText.click();

        String expectedTittle ="No A/B Test";
        String actualTitle = driver.getTitle();
        if(actualTitle.equals(expectedTittle)){
            System.out.println("Tittle var has passed");
        }else{
            System.out.println("Failed");
        }
        driver.navigate().back();
        expectedTittle = "Practice";
        actualTitle = driver.getTitle();
        if(expectedTittle.equals(actualTitle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.quit();
    }
}
