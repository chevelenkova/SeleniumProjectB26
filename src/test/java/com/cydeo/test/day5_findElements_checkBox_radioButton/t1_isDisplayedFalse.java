package com.cydeo.test.day5_findElements_checkBox_radioButton;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class t1_isDisplayedFalse {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tesla.com/");
//        1- Open a Chrome browser
        //2- Go to: https://www.tesla.com/
        //3- Locate Solar Panels header
        WebElement solarPanelHeader = driver.findElement(By.xpath("(//h1[contains(text(),'Solar Panels')])[1]"));
        if(solarPanelHeader.isDisplayed()){
            System.out.println("Pass");
        }else{
            System.out.println("False");
        }
        driver.quit();
        //4- Verify if it is dispayed on the page
    }
}
