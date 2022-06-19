package com.cydeo.test.day14driverutil_javaFaker;

public class Singleton {
    private Singleton(){}
    private static String word;
    public static String getWord(){
        if(word ==null){
            System.out.println("First time calling.Word obj is null.");
            word = "something";
        }else{
            System.out.println("Word is already assigned");
        }
        return word;
    }
}
