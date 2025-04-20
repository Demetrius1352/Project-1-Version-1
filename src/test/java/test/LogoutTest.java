package test;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;

public class LogoutTest extends BaseTest {

    @Test
    public void testlogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

      
        driver.findElement(By.id("login2")).click();

      
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginusername")));
        WebElement passwordField = driver.findElement(By.id("loginpassword"));

        usernameField.sendKeys("your_valid_username");  
        passwordField.sendKeys("your_valid_password");

      
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        
        WebElement logoutButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout2")));

        
        logoutButton.click();

        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login2")));

        System.out.println("✅ Logout successful.");
    }
}
