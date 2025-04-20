package test;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;


import java.time.Duration;

public class CategoryTest extends BaseTest {

    @Test
    public void testCategoryDisplay() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Phones")));

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.areCategoriesDisplayed(), "Categories are not properly displayed.");
        
    }
}
