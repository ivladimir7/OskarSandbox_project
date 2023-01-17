package com.telran.oskarLastVersion.tests;

import com.telran.pages.BasePage;
import org.testng.annotations.Test;

public class HomepageTest extends TestBase1{

        @Test
        public void openHomePageTest() {

            new BasePage(driver).takeScreenshotWithScrollDown();

        }
}

