package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LogoutPage {
    WebDriver driver;

    @FindBy(id = "logout2")
    WebElement logoutButton;

    @FindBy(id = "login2")
    WebElement loginLink; 

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLogout() {
        logoutButton.click();
    }

    public boolean isLoginLinkVisible() {
        return loginLink.isDisplayed();
    }

    public WebElement getLoginLink() {
        return loginLink;
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }
}
