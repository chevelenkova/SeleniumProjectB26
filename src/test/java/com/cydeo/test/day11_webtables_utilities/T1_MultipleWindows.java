package com.cydeo.test.day11_webtables_utilities;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.BrowserUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;
//TC #2: Window Handle practice
//        1. Createnewtestandmakesetups
//        2. Goto:https://www.amazon.com/
//        3. Copypaste the lines from below in to your class
//        4. CreatealogictoswitchtothetabwhereEtsy.comisopen
//        5. Assert:Titlecontains“Etsy”
//        Lines to be pasted:
//        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com/%27,%27_blank%27);%22);
//        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com/%27,%27_blank%27);%22);
//        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com/%27,%27_blank%27);%22);
//        These lines will simply open new tabs using something called JavascriptExecutor and get those pages.
//        We will learn JavascriptExecutor later as well.

public class T1_MultipleWindows extends TestBase {
    @Test
    public void windowsHandleTest(){
        driver.get("https://www.amazon.com/");

        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

        Set<String> allWindows = driver.getWindowHandles();
        for(String each : allWindows){
            driver.switchTo().window(each);
            if(driver.getTitle().contains("Etsy")){
                System.out.println("driver.getTitle() = " + driver.getTitle());
                break;
            }

        }

//        System.out.println("driver.getTitle() = " + driver.getTitle());
//        Assert.assertEquals(driver.getTitle(),"Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone","Failed");
//        BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");
        BrowserUtils.switchWindowAndVerify(driver,"facebook","Facebook");

    }


}
