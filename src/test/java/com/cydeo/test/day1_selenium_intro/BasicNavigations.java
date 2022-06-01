package com.cydeo.test.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {
    public static void main(String[] args) throws InterruptedException {
        // setting up webdrive manager
        WebDriverManager.chromedriver().setup();
        //instance of webdriver
        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.etsy.com");
        driver.navigate().to("https://www.google.com");
        Thread.sleep(3000);

        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        System.out.println("Google driver.getTitle(): " + driver.getTitle());
        driver.get("https://www.tesla.com");
        System.out.println("Tesla page title " + driver.getTitle());
        System.out.println("driver.getCurrentURL()=" + driver.getCurrentUrl());
        driver.close();
    }
}
