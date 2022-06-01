package com.cydeo.test.day3_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T2_getText_getAttributePractice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cydeo.com/registration_form");
        WebElement header = driver.findElement(By.tagName("h2"));
        if(header.getText().equals("Registration form")){
            System.out.println("Header form test has passed");
        }else{
            System.out.println("Header form test has failed");
        }
        WebElement firstName = driver.findElement(By.name("firstname"));
        if(firstName.getAttribute("placeholder").equals("first name")){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
        }
        driver.quit();
    }
}
