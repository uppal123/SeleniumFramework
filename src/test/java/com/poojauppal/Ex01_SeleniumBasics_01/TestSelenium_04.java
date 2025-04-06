package com.poojauppal.Ex01_SeleniumBasics_01;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class TestSelenium_04 {
    @Description("Option class")
    @Test
    public void test_Selenium04 () throws InterruptedException {
        EdgeOptions options = new EdgeOptions();

        // EdgeOptions -> It will help you set the browser
        // options to browsers
        // window - size
        // headless mode - there is not UI -> advantage - Fast Execution
        // full UI mode - default - UI browser
        // incognito mode - switch
        // start Max
        // add extensions - browsers
        // 100 + others , https , http
        // localstorage, download ?

        //options.addArguments("----window-size=1280,720");
        //options.addArguments(("--window-size=800,600"));
        //options.addArguments("--incognito");
        //options.addArguments("--start-maximized");
        options.addArguments("--headless");

        EdgeDriver driver = new EdgeDriver(options);
        Thread.sleep(5000);
        driver.quit();
    }
}
