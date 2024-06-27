package basic;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.SearchProduct;
import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    SearchProduct Pro = new SearchProduct(driver);


    @BeforeSuite
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get(" https://www.google.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.flipkart.com/");
    }

    @Test
    public void findProduct(){
        Pro.searchForProduct("Mobiles");
    }


}
