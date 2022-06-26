package com.cydeo.test.day14driverutil_javaFaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {
    @Test
    public void faker_test(){
        Faker faker = new Faker();
        System.out.println("faker.harryPotter() = " + faker.harryPotter().character());
        System.out.println("faker.animal().name() = " + faker.animal().name());
    }

}
