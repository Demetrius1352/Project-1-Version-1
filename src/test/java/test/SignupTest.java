package test;

import base.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;


import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class SignupTest extends BaseTest {

    @Test
    public void testSignupFunctionality() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("signin2")).click();

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sign-username")));
        WebElement passwordField = driver.findElement(By.id("sign-password"));

        String timestamp = new SimpleDateFormat("HHmmss").format(new Date());
        String newUser = "demouser" + timestamp;
        String password = "Test@123";

        usernameField.sendKeys(newUser);
        passwordField.sendKeys(password);

        driver.findElement(By.xpath("//button[text()='Sign up']")).click();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        try (FileWriter writer = new FileWriter("user_credentials.txt")) {
            writer.write(newUser + "\n");
            writer.write(password + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

      
    }
}
