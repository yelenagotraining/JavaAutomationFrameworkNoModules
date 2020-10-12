package com.framework.uitests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import static com.framework.DriverFactory.getChromeDriver;

public class BaseTestClass {
    public static final String BASE_URL = "https://github.com/";
    static WebDriver driver;
    @BeforeAll
        //@BeforeMethod in TestNG
    void setup() {
        driver = getChromeDriver();
    }

    @AfterAll
    void cleanUP(){

        driver.close();
    }
}
