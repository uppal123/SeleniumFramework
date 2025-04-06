package com.poojauppal.Ex02_SeleniumBasics_02;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Project5_MMT {

    @Test(priority = 1, groups = "regression")
    @Description("Verify the Modal of mmt page")
    public void test_Modal() {

        WebDriver driver = new EdgeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        System.out.println("Page Title: " +driver.getTitle());

        WebElement clickModal = driver.findElement(By.xpath("//span[@data-cy='closeModal']"));
        clickModal.click();
        WebElement clickImage = driver.findElement(By.xpath("//img[@alt='Make My Trip']"));
        clickImage.click();
        WebElement clickMenu = driver.findElement(By.xpath("//li[@data-cy='menu_Trains']"));
        clickMenu.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("railways"));
        System.out.println("now URL is : " +driver.getCurrentUrl());
        System.out.println(" and Title is : " +driver.getTitle());
        
        driver.quit();
    }
}
