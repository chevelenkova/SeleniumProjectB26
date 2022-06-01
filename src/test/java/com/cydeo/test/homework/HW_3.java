package com.cydeo.test.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW_3 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://practice.cydeo.com/inputs");
        WebElement homeButton = driver.findElement(By.className("nav-link"));
        homeButton.click();
        if(driver.getTitle().equals("Practice")){
            System.out.println("Test passed");
        }else {
            System.out.println("Test Failed");
        }
    }
}
