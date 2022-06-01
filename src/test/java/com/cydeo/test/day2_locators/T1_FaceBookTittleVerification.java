package com.cydeo.test.day2_locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_FaceBookTittleVerification {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http:www.facebook.com");

        String expectedTitle = "Facebook - log in or sign up";
        String actualTittle = driver.getTitle();
        if(actualTittle.equals(expectedTitle)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
        driver.quit();
    }
}
