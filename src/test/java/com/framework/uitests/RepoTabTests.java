package com.framework.uitests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepoTabTests extends BaseTestClass {
    @Test
    void repositoryCountIsCorrect() {
        //Arrange

        String user = "yelenagouralnik";
        driver.get("https://github.com/" + user + "?tab=repositories");

        //Act

        List<WebElement> repos = driver.findElements(By.xpath("//div[@id='user-repositories-list']//li"));

        //Assert
        assertEquals(6, repos.size());


    }
}
