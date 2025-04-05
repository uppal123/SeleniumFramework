package com.poojauppal.Ex03_Selenium_MiniProjects;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.poojauppal.Ex03_Selenium_MiniProjects.WaitHelper.waitJVM;

public class BaseTest {
    public EdgeDriver driver;
    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        edgeOptions.addArguments("--maximize");
        driver = new EdgeDriver(edgeOptions);

    }

    @AfterTest
    public void closeBrowser() {
        waitJVM(5000);
        driver.quit();

    }
}
