package com.poojauppal.Ex04_Actions;

import com.poojauppal.Ex03_Selenium_MiniProjects.BaseTest;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static com.poojauppal.Ex03_Selenium_MiniProjects.WaitHelper.waitJVM;

public class Actions_keyboard extends BaseTest {
    @Test
    @Description("Verify the functionality of keyboard action class")
    public void test_keys() {

        driver.get("https://awesomeqa.com/practice.html");

        WebElement firstname = driver.findElement(By.name("firstname"));
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).sendKeys(firstname, "pooja")
                .keyUp(Keys.SHIFT).build().perform();
    }

    @Test
    public void test_lastname() {
        WebElement lastname = driver.findElement(By.xpath("//input[@name=\"lastname\"]"));
        Actions actions1 = new Actions(driver);
        waitJVM(3000);
        actions1.keyDown(Keys.SHIFT).sendKeys(lastname, "uppal")
                .keyUp(Keys.SHIFT).build().perform();

    }

}
