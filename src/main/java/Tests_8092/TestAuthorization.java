package Tests_8092;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestAuthorization {

    @Parameters({"userName", "password"})
    @Test
    public void testAuthorization(String userName, String password) {

        try {

            System.setProperty("webdriver.chrome.driver",
                    "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8093/SlxClient/logoff.aspx");

            WebElement logoffHref = driver.findElement(By
                    .linkText("Вернуться на страницу входа"));
            logoffHref.click();

            Thread.sleep(5000);

            // Authorization in system
            WebElement inputUserName = driver.findElement(By
                    .xpath("//input[@name='ctl00$ContentPlaceHolderArea$slxLogin$UserName']"));
            inputUserName.sendKeys(userName);

            WebElement inputPassword = driver.findElement(By
                    .xpath("//input[@name='ctl00$ContentPlaceHolderArea$slxLogin$Password']"));
            inputPassword.sendKeys(password);

            WebElement submitButton = driver.findElement(By
                    .xpath("//input[@name='ctl00$ContentPlaceHolderArea$slxLogin$btnLogin']"));
            submitButton.click();

            driver.close();

        } catch (InterruptedException e) {
            System.out.println("/TestAuthorization/ test failed");
            e.printStackTrace();
        }
        System.out.println("/TestAuthorization/ test passed");
    }
}
