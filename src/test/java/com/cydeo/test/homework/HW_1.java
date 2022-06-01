package com.cydeo.test.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.By.*;

public class HW_1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://google.com");
        WebElement gmail = driver.findElement(By.linkText("Gmail"));
        gmail.click();
        if(driver.getTitle().contains("Gmail")){
            System.out.println("Verified tittle");
        }else{
            System.out.println("Tittle verification has failed");
        }
        driver.navigate().back();
        if(driver.getTitle().equals("Google")){
            System.out.println("Verified tittle");
        }else{
            System.out.println("Tittle verification has failed");
        }
        driver.quit();
    }
}
