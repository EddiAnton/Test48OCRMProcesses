package TestSuites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNameOfCompany {

    @Test
    public void testWebConnectionLinux() {

        WebDriver driver = new ChromeDriver();
        try {
            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8093/SlxClient/logoff.aspx");
    } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWebConnectionWindows() {

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        try {
            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8093/SlxClient/logoff.aspx");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
