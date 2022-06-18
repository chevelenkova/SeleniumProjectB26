package com.cydeo.test.day11_webtables_utilities;

import com.cydeo.test.base.TestBase;
import com.cydeo.test.utilities.BrowserUtils;
import com.cydeo.test.utilities.WebTableUtils;
import com.google.common.base.Verify;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_WebtablePractice extends TestBase {
//    TC #1: Web table practice
//1. Goto : https://practice.cydeo.com/web-tables
//            2. Verify Bob’s name is listed as expected.
//    Expected: “Bob Martin”
//            3. Verify Bob Martin’s order date is as expected
//    Expected: 12/31/2021
    @Test
    public void webTable(){
        driver.get("https://practice.cydeo.com/web-tables");
        WebElement bob = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[7]/td[2]"));
        Assert.assertEquals(bob.getText(),"Bob Martin");
        WebElement date = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));
        Assert.assertEquals(date.getText(),"12/31/2021");
        System.out.println("WebTableUtils.returnOrderDate(driver, \"Thin Crust\") = " + WebTableUtils.returnOrderDate(driver, "Thin Crust"));
    }

}
