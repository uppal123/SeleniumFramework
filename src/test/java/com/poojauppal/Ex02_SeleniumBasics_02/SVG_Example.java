package com.poojauppal.Ex02_SeleniumBasics_02;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static com.poojauppal.Ex03_Selenium_MiniProjects.WaitHelper.checkVisibility;
import static com.poojauppal.Ex03_Selenium_MiniProjects.WaitHelper.waitJVM;

public class SVG_Example {
    EdgeDriver driver;

    @BeforeTest
    public void openBrowser() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        driver = new EdgeDriver(edgeOptions);
        driver.manage().window().maximize();
    }

    @Test
    @Description("Verify the SVG element of filpkart search icon")
    public void test_flipkart_searchIcon() {
        driver.get("https://www.flipkart.com/search");
        driver.findElement(By.name("q")).sendKeys("macmini");

        //click on svg element
        List<WebElement> svgElement = driver.findElements(By.xpath("//*[name()='svg']"));
        svgElement.get(0).click();

        checkVisibility(driver, By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));

        List<WebElement> title = driver.findElements(By.xpath("//div[contains(@data-id,'CPU')]/div/a[2]"));
        for (WebElement titles : title) {
            System.out.println(titles.getText());
        }
    }

    @AfterTest
    public void closeBrowser() {
        waitJVM(3000);
        driver.quit();
    }
}
