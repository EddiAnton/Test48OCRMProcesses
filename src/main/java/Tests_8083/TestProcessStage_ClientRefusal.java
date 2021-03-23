package Tests_8083;

import Services.DataConversion;
import Services.XpathAuthorization;
import Services.XpathTestProcessStage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestProcessStage_ClientRefusal {

    final String DB_Data = "jdbc:oracle:thin:@server:1521:slx0";

    String userName = "Admin";
    String requestMask = "UC-TSP";

    String productOrderNumber = null;

    String applicationStatus = null;
    String newApplicationStatus = null;

    @Test
    public void goToClientRefusal() {

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8083/SlxClient/logoff.aspx");
            driver.manage().window().maximize();

            WebElement logoffHref = driver.findElement(By.linkText(XpathAuthorization.LOG_OFF_HREF));
            logoffHref.click();

            Thread.sleep(2000);

            // Authorization in system
            WebElement inputUserName = driver.findElement(By.xpath(XpathAuthorization.INPUT_USERNAME));
            inputUserName.sendKeys(userName);

            WebElement submitButton = driver.findElement(By.xpath(XpathAuthorization.SUBMIT_BUTTON));
            submitButton.click();

            Thread.sleep(2000);

            // Enter to "Data change requests"
            WebElement requestsHref = driver.findElement(By.xpath(XpathAuthorization.REQUESTS_HREF));
            requestsHref.click();

            Thread.sleep(5000);

            // Select UC requests
            WebElement filterUC = driver.findElement(By.xpath(XpathAuthorization.FILTER_UC_TSP));
            filterUC.click();

            Thread.sleep(2000);

            WebElement inputNumberOfRequest = driver.findElement(By.xpath(XpathAuthorization.INPUT_UC_TSP));
            inputNumberOfRequest.sendKeys(requestMask);

            WebElement submitSelect = driver.findElement(By.xpath(XpathAuthorization.SUBMIT_SELECT));
            submitSelect.click();
            Thread.sleep(2000);

            // Sort search result
            WebElement sortByModifiedDate = driver.findElement(By.xpath(XpathAuthorization.SORT_BY_MODIFIED_DATE_83));
            sortByModifiedDate.click();
            Thread.sleep(1000);
            sortByModifiedDate.click();
            Thread.sleep(5000);

            // Open the last application
            WebElement lastApplication = driver.findElement(By.xpath(XpathAuthorization.LAST_APPLICATION));
            lastApplication.click();
            Thread.sleep(2000);

            // Get data of the PRODUCTORDERNUMBER
            WebElement field_PRODUCTORDERNUMBER = driver.findElement(By
                    .xpath(XpathAuthorization.FIELD_PRODUCTORDERNUMBER));
            productOrderNumber = DataConversion.getProductOrderNumber(field_PRODUCTORDERNUMBER.getText());
            Thread.sleep(3000);

            // Get data of the application Status
            WebElement field_applicationStatus = driver.findElement(By
                    .xpath(XpathTestProcessStage.FIELD_APPLICATION_STATUS));
            applicationStatus = field_applicationStatus.getText();

            if (applicationStatus.equals("В РАБОТЕ") || applicationStatus.equals("ДОРАБОТКА")) {

                // Get data of the application Status
                WebElement continueRegistration = driver.findElement(By.xpath(XpathTestProcessStage.BUTTON_CONTINUE_REGISTRATION));
                continueRegistration.click();
                Thread.sleep(2000);

                // Selecting a stage from the drop-down list
                //Select statusList = new Select(driver.findElement(By.xpath(XpathTestProcessStage.OPEN_STATUS_LIST)));
                //statusList.selectByVisibleText("Отказ клиента");

                driver.findElement(By.xpath(XpathTestProcessStage.OPEN_STATUS_LIST)).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath(XpathTestProcessStage.STATUS_CLIENT_REFUSAL)).click();

                WebElement nextStage = driver.findElement(By.xpath(XpathTestProcessStage.BUTTON_NEXT_STAGE));
                nextStage.click();
                Thread.sleep(5000);

                newApplicationStatus = field_applicationStatus.getText();

            } else {

                System.out.println("Невозможно перейти с текущего статуса.");

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

        System.out.println(productOrderNumber);
        System.out.println("---------------");
        System.out.println("Текущий статус: " + applicationStatus);
        System.out.println("Новый статус: " + newApplicationStatus);
        System.out.println("---------------");
    }
}
