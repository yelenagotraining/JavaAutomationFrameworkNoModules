package com.framework;

import com.framework.uitests.BaseTestClass;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

public class MyFirstTest extends BaseTestClass {
    public static final String BASE_URL = "https://github.com/";
    static WebDriver driver;

   @Test
    void myFirstTest() {
        int result = sum(2, 2);
       assertEquals(result, 4,"actual sum does not match result");
       assertNotEquals(result, 5, "actual sum does not match result");
       System.out.println("Runs!");

    }







    static int sum(int a, int b) {
       return a + b;
    }

}
