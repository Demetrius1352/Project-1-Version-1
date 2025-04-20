package test;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class PurchaseTest extends BaseTest {

    @Test
    public void testPurchaseFlow() {
        WebDriver driver = this.driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Step 1: Open first product
        List<WebElement> products = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card-title a"))
        );
        products.get(0).click();

        // Step 2: Add to cart
        WebElement addToCart = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Add to cart")));
        addToCart.click();

        // Step 3: Handle alert
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();

        // Step 4: Go to cart
        driver.findElement(By.linkText("Cart")).click();

        // Step 5: Click "Place Order"
        WebElement placeOrderBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[text()='Place Order']")));
        placeOrderBtn.click();

        // Step 6: Fill form
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("orderModal")));
        driver.findElement(By.id("name")).sendKeys("John Doe");
        driver.findElement(By.id("country")).sendKeys("India");
        driver.findElement(By.id("city")).sendKeys("Chennai");
        driver.findElement(By.id("card")).sendKeys("1234123412341234");
        driver.findElement(By.id("month")).sendKeys("April");
        driver.findElement(By.id("year")).sendKeys("2025");

        // Step 7: Confirm purchase
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();

        // Step 8: Confirmation message
        WebElement confirmationModal = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.className("sweet-alert"))
        );
        System.out.println("Confirmation: " + confirmationModal.getText());

        // Screenshot is no longer needed here — handled by BaseTest on failure
    }
}
