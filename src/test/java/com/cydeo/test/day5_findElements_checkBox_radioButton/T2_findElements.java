package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.cydeo.test.homework.nadirTask.LoginTestCase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class T2_findElements {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//would not wait full 10 seconds if find el sooner

        driver.get("https://practice.cydeo.com/abtest");
        List<WebElement> allLinks = driver.findElements(By.tagName("a"));

        System.out.println("allLinks.size() = " + allLinks.size());
        for (WebElement allLink : allLinks) {
            System.out.println("allLink.getText() = " + allLink.getText());
        }
        for (WebElement allLink : allLinks) {
            System.out.println("allLink.getAttribute(\"href\") = " + allLink.getAttribute("href"));
        }
        driver.quit();

//        TC #4: FindElements Task
//        1- Open a chrome browser
//        2- Go to: https://practice.cydeo.com/abtest
//        3- Locate all the links in the page.
//        4- Print out the number of the links on the page.
//        5- Print out the texts of the links.
//        6- Print out the HREF attribute values of the links
    }
}
