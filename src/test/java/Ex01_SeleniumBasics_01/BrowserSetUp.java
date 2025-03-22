package Ex01_SeleniumBasics_01;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BrowserSetUp {
    @Test
    public void test_VerifyVWOSetUp() {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://app.vwo.com/#/login");
        System.out.println(driver.getTitle());
        System.out.println(driver.getSessionId());
    }
}
