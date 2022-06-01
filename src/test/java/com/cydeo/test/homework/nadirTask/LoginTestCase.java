package com.cydeo.test.homework.nadirTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://login2.nextbasecrm.com/");
        WebElement loginInput = driver.findElement(By.name("USER_LOGIN"));
        loginInput.sendKeys("helpdesk35@cybertekschool.com");
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys("UserUser");
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();
        if(driver.getTitle().equals("(36) Site map")){
            System.out.println("Login Test has passed");
        }else{
            System.out.println("Login test has failed");
        }

    }
}
