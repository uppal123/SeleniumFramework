package com.poojauppal.Ex03_Selenium_MiniProjects;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static com.poojauppal.Ex03_Selenium_MiniProjects.WaitHelper.waitJVM;

public class Project7_WindowHandle_MiniProject extends BaseTest{

    @Test
    @Description("Verify the iframe, windowhandle, action concept")
    public void test_vwoProject() {
        driver.get("https://app.vwo.com/#/test/ab/13/heatmaps/1?token=eyJhY2NvdW50X2lkIjo2NjY0MDAsImV4cGVyaW1lbnRfaWQiOjEzLCJjcmVhdGVkX29uIjoxNjcxMjA1MDUwLCJ0eXBlIjoiY2FtcGFpZ24iLCJ2ZXJzaW9uIjoxLCJoYXNoIjoiY2IwNzBiYTc5MDM1MDI2N2QxNTM5MTBhZDE1MGU1YTUiLCJzY29wZSI6IiIsImZybiI6ZmFsc2V9&isHttpsOnly=1");
        driver.manage().window().maximize();

        //get parent window session id
        String parent = driver.getWindowHandle();
        System.out.println("parent window ->" +parent);

        //move to variation 1
       List<WebElement> var1 = driver.findElements(By.xpath("//img[@data-qa=\"danawobuqa\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(var1.get(1)).click().build().perform();

        //wait to load page
        waitJVM(15000);

        Set<String> allHandles = driver.getWindowHandles();
        System.out.println("child window-> " +allHandles);

        //switch to child window
        for(String handle : allHandles){
            if(!handle.equals(parent)){
                driver.switchTo().window(handle);
                //now i am in child window
                driver.switchTo().frame("heatmap-iframe");

                WebElement clickmap = driver.findElement(By.xpath("//div[@data-qa=\"liqokuxuba\"]"));
                clickmap.click();
            }
        }
    }
}
