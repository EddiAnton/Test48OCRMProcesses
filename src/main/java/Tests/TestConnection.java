package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestConnection {

    @Test
    public void testWebConnectionLinux() {

        try {

            WebDriver driver = new ChromeDriver();

            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8093/SlxClient/logoff.aspx");

            driver.close();

        } catch (InterruptedException e) {
            System.out.println("/WebConnectionLinux/ test failed");
            e.printStackTrace();
        }
        System.out.println("/WebConnectionLinux/ test passed");
    }

    @Test
    public void testWebConnectionWindows() {

        try {

            System.setProperty("webdriver.chrome.driver",
                    "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

            WebDriver driver = new ChromeDriver();

            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8093/SlxClient/logoff.aspx");

            driver.close();

        } catch (InterruptedException e) {
            System.out.println("/WebConnectionWindows/ test failed");
            e.printStackTrace();
        }
        System.out.println("/WebConnectionWindows/ test passed");
    }
}
