package com.cydeo.test.shortVideos;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HoverOverPractice {
    @Test
    public void hoverOver(){
        Driver.getDriver().get("https://practice.cydeo.com/hovers");
        Actions actions = new Actions(Driver.getDriver());
        WebElement firstImg = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement img1Text = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));

        actions.moveToElement(firstImg).perform();

        Assert.assertTrue(img1Text.isDisplayed());

        List<WebElement> images = Driver.getDriver().findElements(By.xpath("//img"));
        for(WebElement image : images){
            actions.moveToElement(image).pause(2000).perform();
        }
        Driver.closeDriver();

    }
}
