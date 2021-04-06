package Tests_8083;

import Services.DataComparison;
import Services.DataConversion;
import Services.DateReplace;
import Services.Rerty;
import Services.TestEnvironment;
import Services.XpathAuthorization;
import Services.XpathLicense;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

@Parameters({"contour"})
@Test
public class TestSF_License {

    String contour;
    String requestMask = "UC-TSP";
    String productOrderNumber = null;

    String test_LICENSENUMBER = null;
    String test_ACTIVITYKIND = null;
    String test_ISSUEDBY = null;
    String test_ISSUEDATE = null;
    String test_EXPIRYDATE = null;
    String test_ACTIVITYKINDLIST = null;

    String licenseNumber_type_1 = null;
    String activityKind_type_1 = null;
    String issuedBy_type_1 = null;
    String issueDate_type_1 = null;
    String expiryDate_type_1 = null;
    String activityKindList_type_1 = null;

    String licenseNumber_type_2 = null;
    String activityKind_type_2 = null;
    String issuedBy_type_2 = null;
    String issueDate_type_2 = null;
    String expiryDate_type_2 = null;
    String activityKindList_type_2 = null;

    String licenseNumber_type_3 = null;
    String activityKind_type_3 = null;
    String issuedBy_type_3 = null;
    String issueDate_type_3 = null;
    String expiryDate_type_3 = null;
    String activityKindList_type_3 = null;

    @Test(retryAnalyzer = Rerty.class)
    public void testLicense() {

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

            // Select the License tab
            WebElement licenseTab = driver.findElement(By.xpath(XpathLicense.LICENSE_TAB));
            licenseTab.click();
            Thread.sleep(2000);

            // Disclose data on the License - " V "
            WebElement openLicense = driver.findElement(By.xpath(XpathLicense.OPEN_LICENSE));
            openLicense.click();
            Thread.sleep(3000);

            // Get data of the License type
            WebElement field_LICENSENUMBER = driver.findElement(By.xpath(XpathLicense.FIELD_LICENSENUMBER));
            test_LICENSENUMBER = field_LICENSENUMBER.getAttribute("value");

            WebElement field_ACTIVITYKIND = driver.findElement(By.xpath(XpathLicense.FIELD_ACTIVITYKIND));
            test_ACTIVITYKIND = field_ACTIVITYKIND.getAttribute("value");

            WebElement field_ISSUEDBY = driver.findElement(By.xpath(XpathLicense.FIELD_ISSUEDBY));
            test_ISSUEDBY = field_ISSUEDBY.getAttribute("value");

            WebElement field_ISSUEDATE = driver.findElement(By.xpath(XpathLicense.FIELD_ISSUEDATE));
            test_ISSUEDATE = field_ISSUEDATE.getAttribute("value");

            WebElement field_EXPIRYDATE = driver.findElement(By.xpath(XpathLicense.FIELD_EXPIRYDATE));
            test_EXPIRYDATE = field_EXPIRYDATE.getAttribute("value");

            WebElement field_ACTIVITYKINDLIST = driver.findElement(By.xpath(XpathLicense.FIELD_ACTIVITYKINDLIST));
            test_ACTIVITYKINDLIST = field_ACTIVITYKINDLIST.getAttribute("value");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

        System.out.println(productOrderNumber);
        System.out.println("---------------");
        System.out.println(test_LICENSENUMBER);
        System.out.println(test_ACTIVITYKIND);
        System.out.println(test_ISSUEDBY);
        System.out.println(test_ISSUEDATE);
        System.out.println(test_EXPIRYDATE);
        System.out.println(test_ACTIVITYKINDLIST);
        System.out.println("---------------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");

            String selectTableSQLForType_1 = "SELECT fbpol.LICENSENUMBER, " +
                    "fbpol.ACTIVITYKIND, " +
                    "fbpol.ISSUEDBY, " +
                    "fbpol.ISSUEDATE, " +
                    "fbpol.EXPIRYDATE, " +
                    "fbpol.ACTIVITYKINDLIST " +
                    "FROM SYSDBA.FB_PRODUCTORDERLICENSE fbpol " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpol.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '1'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomd.MEMBERCLASS IS NULL";

            String selectTableSQLForType_2 = "SELECT fbpol.LICENSENUMBER, " +
                    "fbpol.ACTIVITYKIND, " +
                    "fbpol.ISSUEDBY, " +
                    "fbpol.ISSUEDATE, " +
                    "fbpol.EXPIRYDATE, " +
                    "fbpol.ACTIVITYKINDLIST " +
                    "FROM SYSDBA.FB_PRODUCTORDERLICENSE fbpol " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpol.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '2'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomd.MEMBERCLASS IS NULL";

            String selectTableSQLForType_3 = "SELECT fbpol.LICENSENUMBER, " +
                    "fbpol.ACTIVITYKIND, " +
                    "fbpol.ISSUEDBY, " +
                    "fbpol.ISSUEDATE, " +
                    "fbpol.EXPIRYDATE, " +
                    "fbpol.ACTIVITYKINDLIST " +
                    "FROM SYSDBA.FB_PRODUCTORDERLICENSE fbpol " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpol.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
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
                licenseNumber_type_1 = rs_1.getString("LICENSENUMBER");
                activityKind_type_1 = rs_1.getString("ACTIVITYKIND");
                issuedBy_type_1 = rs_1.getString("ISSUEDBY");
                issueDate_type_1 = DateReplace.replaceInputDate(rs_1.getString("ISSUEDATE"));
                expiryDate_type_1 = DateReplace.replaceInputDate(rs_1.getString("EXPIRYDATE"));
                activityKindList_type_1 = rs_1.getString("ACTIVITYKINDLIST");
            }

