package com.cydeo.test.homework.nadirTaskVytruck;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AutomatedUS2_AC4 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qa2.vytrack.com/user/login");
    }
    @DataProvider(name = "loginData")
    public Object[][] login(){
        return new Object[][]{
                {"storemanager85","UserUser123"},
                {"storemanager86","UserUser123"},
                {"storemanager244","UserUser123"},
                {"salesmanager251","UserUser123"},
                {"salesmanager252","UserUser123"},
        };

    }
    @Test (dataProvider = "loginData")
    public void testAddVehicleModule(String username,String pass){
        WebElement userName = driver.findElement(By.id("prependedInput"));
        userName.sendKeys(username);
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys(pass);
        WebElement loginBtn = driver.findElement(By.id("_submit"));
        loginBtn.click();

        WebDriverWait wait = new WebDriverWait(driver,40);

        WebElement fleet = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span"));
        Actions action = new Actions(driver);
        action.moveToElement(fleet).click().perform();

        WebElement vehicleModule = driver.findElement(By.xpath("//span[.='Vehicles']"));
        wait.until(ExpectedConditions.elementToBeClickable(vehicleModule));
        vehicleModule.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title ='Create Car']")));
        WebElement createCar = driver.findElement(By.xpath("//a[@title ='Create Car']"));
        createCar.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@data-purpose='open-dialog-widget'])[1]")));
        WebElement addVehicleModelBtn = driver.findElement(By.xpath("(//button[@data-purpose='open-dialog-widget'])[1]"));
        addVehicleModelBtn.click();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//tbody[@class='grid-body']//input)[1]")));
        WebElement checkBox = driver.findElement(By.xpath("(//tbody[@class='grid-body']//input)[1]"));
        checkBox.click();

        WebElement selectBtn = driver.findElement(By.xpath("//button[.='Select']"));
        selectBtn.click();
        WebElement appearanceOfModel = driver.findElement(By.xpath("//div[contains(text(),'Model Name:')]"));
        System.out.println("appearanceOfModel.isDisplayed() = " + appearanceOfModel.isDisplayed());

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
