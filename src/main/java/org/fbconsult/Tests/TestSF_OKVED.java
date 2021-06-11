package org.fbconsult.Tests;

import org.fbconsult.Services.DataComparison;
import org.fbconsult.Services.DataConversion;
import org.fbconsult.Services.DateReplace;
import org.fbconsult.Services.TestEnvironment;
import org.fbconsult.Services.XpathAuthorization;
import org.fbconsult.Services.XpathOKVED;

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
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TestSF_OKVED {

    final String requestMask = "UC-TSP";
    String productOrderNumber = null;

    String test_CODE_OKVED = null;
    String test_CODENAME_OKVED = null;
    String test_BEGINDATE_OKVED = null;
    String test_ENDDATE_OKVED = null;
    String test_ISPRIMARY_OKVED = null;

    String codeOKVED_type_1 = null;
    String nameOKVED_type_1 = null;
    String beginDateOKVED_type_1 = null;
    String endDateOKVED_type_1 = null;
    String isPrimaryOKVED_type_1 = null;

    String codeOKVED_type_2 = null;
    String nameOKVED_type_2 = null;
    String beginDateOKVED_type_2 = null;
    String endDateOKVED_type_2 = null;
    String isPrimaryOKVED_type_2 = null;

    String codeOKVED_type_3 = null;
    String nameOKVED_type_3 = null;
    String beginDateOKVED_type_3 = null;
    String endDateOKVED_type_3 = null;
    String isPrimaryOKVED_type_3 = null;

    @Parameters({"contour"})
    @Test
    public void testOKVED(String contour) {

        TestEnvironment testEnvironment = new TestEnvironment(contour);

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_90\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            driver.get(testEnvironment.getUrl());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            WebElement logoffHref = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.elementToBeClickable(By.linkText(XpathAuthorization.LOG_OFF_HREF)));
            logoffHref.click();

            // Authorization in system
            WebElement inputUserName = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.INPUT_USERNAME)));
            inputUserName.sendKeys(testEnvironment.getUserName());

            WebElement inputPassword = driver.findElement(By.xpath(XpathAuthorization.INPUT_PASSWORD));
            inputPassword.sendKeys(testEnvironment.getPassword());

            WebElement submitButton = driver.findElement(By.xpath(XpathAuthorization.SUBMIT_BUTTON));
            submitButton.click();
            Thread.sleep(1000);

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
            WebElement field_PRODUCTORDERNUMBER = new WebDriverWait(driver, 20).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.FIELD_PRODUCTORDERNUMBER)));
            productOrderNumber = DataConversion.getProductOrderNumber(field_PRODUCTORDERNUMBER.getText());

            // Select the OKVED tab
            WebElement OKVEDTab = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathOKVED.OKVED_TAB)));
            OKVEDTab.click();

            // Disclose data on the OKVED - " V "
            WebElement openOKVED;
            if (contour.equals("8083")) {
                openOKVED = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathOKVED.OPEN_OKVED_8083)));
            } else {
                openOKVED = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathOKVED.OPEN_OKVED_8092)));
            }
            openOKVED.click();

            // Get data of the OKVED type
            WebElement field_CODE_OKVED;
            if (contour.equals("8083")) {
                field_CODE_OKVED = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathOKVED.FIELD_CODE_OKVED_8083)));
            } else {
                field_CODE_OKVED = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathOKVED.FIELD_CODE_OKVED_8092)));
            }
            test_CODE_OKVED = field_CODE_OKVED.getAttribute("value");

            WebElement field_CODENAME_OKVED;
            if (contour.equals("8083")) {
                field_CODENAME_OKVED = driver.findElement(By.xpath(XpathOKVED.FIELD_CODENAME_OKVED_8083));
            } else {
                field_CODENAME_OKVED = driver.findElement(By.xpath(XpathOKVED.FIELD_CODENAME_OKVED_8092));
            }
            test_CODENAME_OKVED = field_CODENAME_OKVED.getAttribute("value");

            WebElement field_BEGINDATE_OKVED;
            if (contour.equals("8083")) {
                field_BEGINDATE_OKVED = driver.findElement(By.xpath(XpathOKVED.FIELD_BEGINDATE_OKVED_8083));
            } else {
                field_BEGINDATE_OKVED = driver.findElement(By.xpath(XpathOKVED.FIELD_BEGINDATE_OKVED_8092));
            }
            test_BEGINDATE_OKVED = field_BEGINDATE_OKVED.getAttribute("value");

            WebElement field_ENDDATE_OKVED;
            if (contour.equals("8083")) {
                field_ENDDATE_OKVED = driver.findElement(By.xpath(XpathOKVED.FIELD_ENDDATE_OKVED_8083));
            } else {
                field_ENDDATE_OKVED = driver.findElement(By.xpath(XpathOKVED.FIELD_ENDDATE_OKVED_8092));
            }
            test_ENDDATE_OKVED = field_ENDDATE_OKVED.getAttribute("value");

            WebElement field_ISPRIMARY_OKVED;
            if (contour.equals("8083")) {
                field_ISPRIMARY_OKVED = driver.findElement(By.xpath(XpathOKVED.FIELD_ISPRIMARY_OKVED_8083));
            } else {
                field_ISPRIMARY_OKVED = driver.findElement(By.xpath(XpathOKVED.FIELD_ISPRIMARY_OKVED_8092));
            }
            test_ISPRIMARY_OKVED = field_ISPRIMARY_OKVED.getAttribute("value");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(productOrderNumber);
        System.out.println("---------------");
        System.out.println(test_CODE_OKVED);
        System.out.println(test_CODENAME_OKVED);
        System.out.println(test_BEGINDATE_OKVED);
        System.out.println(test_ENDDATE_OKVED);
        System.out.println(test_ISPRIMARY_OKVED);
        System.out.println("---------------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");

            String selectTableSQLForType_1_okved = "SELECT fbpomcode.CODE, " +
                    "fbpomcode.CODENAME, " +
                    "fbpomcode.BEGINDATE, " +
                    "fbpomcode.ENDDATE, " +
                    "fbpomcode.ISPRIMARY " +
                    "FROM sysdba.fb_productordmemb_code fbpomcode " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpomcode.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '1' " +
                    "AND fbpomd.isprimary = 'T' " +
                    "AND fbpomcode.code = '" + test_CODE_OKVED + "'";

            String selectTableSQLForType_2_okved = "SELECT fbpomcode.CODE, " +
                    "fbpomcode.CODENAME, " +
                    "fbpomcode.BEGINDATE, " +
                    "fbpomcode.ENDDATE, " +
                    "fbpomcode.ISPRIMARY " +
                    "FROM sysdba.fb_productordmemb_code fbpomcode " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpomcode.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '2' " +
                    "AND fbpomd.isprimary = 'T' " +
                    "AND fbpomcode.code = '" + test_CODE_OKVED + "'";

            String selectTableSQLForType_3_okved = "SELECT fbpomcode.CODE, " +
                    "fbpomcode.CODENAME, " +
                    "fbpomcode.BEGINDATE, " +
                    "fbpomcode.ENDDATE, " +
                    "fbpomcode.ISPRIMARY " +
                    "FROM sysdba.fb_productordmemb_code fbpomcode " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpomcode.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '3' " +
                    "AND fbpomd.isprimary = 'T' " +
                    "AND fbpomcode.code = '" + test_CODE_OKVED + "'";

            Statement statement = connection.createStatement();

            // Get Tax data for type 1 from the database
            ResultSet rs_okved_1 = statement.executeQuery(selectTableSQLForType_1_okved);

            // if something was received then the while loop will work
            while (rs_okved_1.next()) {
                codeOKVED_type_1 = rs_okved_1.getString("CODE");
                beginDateOKVED_type_1 = DateReplace.replaceInputDate(rs_okved_1.getString("BEGINDATE"));
                endDateOKVED_type_1 = DateReplace.replaceInputDate(rs_okved_1.getString("ENDDATE"));
                isPrimaryOKVED_type_1 = DataConversion.testSF_booleanConversion(rs_okved_1.getString("ISPRIMARY"));
            }

            String selectPicklistOKVED = "SELECT OKVED_NAME " +
            "FROM fb_okved " +
            "WHERE OKVED = '" + codeOKVED_type_1 + "' " +
            "ORDER BY MODIFYDATE " +
            "DESC " +
            "FETCH NEXT 1 ROWS ONLY";

            ResultSet rs_1_OKVED = statement.executeQuery(selectPicklistOKVED);
            while (rs_1_OKVED.next()) {
                nameOKVED_type_1 = rs_1_OKVED.getString("OKVED_NAME");
            }


            // Get Tax data for type 2 from the database
            ResultSet rs_okved_2 = statement.executeQuery(selectTableSQLForType_2_okved);

            // if something was received then the while loop will work
            while (rs_okved_2.next()) {
                codeOKVED_type_2 = rs_okved_2.getString("CODE");
                beginDateOKVED_type_2 = DateReplace.replaceInputDate(rs_okved_2.getString("BEGINDATE"));
                endDateOKVED_type_2 = DateReplace.replaceInputDate(rs_okved_2.getString("ENDDATE"));
                isPrimaryOKVED_type_2 = DataConversion.testSF_booleanConversion(rs_okved_2.getString("ISPRIMARY"));
            }

            String selectPicklistOKVED_2 = "SELECT OKVED_NAME " +
                    "FROM fb_okved " +
                    "WHERE OKVED = '" + codeOKVED_type_2 + "' " +
                    "ORDER BY MODIFYDATE " +
                    "DESC " +
                    "FETCH NEXT 1 ROWS ONLY";

            ResultSet rs_2_OKVED = statement.executeQuery(selectPicklistOKVED_2);
            while (rs_2_OKVED.next()) {
                nameOKVED_type_2 = rs_2_OKVED.getString("OKVED_NAME");
            }


            // Get Tax data for type 3 from the database
            ResultSet rs_okved_3 = statement.executeQuery(selectTableSQLForType_3_okved);

            // if something was received then the while loop will work
            while (rs_okved_3.next()) {
                codeOKVED_type_3 = rs_okved_3.getString("CODE");
                beginDateOKVED_type_3 = DateReplace.replaceInputDate(rs_okved_3.getString("BEGINDATE"));
                endDateOKVED_type_3 = DateReplace.replaceInputDate(rs_okved_3.getString("ENDDATE"));
                isPrimaryOKVED_type_3 = DataConversion.testSF_booleanConversion(rs_okved_3.getString("ISPRIMARY"));
            }

            String selectPicklistOKVED_3 = "SELECT OKVED_NAME " +
                    "FROM fb_okved " +
                    "WHERE OKVED = '" + codeOKVED_type_3 + "' " +
                    "ORDER BY MODIFYDATE " +
                    "DESC " +
                    "FETCH NEXT 1 ROWS ONLY";

            ResultSet rs_3_OKVED = statement.executeQuery(selectPicklistOKVED_3);
            while (rs_3_OKVED.next()) {
                nameOKVED_type_3 = rs_3_OKVED.getString("OKVED_NAME");
            }

            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        if(Objects.equals(test_CODE_OKVED, DataComparison.compareData(codeOKVED_type_1, codeOKVED_type_2, codeOKVED_type_3))) {
            System.out.println("CODE_OKVED test passed!");
        }else {
            System.out.println("CODE_OKVED test failed! - X");
        }

        if(Objects.equals(test_CODENAME_OKVED, DataComparison.compareData(nameOKVED_type_1, nameOKVED_type_2, nameOKVED_type_3))) {
            System.out.println("CODENAME_OKVED test passed!");
        }else {
            System.out.println("CODENAME_OKVED test failed! - X");
        }

        if(Objects.equals(test_BEGINDATE_OKVED, DataComparison.compareData(beginDateOKVED_type_1, beginDateOKVED_type_2, beginDateOKVED_type_3))) {
            System.out.println("BEGINDATE_OKVED test passed!");
        }else {
            System.out.println("BEGINDATE_OKVED test failed! - X");
        }

        if(Objects.equals(test_ENDDATE_OKVED, DataComparison.compareData(endDateOKVED_type_1, endDateOKVED_type_2, endDateOKVED_type_3))) {
            System.out.println("ENDDATE_OKVED test passed!");
        }else {
            System.out.println("ENDDATE_OKVED test failed! - X");
        }

        if(Objects.equals(test_ISPRIMARY_OKVED, DataComparison.compareData(isPrimaryOKVED_type_1, isPrimaryOKVED_type_2, isPrimaryOKVED_type_3))) {
            System.out.println("ISPRIMARY_OKVED test passed!");
        }else {
            System.out.println("ISPRIMARY_OKVED test failed! - X");
        }

        System.out.println("----------------------------");
    }
}
