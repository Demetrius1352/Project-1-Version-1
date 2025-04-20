package test;

import base.BaseTest;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       
        loginPage.openLoginModal();

     
        wait.until(ExpectedConditions.visibilityOf(loginPage.usernameInput));

      
        loginPage.enterUsername("your_valid_username");  
        loginPage.enterPassword("your_valid_password"); 

      
        loginPage.clickLogin();

        
        wait.until(ExpectedConditions.visibilityOf(loginPage.logoutButton));
        System.out.println("✅ Login successful.");
    }
}
