package com.cydeo.test.day16_actions_jsexecuter;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_JSExecutor_Scroll {

    @Test
    public void scroll_test() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("etsy"));

        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
//        js.executeScript("window.scrollBy(0,1000)"); // if we want go up ScrollBy(x,y) x-right,left y-up(use positive) and down (use negative)

        WebElement email = Driver.getDriver().findElement(By.id("email-list-signup-email-input"));
        js.executeScript("arguments[0].scrollIntoView(true)",email);

        Faker faker =new Faker();
        email.sendKeys(faker.internet().emailAddress() + Keys.ENTER);

        Thread.sleep(5000);

        String actual = Driver.getDriver().findElement(By.xpath("//div[@class='wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01']")).getText();

        Assert.assertEquals(actual,"Great! We've sent you an email to confirm your subscription.");

    }
}
