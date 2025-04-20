package test;

import base.BaseTest;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.PurchasePage;


public class ProductTest extends BaseTest {

	@Test
	public void testPurchaseFlow() {
	    ProductPage product = new ProductPage(driver);
	    product.openFirstProduct();
	    product.clickAddToCart();

	   
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alert = driver.switchTo().alert();
	    alert.accept();

	    PurchasePage purchase = new PurchasePage(driver);
	    purchase.completePurchase("John Doe");
	}

}
