package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    WebDriver driver;

    @FindBy(id = "signin2")
    WebElement signupButton;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSignup() {
        signupButton.click();
    }

    public boolean isSignupButtonDisplayed() {
        return signupButton.isDisplayed() && signupButton.isEnabled();
    }
}
