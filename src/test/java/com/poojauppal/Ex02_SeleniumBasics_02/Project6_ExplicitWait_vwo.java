package com.poojauppal.Ex02_SeleniumBasics_02;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;

public class Project6_ExplicitWait_vwo {

    @Test
    @Description("Verify the Explicit wait")
    public void test_ExplicitWait() {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("Poojauppal");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("12345");

        WebElement submitbtn = driver.findElement(By.id("js-login-btn"));
        submitbtn.click();

        // until this notification displayed or visible we have to wait for max = 3

        //Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js-notification-box-msg")));

        WebElement content = driver.findElement(By.id("js-notification-box-msg"));
        //content.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait1.until(ExpectedConditions.textToBePresentInElement(content,"Your email, password, IP address or location did not match"));
        assertThat(content.getText()).isEqualTo("Your email, password, IP address or location did not match");
        Assert.assertEquals(content.getText(),"Your email, password, IP address or location did not match");


        driver.quit();
    }
}
