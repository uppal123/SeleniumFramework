package com.poojauppal.Ex01_SeleniumBasics_01;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class TestSelenium_05 {

    @Description("Add extension")
    @Test
    public void test_Selenium05() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--window-size=1920,1080");
        options.addExtensions(new File("src/test/java/Ex01_SeleniumBasics_01/AdBlock-—-block-ads-across-the-web-Chrome-Web-Store.crx"));

        WebDriver driver = new EdgeDriver(options);
        driver.get("https://www.youtube.com/watch?v=BwTSxsAqlEc");
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
