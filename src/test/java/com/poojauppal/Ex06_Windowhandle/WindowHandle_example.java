package com.poojauppal.Ex06_Windowhandle;

import com.poojauppal.Ex03_Selenium_MiniProjects.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandle_example extends BaseTest {
    @Test
    public void test_Windowhandles() {
        driver.get("https://the-internet.herokuapp.com/windows");

        String parent = driver.getWindowHandle();
        System.out.println("parent window -> " +parent);

        WebElement link = driver.findElement(By.linkText("Click Here"));
        link.click();

        Set<String> windowhandles = driver.getWindowHandles();
        System.out.println("multiplw windows ->" +windowhandles);

        for(String s : windowhandles) {
            driver.switchTo().window(s);
            if(driver.getPageSource().contains("New Window")){
                System.out.println("Test case is pass");
            }
            driver.switchTo().window(parent);
        }


    }
}
