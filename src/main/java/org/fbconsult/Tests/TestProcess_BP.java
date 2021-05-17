package org.fbconsult.Tests;

import java.sql.*;
import java.util.concurrent.TimeUnit;
import org.fbconsult.Services.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestProcess_BP {

    final String requestMask = "UC-SIT";
    String productOrderNumber = null;
    String fb_productOrderID = null;

    String applicationStage = null;
    String applicationStatus = null;

    @Parameters({"contour"})
    @Test(retryAnalyzer = Rerty.class)
    public void goProcessE2E(String contour) {

        TestEnvironment testEnvironment = new TestEnvironment(contour);

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_90\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection_SYSDBA = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");
            Connection connection_NM_CRM = DriverManager.getConnection(testEnvironment.getDB_data(), "NM_CRM", "masterkey");
            Statement statement_SYSDBA = connection_SYSDBA.createStatement();

            driver.get(testEnvironment.getUrl());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            WebElement logoffHref = new WebDriverWait(driver, 30).until(
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




            /** Receive an application from the Business Portal  */

            ModelingBP.createApplicationFromBP(connection_NM_CRM);

            // Enter to "Data change requests"
            WebElement requestsHref = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.REQUESTS_HREF)));
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

            // Open the last application
            WebElement lastApplication = new WebDriverWait(driver, 15).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathAuthorization.LAST_APPLICATION)));
            lastApplication.click();

            // Get data of the PRODUCTORDERNUMBER
            WebElement field_PRODUCTORDERNUMBER = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.FIELD_PRODUCTORDERNUMBER)));
            productOrderNumber = DataConversion.getProductOrderNumber(field_PRODUCTORDERNUMBER.getText());

            // Get data of the FB_PRODUCTORDERID
            WebElement field_PRODUCTORDER = driver.findElement(By
                    .xpath(XpathAuthorization.FIELD_PRODUCTORDER));
            fb_productOrderID = DataConversion.getFB_ProductOrderID(field_PRODUCTORDER.getAttribute("baseURI"));

            // Get data of the application Status
            WebElement field_applicationStatus = new WebDriverWait(driver, 20).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathTestProcessStage.FIELD_APPLICATION_STATUS)));
            applicationStatus = field_applicationStatus.getText();

            // Get data of the application Stage
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

            ResultSet rs_stageName = statement_SYSDBA.executeQuery(selectTableSQLForStageName);
            while (rs_stageName.next()) {
                applicationStage = rs_stageName.getString("STAGENAME");
            }

            System.out.println("---------------");
            System.out.println("Стадия заявки: " + applicationStage);
            System.out.println("Статус заявки: " + applicationStatus);


            /** Receive the Main Client data from the CFT system  */

            ModelingCFT.getCustomerData(fb_productOrderID, connection_NM_CRM);

            // Get the current data on the application
            driver.navigate().refresh();

            // Get the current data on the application
            // Get data of the application Stage
            ResultSet rs_stageName_4 = statement_SYSDBA.executeQuery(selectTableSQLForStageName);
            while (rs_stageName_4.next()) {
                applicationStage = rs_stageName_4.getString("STAGENAME");
            }
            // Get data of the application Status
            WebElement field_applicationStatus_new2 = new WebDriverWait(driver, 20).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathTestProcessStage.FIELD_APPLICATION_STATUS)));
            applicationStatus = field_applicationStatus_new2.getText();

            System.out.println("---------------");
            System.out.println("Стадия заявки: " + applicationStage);
            System.out.println("Статус заявки: " + applicationStatus);


        } catch (InterruptedException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
