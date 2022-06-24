package com.cydeo.test.homework.nadirTaskVytruck;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VyTrackUS1 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();

    }
    @DataProvider (name = "loginData")
    public static Object[][] loginData(){
        return new Object[][]{
                {"user150","UserUser123"},
                {"user151","UserUser123"},
                {"user152","UserUser123"},
        };
    }

    @Test (dataProvider = "loginData")
    public void userShouldSeeAllVehicleInfo(String username, String pass){
        WebElement userName = driver.findElement(By.name("_username"));
        userName.sendKeys(username);
        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys(pass);
        WebElement loginBTN = driver.findElement(By.name("_submit"));
        loginBTN.click();

        WebDriverWait wait = new WebDriverWait(driver,20);

        WebElement fleet = driver.findElement(By.xpath("//li[1]//a//span[@class='title title-level-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(fleet));
        fleet.click();

        WebElement veh = driver.findElement(By.xpath("//span[.='Vehicles']"));
        wait.until(ExpectedConditions.elementToBeClickable(veh));
        veh.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Cars']")));

        String actual = driver.findElement(By.xpath("//h1[.='Cars']")).getText();
        String expected= "Cars";

        Assert.assertEquals(actual,expected,"Failed");

    }

    @Test(dataProvider = "loginData")
    public void userShouldSeeGeneralCarInfo(String username, String pass) throws InterruptedException {
        //Step1 User login
        WebElement userName = driver.findElement(By.name("_username"));
        userName.sendKeys(username);
        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys(pass);
        WebElement loginBTN = driver.findElement(By.name("_submit"));
        loginBTN.click();

        WebDriverWait wait = new WebDriverWait(driver,20);

        //Step2 User click onFleet feature
        WebElement fleet = driver.findElement(By.xpath("//li[1]//a//span[@class='title title-level-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(fleet));
        fleet.click();

        //Step3 User click on Vehicle
        WebElement veh = driver.findElement(By.xpath("//span[.='Vehicles']"));
        wait.until(ExpectedConditions.elementToBeClickable(veh));
        veh.click();

        //Step4 User click on car from the grid
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[1]")));
        WebElement carFromList = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
        carFromList.click();

        //5. Verify user is able to see general information about the car
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='General Information']")));
        WebElement generalInfo =driver.findElement(By.xpath("//span[.='General Information']"));
        Assert.assertEquals(generalInfo.getText(),"General Information","User is not able to access general info");


    }
    @Test(dataProvider = "loginData")
    public void userIsAbleToAddElement(String username, String pass) throws InterruptedException {
        //Step1 User login
        WebElement userName = driver.findElement(By.name("_username"));
        userName.sendKeys(username);
        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys(pass);
        WebElement loginBTN = driver.findElement(By.name("_submit"));
        loginBTN.click();

        WebDriverWait wait = new WebDriverWait(driver,20);

        //Step2 User click onFleet feature
        WebElement fleet = driver.findElement(By.xpath("//li[1]//a//span[@class='title title-level-1']"));
        wait.until(ExpectedConditions.elementToBeClickable(fleet));
        fleet.click();

        //Step3 User click on Vehicle
        WebElement veh = driver.findElement(By.xpath("//span[.='Vehicles']"));
        wait.until(ExpectedConditions.elementToBeClickable(veh));
        veh.click();

        //Step4 User click on car from the grid
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/tbody/tr[1]/td[1]")));
        WebElement carFromList = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
        carFromList.click();

        //5.User click on Add Event
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[.='Add Event']")));
        WebElement addBtn = driver.findElement(By.xpath("//i[.='Add Event']"));
        addBtn.click();
        //6 Verify user is able to add event
        WebElement titleInput = driver.findElement(By.xpath("//input[@name='oro_calendar_event_form[title]']"));
        titleInput.sendKeys("Tittle test");
        WebElement event = driver.findElement(By.xpath("//strong[.='Tittle test']"));
        Assert.assertEquals(event.getText(),"Tittle test","Event test has failed");


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
