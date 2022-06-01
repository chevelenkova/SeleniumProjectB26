package com.cydeo.test.day5_findElements_checkBox_radioButton;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_RadioButton {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.cydeo.com/radio_buttons");
//        1. Open Chrome browser
//        2. Go to https://practice.cydeo.com/radio_buttons
//        3. Click to “Hockey” radio button
//        4. Verify “Hockey” radio button is selected after clicking.
        WebElement hockeyBtn = driver.findElement(By.xpath("//input[@id='hockey']"));
        System.out.println("hockeyBtn.isSelected() = " + hockeyBtn.isSelected());
        hockeyBtn.click();
        System.out.println("hockeyBtn.isSelected() = " + hockeyBtn.isSelected());
        WebElement greenBtn = driver.findElement(By.xpath("//input[@id='green']"));
        System.out.println("greenBtn.isEnabled() = " + greenBtn.isEnabled());
        driver.quit();

    }
}
