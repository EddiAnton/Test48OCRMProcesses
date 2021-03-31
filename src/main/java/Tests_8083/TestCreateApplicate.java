package Tests_8083;

import Services.Rerty;
import Services.XpathAuthorization;
import Services.XpathCreateApplicate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestCreateApplicate {
    final String DB_Data = "jdbc:oracle:thin:@server:1521:slx0";

    String userName = "Admin";
    String INN = "1234567890";

    @Test(retryAnalyzer = Rerty.class)
    public void createApplicate() {

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8083/SlxClient/logoff.aspx");
            driver.manage().window().maximize();

            WebElement logoffHref = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.linkText(XpathAuthorization.LOG_OFF_HREF));
            logoffHref.click();


            // Authorization in system
            WebElement inputUserName = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.INPUT_USERNAME));
            inputUserName.sendKeys(userName);

            WebElement submitButton = driver.findElement(By.xpath(XpathAuthorization.SUBMIT_BUTTON));
            submitButton.click();

            // Enter to "Clients"
            WebElement clientsTab = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathCreateApplicate.CLIENTS_TAB));
            clientsTab.click();

            // Enter INN in the field to search for a client and confirm your choice
            WebElement inputINN = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathCreateApplicate.FIELD_INN_OR_ACCOUNTNAME));
            inputINN.sendKeys(INN);

            WebElement confirmSelected = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(XpathCreateApplicate.CONFIRM_SELECTED_CUSTOMER));
            confirmSelected.click();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
