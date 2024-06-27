package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {
    WebDriver driver;

    @FindBy(name = "q")
    WebElement Product;

    public SearchProduct(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForProduct(String productName){
        Product.sendKeys(productName);
    }


}
