package com.cydeo.test.day10_windowHandle;

import com.cydeo.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebTablesTest extends TestBase {
    @Test
    public void WebTablesTest() throws InterruptedException {
        driver.get("https://practice.cydeo.com/tables");
        WebElement rrow3Cell2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[2]"));
        System.out.println("Before clicking rrow3Cell2.getText() = " + rrow3Cell2.getText());

        WebElement firstName = driver.findElement(By.xpath("(//span[.='First Name'])[1]"));
        firstName.click();

        rrow3Cell2 = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[3]/td[2]"));
        System.out.println("rrow3Cell2.getText() = " + rrow3Cell2.getText());

        WebElement jasonCell = driver.findElement(By.xpath("//table[@id='table1']//td[.='Jason']"));
        System.out.println("jasonCell.getText() = " + jasonCell.getText());

        List<WebElement> allrow3Cells = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr[3]/td"));
        for (WebElement eachCell : allrow3Cells){
            System.out.println("eachCell.getText() = " + eachCell.getText());
        }

        List<WebElement> eachCells = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr/td"));
        for(WebElement each : eachCells){
            System.out.println("each.getText() = " + each.getText());
        }

        List<WebElement> tableColumnName =driver.findElements(By.xpath("//table[@id='table1']//th/span"));
        List<String> tableColumnName2 = new ArrayList<>();
        for(WebElement each : tableColumnName){
            tableColumnName2.add(each.getText());
        }
        System.out.println(tableColumnName2);

    }
}
