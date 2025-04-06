package com.poojauppal.Ex01_SeleniumBasics_01;

import com.poojauppal.Ex03_Selenium_MiniProjects.BaseTest;
import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.poojauppal.Ex03_Selenium_MiniProjects.WaitHelper.checkAlert;

public class Alerts extends BaseTest {

    @Test
    @Description("Verify the alerts on page")
    public void test_Alerts() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        System.out.println("Title -> " + driver.getTitle());

        WebElement element = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        element.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();


//        //@Test
//        @Description("Verify all the  confirm alert on page")
//        public void test_Alerts_confirm() {
        WebElement elementconfirm = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        elementconfirm.click();

        checkAlert(driver, 3);
        // Alert alert = driver.switchTo().alert();
        // alert.accept();
        alert.dismiss();

        WebElement result = driver.findElement(By.id("result"));
        System.out.println("Result status-> " + result.getText());
    }

    @Test
    @Description("Verify all the  Prompt alert on page")
    public void test_Alerts_Prompt() {
        WebElement prompt = driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]"));
        prompt.click();

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Pooja");
        alert.accept();

        WebElement result = driver.findElement(By.id("result"));
        System.out.println("Result status-> " + result.getText());


    }
}

