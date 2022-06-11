package com.cydeo.test.homework.nadirTaskVytruck;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AutomatedUS2_TC004 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get("https://qa2.vytrack.com/user/login");

    }
    @Test
    public void testAddVehicleModule() throws InterruptedException {
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys("storemanager85");//storemanager85 , storemanager86, storemanager244
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        WebElement loginBtn = driver.findElement(By.id("_submit"));
        loginBtn.click();

        WebElement fleet = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        Actions action = new Actions(driver);
        action.moveToElement(fleet).click().perform();

        WebElement vehicleModule = driver.findElement(By.xpath("//span[.='Vehicles']"));
        Thread.sleep(3000);
        vehicleModule.click();
        Thread.sleep(5000);
        WebElement createCar = driver.findElement(By.xpath("//a[@title ='Create Car']"));
        Thread.sleep(5000);
        createCar.click();

        Thread.sleep(5000);
        WebElement addVehicleModelBtn = driver.findElement(By.xpath("(//button[@data-purpose='open-dialog-widget'])[1]"));
        Thread.sleep(5000);
        addVehicleModelBtn.click();
        Thread.sleep(5000);
        WebElement checkBox = driver.findElement(By.xpath("(//tbody[@class='grid-body']//input)[1]"));
        Thread.sleep(5000);
        checkBox.click();
        Thread.sleep(3000);
        WebElement selectBtn = driver.findElement(By.xpath("//button[.='Select']"));
        selectBtn.click();
        WebElement appearanceOfModel = driver.findElement(By.xpath("//div[contains(text(),'Model Name:')]"));
        System.out.println("appearanceOfModel.isDisplayed() = " + appearanceOfModel.isDisplayed());

    }
}
