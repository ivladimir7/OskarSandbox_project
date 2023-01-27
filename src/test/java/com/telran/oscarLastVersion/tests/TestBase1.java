package com.telran.oscarLastVersion.tests;

import com.telran.pages.BasePage;
import com.telran.pages.product.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class TestBase1 {
    public WebDriver driver;

    Logger logger = LoggerFactory.getLogger(TestBase1.class);


    @BeforeMethod
    public void init() {
        driver = new ChromeDriver();
        driver.get("https://latest.oscarcommerce.com/en-gb/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        new HomePage(driver).selectLanguage("British English");
    }


    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void startTest(Method m, Object[] p) {
        logger.info("Test start " + m.getName() + " with data: " + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: test method " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: Test method " + result.getMethod().getMethodName() + " " + "Screenshot: " + new BasePage(driver).takeScreenshotWithScrollDown());
        }
    }
}