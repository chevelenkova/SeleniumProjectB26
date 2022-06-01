package com.cydeo.test.day3_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_Locators_getText {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://login1.nextbasecrm.com/");
        WebElement loginInput = driver.findElement(By.name("USER_LOGIN"));
        loginInput.sendKeys("incorrect");
        WebElement passwordInput = driver.findElement(By.name("USER_PASSWORD"));
        passwordInput.sendKeys("incorrect");
        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();
        WebElement errMessage = driver.findElement(By.className("errortext"));
        String expectedTest = "Incorrect login or password";
        String actualText = errMessage.getText();
        System.out.println(expectedTest.equals(actualText));
    }
}