            // Get data for type 2 from the database
            ResultSet rs_2 = statement.executeQuery(selectTableSQLForType_2);

            // if something was received then the while loop will work
            while (rs_2.next()) {
                licenseNumber_type_2 = rs_2.getString("LICENSENUMBER");
                activityKind_type_2 = rs_2.getString("ACTIVITYKIND");
                issuedBy_type_2 = rs_2.getString("ISSUEDBY");
                issueDate_type_2 = DateReplace.replaceInputDate(rs_2.getString("ISSUEDATE"));
                expiryDate_type_2 = DateReplace.replaceInputDate(rs_2.getString("EXPIRYDATE"));
                activityKindList_type_2 = rs_2.getString("ACTIVITYKINDLIST");
            }

            // Get data for type 3 from the database
            ResultSet rs_3 = statement.executeQuery(selectTableSQLForType_3);

            // if something was received then the while loop will work
            while (rs_3.next()) {
                licenseNumber_type_3 = rs_3.getString("LICENSENUMBER");
                activityKind_type_3 = rs_3.getString("ACTIVITYKIND");
                issuedBy_type_3 = rs_3.getString("ISSUEDBY");
                issueDate_type_3 = DateReplace.replaceInputDate(rs_3.getString("ISSUEDATE"));
                expiryDate_type_3 = DateReplace.replaceInputDate(rs_3.getString("EXPIRYDATE"));
                activityKindList_type_3 = rs_3.getString("ACTIVITYKINDLIST");
            }

            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        if(Objects.equals(test_LICENSENUMBER, DataComparison.compareData(licenseNumber_type_1, licenseNumber_type_2, licenseNumber_type_3))) {
            System.out.println("LICENSENUMBER test passed!");
        }else {
            System.out.println("LICENSENUMBER test failed! - X");
        }

        if(Objects.equals(test_ACTIVITYKIND, DataComparison.compareData(activityKind_type_1, activityKind_type_2, activityKind_type_3))) {
            System.out.println("ACTIVITYKIND test passed!");
        }else {
            System.out.println("ACTIVITYKIND test failed! - X");
        }

        if(Objects.equals(test_ISSUEDBY, DataComparison.compareData(issuedBy_type_1, issuedBy_type_2, issuedBy_type_3))) {
            System.out.println("ISSUEDBY test passed!");
        }else {
            System.out.println("ISSUEDBY test failed! - X");
        }

        if(Objects.equals(test_ISSUEDATE, DataComparison.compareData(issueDate_type_1, issueDate_type_2, issueDate_type_3))) {
            System.out.println("ISSUEDATE test passed!");
        }else {
            System.out.println("ISSUEDATE test failed! - X");
        }

        if(Objects.equals(test_EXPIRYDATE, DataComparison.compareData(expiryDate_type_1, expiryDate_type_2, expiryDate_type_3))) {
            System.out.println("EXPIRYDATE test passed!");
        }else {
            System.out.println("EXPIRYDATE test failed! - X");
        }

        if(Objects.equals(test_ACTIVITYKINDLIST, DataComparison.compareData(activityKindList_type_1, activityKindList_type_2, activityKindList_type_3))) {
            System.out.println("ACTIVITYKINDLIST test passed!");
        }else {
            System.out.println("ACTIVITYKINDLIST test failed! - X");
        }

        System.out.println("----------------------------");

    }
}
