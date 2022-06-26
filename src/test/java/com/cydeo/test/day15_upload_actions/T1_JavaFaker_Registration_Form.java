package com.cydeo.test.day15_upload_actions;

import com.cydeo.test.utilities.ConfigurationReader;
import com.cydeo.test.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_JavaFaker_Registration_Form {
    @Test
    public void registration_form_test(){
        Driver.getDriver().get(ConfigurationReader.getProperty("registration"));

        WebElement firstName = Driver.getDriver().findElement(By.name("firstname"));
        WebElement lastName = Driver.getDriver().findElement(By.name("lastname"));
        WebElement userName = Driver.getDriver().findElement(By.name("username"));
        WebElement email = Driver.getDriver().findElement(By.name("email"));
        WebElement password = Driver.getDriver().findElement(By.name("password"));
        WebElement phone = Driver.getDriver().findElement(By.name("phone"));

        Faker faker = new Faker();

       firstName.sendKeys( faker.name().firstName());
       lastName.sendKeys( faker.name().lastName());
       userName.sendKeys( faker.bothify("???????###"));
       email.sendKeys( faker.internet().emailAddress());
       password.sendKeys( faker.internet().password());
       phone.sendKeys( faker.numerify("571-###-####"));

       WebElement gender = Driver.getDriver().findElement(By.xpath("//input[@value='female']"));
       gender.click();

       WebElement dob =  Driver.getDriver().findElement(By.name("birthday"));
       dob.sendKeys("06/11/1995");

        Select select = new Select(Driver.getDriver().findElement(By.name("department")) );
       select.selectByIndex(faker.number().numberBetween(1,9));

       Select jobTitle = new Select(Driver.getDriver().findElement(By.name("job_title")));
       jobTitle.selectByIndex(faker.number().numberBetween(1,9));

       WebElement lang = Driver.getDriver().findElement(By.id("inlineCheckbox2"));
       lang.click();

       WebElement signUpBtn = Driver.getDriver().findElement(By.id("wooden_spoon"));
       signUpBtn.click();

        Assert.assertEquals(Driver.getDriver().findElement(By.xpath("//p")).getText(),"You've successfully completed registration!");
        Driver.closeDriver();





    }
}
