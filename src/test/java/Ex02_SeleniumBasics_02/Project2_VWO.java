package Ex02_SeleniumBasics_02;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Project2_VWO {

    @Description("Verify error message")
    @Test
    public void test_loginPage() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://app.vwo.com");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.id("login-username"));
        email.sendKeys("Poojauppal");

        WebElement password = driver.findElement(By.id("login-password"));
        password.sendKeys("12345");

        WebElement submitbtn = driver.findElement(By.id("js-login-btn"));
        submitbtn.click();

        Thread.sleep(5000);

        WebElement content = driver.findElement(By.id("js-notification-box-msg"));
        content.click();
        assertThat(content.getText()).isEqualTo("Your email, password, IP address or location did not match");
        Assert.assertEquals(content.getText(),"Your email, password, IP address or location did not match");

        driver.quit();
    }
}
