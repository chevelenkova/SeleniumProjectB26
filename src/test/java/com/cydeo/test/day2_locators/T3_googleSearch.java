package com.cydeo.test.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_googleSearch {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://google.com");
        WebElement search = driver.findElement(By.name("p"));
        search.sendKeys("apple" + Keys.ENTER);
        String expectedTittle = "apple";
        String actualTittle = driver.getTitle();
        if(actualTittle.startsWith(expectedTittle)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }

       Thread.sleep(3000);
        driver.quit();


    }
}
