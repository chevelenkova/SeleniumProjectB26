package com.cydeo.pages;

import com.cydeo.test.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicllyLoadedPage1 {
    public DynamicllyLoadedPage1(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//div[@id='start']/button")
    public WebElement startBtn;

    @FindBy(id = "username")
    public WebElement userNameInput;

    @FindBy(id="loading")
    public WebElement loadingBar;

    @FindBy(id = "pwd")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitBtn;

    @FindBy(id="flash")
    public WebElement errorMsg;


}
//1. Go to https://practice.cydeo.com/dynamic_loading/1
//        2. Click to start
//        3. Wait until loading bar disappears
//        4. Assert username inputbox is displayed
//        5. Enter username: tomsmith
//        6. Enter password: incorrectpassword
//        7. Click to Submit button
//        8. Assert “Your password is invalid!” text is displayed.