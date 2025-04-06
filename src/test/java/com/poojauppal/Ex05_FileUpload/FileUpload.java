package com.poojauppal.Ex05_FileUpload;

import com.poojauppal.Ex03_Selenium_MiniProjects.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FileUpload  extends BaseTest {

    @Test
    public void text_fileUpload() {
        driver.get("https://awesomeqa.com/selenium/upload.html");
        WebElement chooseToUpload = driver.findElement(By.id("fileToUpload"));
        String workingDir = System.getProperty("user.dir");
        System.out.println(workingDir);

        chooseToUpload.sendKeys(workingDir + "/src/test/java/FileUpload/Testfile.txt");
        driver.findElement(By.name("submit")).click();
    }
}
