package org.fbconsult.Tests;

import org.fbconsult.Services.Rerty;
import org.fbconsult.Services.TestEnvironment;
import org.fbconsult.Services.XpathAuthorization;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestAuthorization {

    String contour;
    TestEnvironment testEnvironment;
    WebDriver driver;

    @Parameters({"contour"})
    @Test
    public void testAuthorization(String contour) {

        this.contour = contour;
        System.out.println("Test Authorization is starting...");

        System.setProperty("webdriver.chrome.driver",
                    "D:\\selenium\\drivers\\chromedriver_90\\chromedriver.exe");

        testEnvironment = new TestEnvironment(contour);
        driver =  new ChromeDriver();

        driver.get(testEnvironment.getUrl());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement logoffHref = driver.findElement(By.xpath(XpathAuthorization.LOG_OFF_HREF_xpath));
        logoffHref.click();

        // Authorization in system
        WebElement inputUserName = driver.findElement(By.xpath(XpathAuthorization.INPUT_USERNAME));
        inputUserName.sendKeys(testEnvironment.getUserName());

        WebElement inputPassword = driver.findElement(By.xpath(XpathAuthorization.INPUT_PASSWORD));
        inputPassword.sendKeys(testEnvironment.getPassword());

        WebElement submitButton = driver.findElement(By.xpath(XpathAuthorization.SUBMIT_BUTTON));
        submitButton.click();
    }
}
