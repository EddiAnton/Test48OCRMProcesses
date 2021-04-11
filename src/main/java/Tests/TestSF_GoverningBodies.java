package Tests;

import Services.DataComparison;
import Services.DataConversion;
import Services.Rerty;
import Services.TestEnvironment;
import Services.XpathAuthorization;
import Services.XpathGoverningBodies;

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

public class TestSF_GoverningBodies {

    String requestMask = "UC-TSP";
    String productOrderNumber = null;

    String test_MANAGE_PERSON = null;
    String test_MANAGE_STRUCTURE = null;

    String managePerson_type_1 = null;
    String manageStructure_type_1 = null;

    String managePerson_type_2 = null;
    String manageStructure_type_2 = null;

    String managePerson_type_3 = null;
    String manageStructure_type_3 = null;

    @Parameters({"contour"})
    @Test
    public void testGoverningBodies(String contour) {

        TestEnvironment testEnvironment = new TestEnvironment(contour);

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            driver.get(testEnvironment.getUrl());
            driver.manage().window().maximize();

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

            // Select the Governing Bodies tab
            WebElement governingBodiesTab = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathGoverningBodies.GOVERNING_BODIES_TAB)));
            governingBodiesTab.click();

            // Get data of the Governing Bodies type
            WebElement field_MANAGE_PERSON;
            if (contour.equals("8083")) {
                field_MANAGE_PERSON = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathGoverningBodies.FIELD_MANAGE_PERSON_8083)));
            } else {
                field_MANAGE_PERSON = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathGoverningBodies.FIELD_MANAGE_PERSON_8092)));
            }
            test_MANAGE_PERSON = field_MANAGE_PERSON.getAttribute("value");

            WebElement field_MANAGE_STRUCTURE;
            if (contour.equals("8083")) {
                field_MANAGE_STRUCTURE = driver.findElement(By
                        .xpath(XpathGoverningBodies.FIELD_MANAGE_STRUCTURE_8083));
            } else {
                field_MANAGE_STRUCTURE = driver.findElement(By
                        .xpath(XpathGoverningBodies.FIELD_MANAGE_STRUCTURE_8092));
            }
            test_MANAGE_STRUCTURE = field_MANAGE_STRUCTURE.getAttribute("value");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

        System.out.println(productOrderNumber);
        System.out.println("---------------");
        System.out.println(test_MANAGE_PERSON);
        System.out.println(test_MANAGE_STRUCTURE);
        System.out.println("---------------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");

            String selectTableSQLForType_1 = "SELECT fbpomd.MANAGE_PERSON, fbpomd.MANAGE_STRUCTURE " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '1'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomd.MEMBERCLASS IS NULL";

            String selectTableSQLForType_2 = "SELECT fbpomd.MANAGE_PERSON, fbpomd.MANAGE_STRUCTURE " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '2'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomd.MEMBERCLASS IS NULL";

            String selectTableSQLForType_3 = "SELECT fbpomd.MANAGE_PERSON, fbpomd.MANAGE_STRUCTURE " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '3'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomd.MEMBERCLASS IS NULL";

            Statement statement = connection.createStatement();

            // Get data for type 1 from the database
            ResultSet rs_1 = statement.executeQuery(selectTableSQLForType_1);

            // if something was received then the while loop will work
            while (rs_1.next()) {
                managePerson_type_1 = rs_1.getString("MANAGE_PERSON");
                manageStructure_type_1 = rs_1.getString("MANAGE_STRUCTURE");
            }

            // Get data for type 2 from the database
            ResultSet rs_2 = statement.executeQuery(selectTableSQLForType_2);

            // if something was received then the while loop will work
            while (rs_2.next()) {
                managePerson_type_2 = rs_2.getString("MANAGE_PERSON");
                manageStructure_type_2 = rs_2.getString("MANAGE_STRUCTURE");
            }

            // Get data for type 3 from the database
            ResultSet rs_3 = statement.executeQuery(selectTableSQLForType_3);

            // if something was received then the while loop will work
            while (rs_3.next()) {
                managePerson_type_3 = rs_3.getString("MANAGE_PERSON");
                manageStructure_type_3 = rs_3.getString("MANAGE_STRUCTURE");
            }

            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        if(Objects.equals(test_MANAGE_PERSON, DataComparison.compareData(managePerson_type_1, managePerson_type_2, managePerson_type_3))) {
            System.out.println("MANAGE_PERSON test passed!");
        } else {
            System.out.println("MANAGE_PERSON test failed! - X");
        }

        if(Objects.equals(test_MANAGE_STRUCTURE, DataComparison.compareData(manageStructure_type_1, manageStructure_type_2, manageStructure_type_3))) {
            System.out.println("MANAGE_STRUCTURE test passed!");
        } else {
            System.out.println("MANAGE_STRUCTURE test failed! - X");
        }
    }
}
