package com.poojauppal.Ex02_SeleniumBasics_02;

import com.poojauppal.Ex03_Selenium_MiniProjects.BaseTest;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class SVG_Map extends BaseTest {

    @Test
    @Description("Verify the state Delhi is appearing")
    public void test_State() {
        driver.get("https://www.amcharts.com/svg-maps/?map=india");

        List<WebElement> state = driver.findElements(By.xpath("//*[name()='svg']/*[name()='g'][7]/*[name()='g']/*[name()='g']/*[name()='path']"));
        for(WebElement states : state){
            System.out.println(states.getDomAttribute("aria-label"));
            if(states.getDomAttribute("aria-label").contains("Delhi ")){
                states.click();
            }
        }

    }
}
