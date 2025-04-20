package test;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.ProductPage;


import java.time.Duration;

public class CartTest extends BaseTest {

    @Test
    public void testDeleteCartItem() {
        ProductPage product = new ProductPage(driver);
        product.openFirstProduct();
        product.clickAddToCart();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.alertIsPresent()).accept();

        CartPage cart = new CartPage(driver);
        cart.goToCart();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Delete']")));

        cart.deleteFirstItemIfPresent();
        
    }
}
