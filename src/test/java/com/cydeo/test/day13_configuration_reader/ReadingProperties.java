package com.cydeo.test.day13_configuration_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
    @Test
    public void reading_from_properties_file() throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("configuration.properties");
        properties.load(file);
        System.out.println("properties.getProperty(\"browser1\") = " + properties.getProperty("browser1"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
    }
}
