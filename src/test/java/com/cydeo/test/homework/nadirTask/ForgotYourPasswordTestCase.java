package com.cydeo.test.homework.nadirTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotYourPasswordTestCase {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://login2.nextbasecrm.com/");
        WebElement forgotPasswordButton = driver.findElement(By.className("login-link-forgot-pass"));
        forgotPasswordButton.click();
        if(driver.getTitle().equals("Get Passwokrd")){
            System.out.println("Forgot password test passed");
        }else{
            System.out.println("Forgot password test failed");
        }
//        driver.quit();
    }
}
