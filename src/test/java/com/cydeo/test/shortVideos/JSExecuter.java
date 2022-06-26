package com.cydeo.test.shortVideos;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecuter {
    @Test
    public void scrollingTest() throws InterruptedException {
        Driver.getDriver().get("http://practice.cydeo.com");

        WebElement linkCydeo = Driver.getDriver().findElement(By.linkText("CYDEO"));

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Thread.sleep(2000);

        js.executeScript("arguments[0].scrollIntoView(true);"+ "arguments[0].click()" ,linkCydeo);


    }
}
