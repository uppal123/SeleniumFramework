package Ex02_SeleniumBasics_02;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Project4_Katalon_MakeAppointment {
    @Test(groups = "sanity", priority = 1)
    @Description("Tc01 Verify the Url after clicking Make Appointment")
    public void test_Url () {
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        WebElement button = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        button.click();

        List<WebElement> email = driver.findElements(By.xpath("//input[@placeholder='Username']"));
        email.get(1).sendKeys("John Doe");

        List<WebElement> password = driver.findElements(By.xpath("//input[@placeholder='Password']"));
        password.get(1).sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.cssSelector("button[id='btn-login']"));
        loginButton.click();

//        Alert alert = driver.switchTo().alert();
//        alert.accept();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/#appointment");
        System.out.println("current url:-" +driver.getCurrentUrl());
//        if(driver.getCurrentUrl() == "https://katalon-demo-cura.herokuapp.com/#appointment"){
//            System.out.println("Url is matched");
//        }





        driver.quit();
    }
}
