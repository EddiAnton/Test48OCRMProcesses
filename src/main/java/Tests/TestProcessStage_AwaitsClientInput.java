package Tests;

import Services.DataConversion;
import Services.TestEnvironment;
import Services.XpathAuthorization;
import Services.XpathTestProcessStage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestProcessStage_AwaitsClientInput {

    String requestMask = "UC-TSP";
    String productOrderNumber = null;
    String fb_productOrderID = null;

    String applicationStage = null;
    String applicationStatus = null;
    String newApplicationStage = null;
    String newApplicationStatus = null;

    @Parameters({"contour"})
    @Test
    public void goToAwaitsClientInput(String contour) {

        TestEnvironment testEnvironment = new TestEnvironment(contour);

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            System.out.println();
            System.out.println("Test Process Stage AwaitsClientInput is starting...");
            System.out.println();

            driver.get(testEnvironment.getUrl());
            driver.manage().window().maximize();

            WebElement logoffHref =new WebDriverWait(driver, 15).until(
                    ExpectedConditions.elementToBeClickable(By.linkText(XpathAuthorization.LOG_OFF_HREF)));
            logoffHref.click();

            // Authorization in system
            WebElement inputUserName = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.INPUT_USERNAME)));
            inputUserName.sendKeys(testEnvironment.getUserName());

            WebElement inputPassword = driver.findElement(By.xpath(XpathAuthorization.INPUT_PASSWORD));
            inputPassword.sendKeys(testEnvironment.getPassword());

            WebElement submitButton = driver.findElement(By.xpath(XpathAuthorization.SUBMIT_BUTTON));
            submitButton.click();

            // Enter to "Data change requests"
            WebElement requestsHref = new WebDriverWait(driver, 15).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathAuthorization.REQUESTS_HREF)));
            requestsHref.click();


            // Select UC requests
            WebElement filterUC = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathAuthorization.FILTER_UC_TSP)));
            filterUC.click();


            WebElement inputNumberOfRequest = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.INPUT_UC_TSP)));
            inputNumberOfRequest.sendKeys(requestMask);

            WebElement submitSelect = driver.findElement(By.xpath(XpathAuthorization.SUBMIT_SELECT));
            submitSelect.click();

            // Sort search result
            WebElement sortByModifiedDate;
            if (contour.equals("8083")) {
                sortByModifiedDate = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathAuthorization.SORT_BY_MODIFIED_DATE_83)));
            } else {
                sortByModifiedDate = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathAuthorization.SORT_BY_MODIFIED_DATE)));
            }
            sortByModifiedDate.click();
            Thread.sleep(1000);
            sortByModifiedDate.click();
            Thread.sleep(1000);

            // Open the last application
            WebElement lastApplication = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathAuthorization.LAST_APPLICATION)));
            lastApplication.click();

            WebElement field_applicationStatus = new WebDriverWait(driver, 50).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathTestProcessStage.FIELD_APPLICATION_STATUS)));
            Thread.sleep(1000);

            // Get data of the PRODUCTORDERNUMBER
            WebElement field_PRODUCTORDERNUMBER = driver.findElement(By
                    .xpath(XpathAuthorization.FIELD_PRODUCTORDERNUMBER));
            productOrderNumber = DataConversion.getProductOrderNumber(field_PRODUCTORDERNUMBER.getText());
            // Get data of the FB_PRODUCTORDERID
            WebElement field_PRODUCTORDER = driver.findElement(By
                    .xpath(XpathAuthorization.FIELD_PRODUCTORDER));
            fb_productOrderID = DataConversion.getFB_ProductOrderID(field_PRODUCTORDER.getAttribute("action"));


            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");

            Statement statement = connection.createStatement();

            String selectTableSQLForStageName = "SELECT ps1.name AS StageName " +
                    "FROM sysdba.fb_processstageaudit psa1 " +
                    "INNER JOIN sysdba.fb_processaudit pa1 " +
                    "ON (psa1.fb_processauditid = pa1.fb_processauditid) " +
                    "INNER JOIN sysdba.fb_processstage ps1 " +
                    "ON (psa1.currentstageid = ps1.fb_processstageid) " +
                    "WHERE pa1.entityid = '" + fb_productOrderID + "' " +
                    "ORDER BY psa1.createdate " +
                    "DESC " +
                    "FETCH NEXT 1 ROWS ONLY";

            ResultSet rs_stageName = statement.executeQuery(selectTableSQLForStageName);
            while (rs_stageName.next()) {
                applicationStage = rs_stageName.getString("STAGENAME");
            }


            // Get data of the application Status
            applicationStatus = field_applicationStatus.getText();

            if (applicationStatus.equals("В работе") || applicationStatus.equals("ДОРАБОТКА")) {

                // Get data of the application Status
                WebElement continueRegistration  = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathTestProcessStage.BUTTON_CONTINUE_REGISTRATION)));
                continueRegistration.click();

                // Selecting a stage from the drop-down list
                driver.findElement(By.xpath(XpathTestProcessStage.OPEN_STATUS_LIST)).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath(XpathTestProcessStage.STATUS_AWAITS_CLIENT_INPUT)).click();

                WebElement nextStage  = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathTestProcessStage.BUTTON_NEXT_STAGE)));
                nextStage.click();
                Thread.sleep(5000);

                newApplicationStatus = field_applicationStatus.getText();

            } else {

                System.out.println("Невозможно перейти с текущего статуса.");

            }

            ResultSet rs_newStageName = statement.executeQuery(selectTableSQLForStageName);
            while (rs_newStageName.next()) {
                newApplicationStage = rs_newStageName.getString("STAGENAME");
            }
            connection.close();

        } catch (InterruptedException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

        System.out.println("---------------");
        System.out.println(productOrderNumber);
        System.out.println("---------------");
        System.out.println("Начальная стадия: " + applicationStage);
        System.out.println("Начальный статус: " + applicationStatus);
        System.out.println("Новая стадия: " + newApplicationStage);
        System.out.println("Новый статус: " + newApplicationStatus);
        System.out.println("---------------");

    }

}
