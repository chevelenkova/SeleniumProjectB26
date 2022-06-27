package com.cydeo.test.day17_pom_syncronization;

import com.cydeo.pages.CydeoPracticePage;
import com.cydeo.test.utilities.Driver;
import com.google.common.base.Verify;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class POM_ACTIONSPRACTICE {
//    1. Open a chrome browser
//2. Go to:
//    https://practice.cydeo.com/drag_and_drop_circles
//            3. Verify expected default text appears on big circle

//            Expected = "Drag the small circle here."
    CydeoPracticePage cydeoPracticePage;
    Actions actions;

    @BeforeMethod
    public void setUp(){
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");


    }
    @Test
    public void drag_small_circle_text(){
        CydeoPracticePage cydeoPracticePage = new CydeoPracticePage();
        Actions actions =new Actions(Driver.getDriver());


        Assert.assertEquals(cydeoPracticePage.bigCircle.getText(),"Drag the small circle here.");

    }

    @Test
    public void drop_here_test(){
        CydeoPracticePage cydeoPracticePage = new CydeoPracticePage();
        Actions actions =new Actions(Driver.getDriver());

        actions.moveToElement(cydeoPracticePage.smallCircle).clickAndHold().moveByOffset(5,5).perform();
        Assert.assertEquals(cydeoPracticePage.bigCircle.getText(),"Drop here.");
    }
    @Test
    public void now_drop_test(){
//        TC #4: Cydeo Practice Drag and Drop Test
//        7. Open a chrome browser
//        8. Go to:
//        https://practice.cydeo.com/drag_and_drop_circles
//        9. Click and hold small circle
//        10. Move it on top of the big circle
//        11. Verify “Now drop...” text appears on big circle
        CydeoPracticePage cydeoPracticePage = new CydeoPracticePage();
        Actions actions =new Actions(Driver.getDriver());

        actions.clickAndHold(cydeoPracticePage.smallCircle).moveToElement(cydeoPracticePage.bigCircle).perform();
        Assert.assertEquals(cydeoPracticePage.bigCircle.getText(),"Now drop...");


    }
}
