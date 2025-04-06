package com.poojauppal.Ex02_SeleniumBasics_02;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Project1_Katalon {

    @Description ("Verify Katalon page URL")
    @Test
    public void test_URL() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");

        WebElement login =  driver.findElement(By.id("btn-make-appointment"));
        login.click();

        WebElement email= driver.findElement(By.id("txt-username"));
        email.sendKeys("John Doe");

        WebElement password =  driver.findElement(By.id("txt-password"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement button = driver.findElement(By.id("btn-login"));
        button .click();
        Thread.sleep(5000);

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
       // assertThat(driver.getCurrentUrl()).isEqualTo("https://katalon-demo-cura.herokuapp.com/#appointment").isNotEmpty().isNotBlank();
        driver.quit();

    }
}
