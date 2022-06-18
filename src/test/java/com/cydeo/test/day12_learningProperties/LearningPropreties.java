package com.cydeo.test.day12_learningProperties;

import org.testng.annotations.Test;

public class LearningPropreties {
    @Test
    public void java_properties_reading_test(){
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
        System.out.println("System.getProperty(\"user.name\") = " + System.getProperty("user.name"));
    }
}
