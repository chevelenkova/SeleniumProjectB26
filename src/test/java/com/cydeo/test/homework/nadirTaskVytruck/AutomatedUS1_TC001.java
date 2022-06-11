package com.cydeo.test.homework.nadirTaskVytruck;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AutomatedUS1_TC001 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void verifyVehicleUnderFleet() throws InterruptedException {
        WebElement userName = driver.findElement(By.name("_username"));
        userName.sendKeys("user150");
        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys("UserUser123");
        WebElement loginBTN = driver.findElement(By.name("_submit"));
        loginBTN.click();
//        WebElement fleet = driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]/a/span"));
        WebElement fleet = driver.findElement(By.xpath("//li[1]//a//span[@class='title title-level-1']"));
        fleet.click();
        Thread.sleep(5000);
        WebElement veh = driver.findElement(By.xpath("//span[.='Vehicles']"));
        veh.click();
        String actual = driver.findElement(By.xpath("//h1[.='Cars']")).getText();
        String expected= "Cars";
        Assert.assertEquals(actual,expected,"Failed");



    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
