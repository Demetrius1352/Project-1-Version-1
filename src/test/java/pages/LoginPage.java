package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    // Page elements (modal + login button)
    @FindBy(id = "login2")
    WebElement loginLink;

    @FindBy(id = "loginusername")
	public
    WebElement usernameInput;

    @FindBy(id = "loginpassword")
    WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Log in']")
    WebElement loginButton;

    @FindBy(id = "logout2")
	public
    WebElement logoutButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openLoginModal() {
        loginLink.click();
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public boolean isLogoutVisible() {
        return logoutButton.isDisplayed();
    }
}
