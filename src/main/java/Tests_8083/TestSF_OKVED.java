package Tests_8083;

import Services.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class TestSF_OKVED {

    String contour = "8083";

    String requestMask = "UC-TSP";
    String productOrderNumber = null;

    String test_CODE_OKVED = null;
    String test_CODENAME_OKVED = null;
    String test_BEGINDATE_OKVED = null;
    String test_ENDDATE_OKVED = null;
    String test_ISPRIMARY_OKVED = null;

    String codeOKVED_type_1 = null;
    String codeNameOKVED_type_1 = null;
    String beginDateOKVED_type_1 = null;
    String endDateOKVED_type_1 = null;
    String isPrimaryOKVED_type_1 = null;

    String codeOKVED_type_2 = null;
    String codeNameOKVED_type_2 = null;
    String beginDateOKVED_type_2 = null;
    String endDateOKVED_type_2 = null;
    String isPrimaryOKVED_type_2 = null;

    String codeOKVED_type_3 = null;
    String codeNameOKVED_type_3 = null;
    String beginDateOKVED_type_3 = null;
    String endDateOKVED_type_3 = null;
    String isPrimaryOKVED_type_3 = null;


    @Test(retryAnalyzer = Rerty.class)
    public void testOKVED() {

        TestEnvironment testEnvironment = new TestEnvironment(contour);

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            driver.get(testEnvironment.getUrl());
            driver.manage().window().maximize();
            Thread.sleep(2000);

            WebElement logoffHref = driver.findElement(By.linkText(XpathAuthorization.LOG_OFF_HREF));
            logoffHref.click();

            Thread.sleep(2000);

            // Authorization in system
            WebElement inputUserName = driver.findElement(By.xpath(XpathAuthorization.INPUT_USERNAME));
            inputUserName.sendKeys(testEnvironment.getUserName());

            WebElement inputPassword = driver.findElement(By.xpath(XpathAuthorization.INPUT_PASSWORD));
            inputPassword.sendKeys(testEnvironment.getPassword());

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

            // Select the OKVED tab
            WebElement OKVEDTab = driver.findElement(By.xpath(XpathOKVED.OKVED_TAB));
            OKVEDTab.click();
            Thread.sleep(2000);

            // Disclose data on the OKVED - " V "
            WebElement openOKVED = driver.findElement(By.xpath(XpathOKVED.OPEN_OKVED));
            openOKVED.click();
            Thread.sleep(3000);

            // Get data of the OKVED type
            WebElement field_CODE_OKVED = driver.findElement(By.xpath(XpathOKVED.FIELD_CODE_OKVED));
            test_CODE_OKVED = field_CODE_OKVED.getAttribute("value");

            WebElement field_CODENAME_OKVED = driver.findElement(By.xpath(XpathOKVED.FIELD_CODENAME_OKVED));
            test_CODENAME_OKVED = field_CODENAME_OKVED.getAttribute("value");

            WebElement field_BEGINDATE_OKVED = driver.findElement(By.xpath(XpathOKVED.FIELD_BEGINDATE_OKVED));
            test_BEGINDATE_OKVED = field_BEGINDATE_OKVED.getAttribute("value");

            WebElement field_ENDDATE_OKVED = driver.findElement(By.xpath(XpathOKVED.FIELD_ENDDATE_OKVED));
            test_ENDDATE_OKVED = field_ENDDATE_OKVED.getAttribute("value");

            WebElement field_ISPRIMARY_OKVED = driver.findElement(By.xpath(XpathOKVED.FIELD_ISPRIMARY_OKVED));
            test_ISPRIMARY_OKVED = field_ISPRIMARY_OKVED.getAttribute("value");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
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
                codeNameOKVED_type_1 = rs_okved_1.getString("CODENAME");
                beginDateOKVED_type_1 = DateReplace.replaceInputDate(rs_okved_1.getString("BEGINDATE"));
                endDateOKVED_type_1 = DateReplace.replaceInputDate(rs_okved_1.getString("ENDDATE"));
                isPrimaryOKVED_type_1 = DataConversion.testSF_booleanConversion(rs_okved_1.getString("ISPRIMARY"));
            }

            // Get Tax data for type 2 from the database
            ResultSet rs_okved_2 = statement.executeQuery(selectTableSQLForType_2_okved);

            // if something was received then the while loop will work
            while (rs_okved_2.next()) {
                codeOKVED_type_2 = rs_okved_2.getString("CODE");
                codeNameOKVED_type_2 = rs_okved_2.getString("CODENAME");
                beginDateOKVED_type_2 = DateReplace.replaceInputDate(rs_okved_2.getString("BEGINDATE"));
                endDateOKVED_type_2 = DateReplace.replaceInputDate(rs_okved_2.getString("ENDDATE"));
                isPrimaryOKVED_type_2 = DataConversion.testSF_booleanConversion(rs_okved_2.getString("ISPRIMARY"));
            }

            // Get Tax data for type 3 from the database
            ResultSet rs_okved_3 = statement.executeQuery(selectTableSQLForType_3_okved);

            // if something was received then the while loop will work
            while (rs_okved_3.next()) {
                codeOKVED_type_3 = rs_okved_3.getString("CODE");
                codeNameOKVED_type_3 = rs_okved_3.getString("CODENAME");
                beginDateOKVED_type_3 = DateReplace.replaceInputDate(rs_okved_3.getString("BEGINDATE"));
                endDateOKVED_type_3 = DateReplace.replaceInputDate(rs_okved_3.getString("ENDDATE"));
                isPrimaryOKVED_type_3 = DataConversion.testSF_booleanConversion(rs_okved_3.getString("ISPRIMARY"));
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

        if(Objects.equals(test_CODENAME_OKVED, DataComparison.compareData(codeNameOKVED_type_1, codeNameOKVED_type_2, codeNameOKVED_type_3))) {
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
