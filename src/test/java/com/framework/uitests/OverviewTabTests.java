package com.framework.uitests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OverviewTabTests extends BaseTestClass {
    String user = "yelenagouralnik";
    @BeforeEach
    void overviewTabSetup(){
        driver.get(BASE_URL + user);
    }

    @AfterEach
    void localCleanup() {

    }


    @Test
    void userNameIsCorrecctOnOverviewTab() {
        //Arrange
            //Arranging in BeforeEach class

        //Act

        String actualUserName = driver.findElement(By.className("p-nickname")).getText();
        System.out.println(actualUserName);
        //Assert
        assertEquals("yelenagouralnik", actualUserName);

    }
    @Test
    void repoLinkGoesToCorrectRepo() {
        //Arrange

        //Act

        String actualUserName = driver.findElement(By.className("p-nickname")).getText();
        System.out.println(actualUserName);

        String repo = "GherkinCucumberJava";
        WebElement repoLink = driver.findElement(By.linkText(repo));
        repoLink.click();
        String actualUrl = driver.getCurrentUrl();
        String gitUser = "yelenagouralnik";
        //Assert

        assertEquals(BASE_URL + gitUser + "/" + repo, actualUrl);
    }
}
