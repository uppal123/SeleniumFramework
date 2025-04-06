package com.poojauppal.Ex04_Actions;

import com.poojauppal.Ex03_Selenium_MiniProjects.BaseTest;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MoveToElement extends BaseTest {

    @Test
    @Description("Verify the Actions on spice jet page")
    public void test_actions() {

        driver.get("https://www.spicejet.com/");
       // driver.manage().window().maximize();
        WebElement from = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-origin\"]/div/div/input"));
        WebElement to = driver.findElement(By.xpath("//div[@data-testid=\"to-testID-destination\"]/div/div/input"));
       // WebElement selectdestination = driver.findElement(By.xpath("//div[contains(text(),'AGR')]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(from).click().sendKeys("Mum").build().perform();
        actions.moveToElement(to).click().sendKeys("BLR").build().perform();

//        WebElement search = driver.findElement(By.xpath("//div[@data-testid=\"home-page-flight-cta\"]"));
//        search.click();
    }
}
