package com.cydeo.test.shortVideos;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class fakerPractice {
    @Test
    public void fakerVoid(){
        Faker faker =new Faker();
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.address().fullAddress() = " + faker.address().fullAddress());
        System.out.println("faker.address().streetAddress() = " + faker.address().streetAddress());
        System.out.println("faker.address().city() = " + faker.address().city());
        System.out.println("faker.address().zipCode() = " + faker.address().zipCode());
        System.out.println("faker.number().numberBetween(100000,9000000) = " + faker.number().numberBetween(100000, 9000000));
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));
        System.out.println("faker.letterify(\"???????\") = " + faker.letterify("???????"));
        System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard());
    }

}
