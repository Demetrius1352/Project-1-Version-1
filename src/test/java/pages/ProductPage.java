package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    WebDriver driver;

    @FindBy(css = ".card-title a")
    List<WebElement> productList;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openFirstProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(productList));
        productList.get(0).click();
    }

    public void clickAddToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[text()='Add to cart']")));
        addToCart.click();
    }
}
