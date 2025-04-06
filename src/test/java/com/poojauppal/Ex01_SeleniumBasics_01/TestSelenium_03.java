package com.poojauppal.Ex01_SeleniumBasics_01;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class TestSelenium_03 {

    @Description("Verify the navigations on page")
    @Test
    public void test_Selenium03() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");

        driver.navigate().to("https://bing.com");
        driver.navigate().refresh();
        Thread.sleep(5000);

        driver.navigate().back();
        Thread.sleep(5000);

        driver.navigate().forward();
        Thread.sleep(5000);

        driver.quit();
    }
}
