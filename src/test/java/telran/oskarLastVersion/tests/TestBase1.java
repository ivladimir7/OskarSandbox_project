package telran.oskarLastVersion.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase1 {
    public WebDriver driver;


    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://latest.oscarcommerce.com/en-gb/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

}

