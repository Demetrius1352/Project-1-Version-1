package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class PurchasePage {
    WebDriver driver;

    @FindBy(xpath = "//a[text()='Cart']")
    WebElement cartLink;

    @FindBy(xpath = "//button[text()='Place Order']")
    WebElement placeOrderButton;

    @FindBy(id = "name")
    WebElement nameField;

    @FindBy(xpath = "//button[text()='Purchase']")
    WebElement purchaseBtn;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void completePurchase(String name) {
        cartLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
        placeOrderButton.click();

        wait.until(ExpectedConditions.visibilityOf(nameField));
        nameField.sendKeys(name);
        purchaseBtn.click();
    }
}
