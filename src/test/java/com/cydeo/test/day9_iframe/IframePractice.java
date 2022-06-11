package com.cydeo.test.day9_iframe;

import com.cydeo.test.base.TestBase;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IframePractice extends TestBase {
  @Test
    public void iframeVoid() throws InterruptedException {
    driver.get("https://practice.cydeo.com/iframe");

    driver.switchTo().frame("mce_0_ifr");//id
    //driver.switchTo().frame(By.xpath("//iframe[@id='blala');//locator
    //driver.swithTo().frame(0)//index
    WebElement commentBody = driver.findElement(By.id("tinymce"));
    commentBody.clear();
    Thread.sleep(1000);
    commentBody.sendKeys("Hello world");
  }
//    TC #6: Iframe Task
//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/iframe
//            3- Clear text from comment body
//4- Type "Hello World" in comment body
//5- Verify "Hello World" text is written in comment body
//6- Verify header "An iFrame containing the TinyMCE
//    WYSIWYG Editor" is displayed

}
