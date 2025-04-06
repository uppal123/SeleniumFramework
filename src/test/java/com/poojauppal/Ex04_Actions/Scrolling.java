package com.poojauppal.Ex04_Actions;

import com.poojauppal.Ex03_Selenium_MiniProjects.BaseTest;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static com.poojauppal.Ex03_Selenium_MiniProjects.WaitHelper.waitJVM;

public class Scrolling extends BaseTest {

    @Test
    public void test_scrolling() {
        driver.get("https://thetestingacademy.com/");
        Actions ac = new Actions(driver);
        ac.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).build().perform();
        waitJVM(3000);
        ac.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).build().perform();

    }
}
