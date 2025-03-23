package Ex01_SeleniumBasics_01;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestSelenium_02 {

    @Description("Open Browser")
    @Test
    public void test_selenium02() {
        WebDriver driver = new EdgeDriver();
        driver = new FirefoxDriver();
        driver = new ChromeDriver();
    }
}
