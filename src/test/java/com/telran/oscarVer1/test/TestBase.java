package com.telran.oscarVer1.test;

import com.telran.pages.product.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

    public WebDriver driver;


    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        driver.get("http://selenium1py.pythonanywhere.com/en-gb/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        new HomePage(driver).selectLanguage("British English");
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void startTest() {
        logger.info("Test start");
    }

    @AfterMethod
    public void stopTest() {
        logger.info("Test start");
    }
}