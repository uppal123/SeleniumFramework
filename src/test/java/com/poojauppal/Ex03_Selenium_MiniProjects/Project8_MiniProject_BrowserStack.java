package com.poojauppal.Ex03_Selenium_MiniProjects;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.poojauppal.Ex03_Selenium_MiniProjects.WaitHelper.waitJVM;

public class Project8_MiniProject_BrowserStack extends BaseTest{

    @Test
    @Description("Verify After login file can be uploaded")
    public void test_FileUpload() {
        driver.get("https://www.browserstack.com/users/sign_in");
        //WaitHelper.checkVisibility(driver.findElement(By.linkText("Sign up")));

        WebElement signup = driver.findElement(By.linkText("Sign up"));
        signup.click();

        waitJVM(20000);

        WebElement name = driver.findElement(By.xpath("//input[@id=user_full_name]"));
        name.sendKeys("Pooja");
        waitJVM(2000);
        driver.findElement(By.id("user_email_login")).sendKeys("test123@gmail.com");
        driver.findElement(By.id("user_password")).sendKeys("Test@123");
        driver.findElement(By.id("tnc_checkbox")).click();
        driver.findElement(By.id("user_submit")).click();


    }
}
