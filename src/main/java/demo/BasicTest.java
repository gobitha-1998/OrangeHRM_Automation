package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasicTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get(" https://www.google.com/");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        Navigation to OrangeHRM
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        Thread.sleep(2000);

//        Login
        WebElement Username= driver.findElement(By.xpath("//input[@name = 'username']"));

        Username.sendKeys("Admin");
        Thread.sleep(2000);

        WebElement Password = driver.findElement(By.xpath("//input[@name = 'password']"));

        Password.sendKeys("admin123");
        Thread.sleep(2000);

        WebElement LoginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        LoginButton.click();
        Thread.sleep(2000);

//      Search on Search bar
        WebElement Search = driver.findElement(By.xpath("//input[@placeholder = 'Search']"));

        Thread.sleep(2000);
        Search.sendKeys("My info");

//      Navigation to My info
        WebElement My_info = driver.findElement(By.linkText(" My info"));

        Thread.sleep(2000);
        My_info.click();

        driver.quit();

    }

}
