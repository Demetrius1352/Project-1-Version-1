package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage {
    WebDriver driver;

    @FindBy(xpath = "//a[text()='Cart']")
    WebElement cartLink;

    @FindBy(xpath = "//a[text()='Delete']")
    List<WebElement> deleteButtons;

    @FindBy(id = "totalp")
    WebElement totalPrice;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goToCart() {
        cartLink.click();
    }

    public void deleteFirstItemIfPresent() {
        if (!deleteButtons.isEmpty()) {
            deleteButtons.get(0).click();
        }
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }
}
