package com.cydeo.pages;

import com.cydeo.test.utilities.Driver;
import org.apache.hc.core5.http.Message;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class ExplicitWait {
//    1. Go to https://practice.cydeo.com/dynamic_loading/7
//            2. Wait until title is “Dynamic title”
//            3. Assert: Message “Done” is displayed.
//            4. Assert: Image is displayed.
    public ExplicitWait(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id="alert")
    public WebElement doneMsg;
    @FindBy(xpath = "//img")
    public WebElement image;
}
