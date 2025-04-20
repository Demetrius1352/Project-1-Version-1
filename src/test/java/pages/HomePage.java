package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(linkText = "Phones")
    WebElement phoneCategory;

    @FindBy(linkText = "Laptops")
    WebElement laptopCategory;

    @FindBy(linkText = "Monitors")
    WebElement monitorCategory;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean areCategoriesDisplayed() {
        return phoneCategory.isDisplayed() &&
               laptopCategory.isDisplayed() &&
               monitorCategory.isDisplayed();
    }
}
