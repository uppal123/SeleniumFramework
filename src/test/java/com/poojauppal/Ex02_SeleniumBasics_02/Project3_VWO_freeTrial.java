package com.poojauppal.Ex02_SeleniumBasics_02;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class Project3_VWO_freeTrial {
    @Description("Tc01 Verify that invalid email gives error message on signup page")
    @Test(groups = "sanity", priority = 1)
    public void test_freeTrialErrorMessage() {
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://app.vwo.com");

        WebElement link = driver.findElement(By.partialLinkText("Start a"));
        link.click();

        System.out.println("current url: " +driver.getCurrentUrl());
        Assert.assertTrue(driver.getCurrentUrl().contains("free-trial"));

        WebElement email = driver.findElement(By.id("page-v1-step1-email"));
        email.sendKeys("abs");

        WebElement checkbox = driver.findElement(By.name("gdpr_consent_checkbox"));
        checkbox.click();

        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

      List<WebElement> error = driver.findElements(By.className("invalid-reason"));
        //Assert.assertTrue(error.isDisplayed());
        Assert.assertEquals(error.get(0).getText(),"The email address you entered is incorrect.");
        driver.quit();
    }
}
