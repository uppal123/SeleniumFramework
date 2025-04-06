package com.poojauppal.Ex04_Actions;

import com.poojauppal.Ex03_Selenium_MiniProjects.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop extends BaseTest {

    @Test
    public void test_dragAndDrop() {
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");

        WebElement from = driver.findElement(By.id("column-a"));
        WebElement to = driver.findElement(By.id("column-b"));

        Actions ac = new Actions(driver);
        ac.dragAndDrop(from,to).build().perform();
    }
}
