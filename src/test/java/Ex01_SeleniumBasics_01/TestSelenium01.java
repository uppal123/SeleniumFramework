package Ex01_SeleniumBasics_01;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSelenium01 {
    @Description("Verify that URL is opening")
    @Test
    public void test_Selenium01() throws Exception {
        WebDriver driver = new EdgeDriver();
        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.manage().window().maximize();

        if(driver.getPageSource().contains("CURA Healthcare Service")){
            System.out.println("CURA Healthcare Service is visible");
            Assert.assertTrue(true);
        }
        else{
           //Assert.assertTrue(false);
            throw new Exception("CURA Healthcare Service is not visible");
        }
        driver.quit();
    }
}
