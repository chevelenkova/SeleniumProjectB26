package com.cydeo.test.shortVideos;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CRMLogin {
    @Test
    public void crmLogin(){
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        WebElement inputUserName = Driver.getDriver().findElement(By.name("USER_LOGIN"));
        inputUserName.sendKeys(ConfigurationReader.getProperty("username"));

        WebElement inputPassword = Driver.getDriver().findElement(By.name("USER_PASSWORD"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement loginBtn = Driver.getDriver().findElement(By.xpath("//input[@class = 'login-btn']"));
        loginBtn.click();
//        Driver.closeDriver();
    }
}
