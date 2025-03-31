package Ex02_SeleniumBasics_02;

import io.qameta.allure.Description;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class Project4_Katalon_MakeAppointment {
    @Test(groups = "sanity", priority = 1)
    @Description("Tc01 Verify the Url after clicking Make Appointment")
    public void test_Url () throws InterruptedException {
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
        //static dropdown
        Select select = new Select(driver.findElement(By.id("combo_facility")));
        select.selectByIndex(1);

        //WebElement checkbox = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission'']"));
        WebElement checkbox = driver.findElement(By.id("chk_hospotal_readmission"));
        checkbox.click();

        WebElement radiobutton = driver.findElement(By.cssSelector("input[value='Medicaid']"));
        radiobutton.click();

        WebElement calendar = driver.findElement(By.id("txt_visit_date"));
        calendar.sendKeys("09/04/2025");

        WebElement commentbox = driver.findElement(By.cssSelector("textarea[id='txt_comment']"));
        commentbox.sendKeys("This is comment.");

        WebElement appointment = driver.findElement(By.id("btn-book-appointment"));
        appointment.click();

        WebElement text = driver.findElement(By.xpath("//h2[text()='Appointment Confirmation']"));
        System.out.println("Confirmation message-> " +text.getText());
        Assert.assertEquals(text.getText(),"Appointment Confirmation");

        WebElement menu = driver.findElement(By.id("menu-toggle"));
        menu.click();

        WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
        logout.click();

        Assert.assertEquals(driver.getCurrentUrl(),"https://katalon-demo-cura.herokuapp.com/");
        System.out.println("User is logged out and page title is->" +driver.getTitle());
        Thread.sleep(2000);

        driver.quit();
    }
}
