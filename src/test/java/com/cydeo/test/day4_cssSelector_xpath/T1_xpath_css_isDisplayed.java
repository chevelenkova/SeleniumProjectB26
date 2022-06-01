package com.cydeo.test.day4_cssSelector_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_xpath_css_isDisplayed {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cydeo.com/forgot_password");
        WebElement homeLink = driver.findElement(By.cssSelector("a.nav-link"));
        WebElement homelink2 = driver.findElement(By.xpath("//a[@class='nav-link'")); ////a[.='Home']-text


        WebElement forgotPassword = driver.findElement(By.cssSelector("div[class ='example']>h2"));
        WebElement forgotPassword2 = driver.findElement(By.xpath("//h2[.='Forgot Password']"));


        WebElement emailInput = driver.findElement(By.cssSelector("input[type='text']"));


        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button#form_submit>i"));
        WebElement poweredByCydeoText = driver.findElement(By.cssSelector("div[style = 'text-align: center;'"));
//        if(forgotPassword.getText().equals("Forgot Password")){
//            System.out.println("true");
//        }
        System.out.println(homeLink.isDisplayed());
        System.out.println(forgotPassword.isDisplayed());
        System.out.println(emailInput.isDisplayed());
        System.out.println(retrievePasswordButton.isDisplayed());
        System.out.println(poweredByCydeoText.isDisplayed());
        driver.quit();


    }
}
