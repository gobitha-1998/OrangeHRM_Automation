package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.time.Duration;

public class Validations {
    public WebDriver driver;

    @BeforeSuite
    public void launchChrome() {
        WebDriverManager.chromedriver().setup();
//        chrome Browser
        driver = new ChromeDriver();
//        Firefox Browser
//        driver = new FirefoxDriver();?

        driver.get(" https://www.google.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.navigate().to("https://www.flipkart.com/");
    }

    @Test (priority = 1)
    public void logInDisplay() {
        WebElement LogIN= driver.findElement(By.linkText("Login"));
        boolean Display = LogIN.isDisplayed();
        System.out.println("Login Display Status: " + Display);
    }

    @Test (priority = 2)
    public void searchEnable() {
        WebElement ProductSearch = driver.findElement(By.xpath("//input[@name='q']"));
        boolean Enable = ProductSearch.isDisplayed();
        System.out.println("Login Display Status: " + Enable);
    }

    @Test (priority = 3)
    public void productSelect() throws InterruptedException {
        WebElement SelectAProduct = driver.findElement(By.xpath("//div[@class='_58bkzq63 _3n8fnawg _3n8fnaod _3n8fnag9 _3n8fna1 _3n8fna85 _58bkzqg _1i2djtb9 _1i2djt0']"));
        Thread.sleep(2000);
        SelectAProduct.click();
        Thread.sleep(2000);


        WebElement CheckBox = driver.findElement(By.xpath("//div[@class='_6i1qKy']"));
        Thread.sleep(2000);
        CheckBox.click();
        Thread.sleep(2000);

        boolean Selected = CheckBox.isSelected();
        System.out.println("Checkbox Selected Status: " + Selected);
    }

   /* @AfterSuite
    public void closeChrome() {
        driver.quit();
    }*/
}
