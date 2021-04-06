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

public class TestSF_OtherChangesInDoc {

    String contour = "8083";

    String requestMask = "UC-TSP";
    String productOrderNumber = null;

    String test_OKFS = null;
    String test_COMPANYTYPE = null;
    String test_OKOPF = null;
    String test_CAPITALANNOUNCEDSUM = null;
    String test_CAPITALCURRENCY = null;

    int codeOkfs_type_1 = 0;
    String okfs_type_1 = null;
    String codeCompanyType_type_1 = null;
    String companyType_type_1 = null;
    int codeOkopf_type_1 = 0;
    String okopf_type_1 = null;
    String capitalAnnouncedSum_type_1 = null;
    String capitalCurrency_type_1 = null;

    int codeOkfs_type_2 = 0;
    String okfs_type_2 = null;
    String codeCompanyType_type_2 = null;
    String companyType_type_2 = null;
    int codeOkopf_type_2 = 0;
    String okopf_type_2 = null;
    String capitalAnnouncedSum_type_2 = null;
    String capitalCurrency_type_2 = null;

    int codeOkfs_type_3 = 0;
    String okfs_type_3 = null;
    String codeCompanyType_type_3 = null;
    String companyType_type_3 = null;
    int codeOkopf_type_3 = 0;
    String okopf_type_3 = null;
    String capitalAnnouncedSum_type_3 = null;
    String capitalCurrency_type_3 = null;

    @Test(retryAnalyzer = Rerty.class)
    public void testOtherChangesInDoc() {

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

            Thread.sleep(5000);

            // Authorization in system
            WebElement inputUserName = driver.findElement(By.xpath(XpathAuthorization.INPUT_USERNAME));
            inputUserName.sendKeys(testEnvironment.getUserName());

            WebElement inputPassword = driver.findElement(By.xpath(XpathAuthorization.INPUT_PASSWORD));
            inputPassword.sendKeys(testEnvironment.getPassword());

            WebElement submitButton = driver.findElement(By.xpath(XpathAuthorization.SUBMIT_BUTTON));
            submitButton.click();

            Thread.sleep(3000);

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

            // Select the Other Changes in Doc tab
            WebElement otherChangesInDocTab = driver.findElement(By
                    .xpath(XpathOtherChangesInDoc.OTHER_CHANGES_IN_DOC_TAB));
            otherChangesInDocTab.click();
            Thread.sleep(2000);

            // Get data of the Other changes type
            WebElement field_OKFS = driver.findElement(By.xpath(XpathOtherChangesInDoc.FIELD_OKFS));
            test_OKFS = field_OKFS.getAttribute("value");

            WebElement field_COMPANYTYPE = driver.findElement(By.xpath(XpathOtherChangesInDoc.FIELD_COMPANYTYPE));
            test_COMPANYTYPE = field_COMPANYTYPE.getAttribute("value");

            WebElement field_OKOPF = driver.findElement(By.xpath(XpathOtherChangesInDoc.FIELD_OKOPF));
            test_OKOPF = field_OKOPF.getAttribute("value");

            WebElement field_CAPITALANNOUNCEDSUM = driver.findElement(By
                    .xpath(XpathOtherChangesInDoc.FIELD_CAPITALANNOUNCEDSUM));
            test_CAPITALANNOUNCEDSUM = field_CAPITALANNOUNCEDSUM.getAttribute("value");

            WebElement field_CAPITALCURRENCY = driver.findElement(By
                    .xpath(XpathOtherChangesInDoc.FIELD_CAPITALCURRENCY));
            test_CAPITALCURRENCY = field_CAPITALCURRENCY.getAttribute("value");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

        System.out.println(productOrderNumber);
        System.out.println("----------------");
        System.out.println(test_OKFS);
        System.out.println(test_COMPANYTYPE);
        System.out.println(test_OKOPF);
        System.out.println(test_CAPITALANNOUNCEDSUM);
        System.out.println(test_CAPITALCURRENCY);
        System.out.println("----------------");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");

            String selectTableSQLForType_1 = "SELECT fbpomd.OKFS, " +
                    "fbpomd.COMPANYTYPE, " +
                    "fbpomd.OKOPF, " +
                    "fbpomd.CAPITALANNOUNCEDSUM, " +
                    "fbpomd.CAPITALCURRENCY " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '1'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomd.MEMBERCLASS IS NULL";

            String selectTableSQLForType_2 = "SELECT fbpomd.OKFS, " +
                    "fbpomd.COMPANYTYPE, " +
                    "fbpomd.OKOPF, " +
                    "fbpomd.CAPITALANNOUNCEDSUM, " +
                    "fbpomd.CAPITALCURRENCY " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '2'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomd.MEMBERCLASS IS NULL";

            String selectTableSQLForType_3 = "SELECT fbpomd.OKFS, " +
                    "fbpomd.COMPANYTYPE, " +
                    "fbpomd.OKOPF, " +
                    "fbpomd.CAPITALANNOUNCEDSUM, " +
                    "fbpomd.CAPITALCURRENCY " +
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
                codeOkfs_type_1 = rs_1.getInt("OKFS");
                codeCompanyType_type_1 = rs_1.getString("COMPANYTYPE");
                codeOkopf_type_1 = rs_1.getInt("OKOPF");
                capitalAnnouncedSum_type_1 = rs_1.getString("CAPITALANNOUNCEDSUM");
                capitalCurrency_type_1 = rs_1.getString("CAPITALCURRENCY");
            }

            String selectPicklistOKFS_1 = "select shortname " +
                    "from fb_okfs " +
                    "where code = " + codeOkfs_type_1;

            ResultSet rs_1_okfs = statement.executeQuery(selectPicklistOKFS_1);
            while (rs_1_okfs.next()) {
                okfs_type_1 = rs_1_okfs.getString("SHORTNAME");
            }

            String selectPicklistCompanyType_1 = "select pl.text " +
                    "from picklist pl " +
                    "where pl.picklistid = 'k6UJ9A000FPX' " +
                    "AND pl.shorttext = '" + codeCompanyType_type_1 + "'";

            ResultSet rs_1_companyType = statement.executeQuery(selectPicklistCompanyType_1);
            while (rs_1_companyType.next()) {
                companyType_type_1 = rs_1_companyType.getString("TEXT");
            }

            String selectPicklistOKOPF_1 = "select fullname " +
                    "from fb_okopf " +
                    "where code = " + codeOkopf_type_1;

            ResultSet rs_1_okopf = statement.executeQuery(selectPicklistOKOPF_1);
            while (rs_1_okopf.next()) {
                okopf_type_1 = rs_1_okopf.getString("FULLNAME");
            }

            // Get data for type 2 from the database
            ResultSet rs_2 = statement.executeQuery(selectTableSQLForType_2);

            // if something was received then the while loop will work
            while (rs_2.next()) {
                codeOkfs_type_2 = rs_2.getInt("OKFS");
                codeCompanyType_type_2 = rs_2.getString("COMPANYTYPE");
                codeOkopf_type_2 = rs_2.getInt("OKOPF");
                capitalAnnouncedSum_type_2 = rs_2.getString("CAPITALANNOUNCEDSUM");
                capitalCurrency_type_2 = rs_2.getString("CAPITALCURRENCY");
            }

            String selectPicklistOKFS_2 = "select shortname " +
                    "from fb_okfs " +
                    "where code = " + codeOkfs_type_2;

            ResultSet rs_2_okfs = statement.executeQuery(selectPicklistOKFS_2);
            while (rs_2_okfs.next()) {
                okfs_type_2 = rs_2_okfs.getString("SHORTNAME");
            }

            String selectPicklistCompanyType_2 = "select pl.text " +
                    "from picklist pl " +
                    "where pl.picklistid = 'k6UJ9A000FPX' " +
                    "AND pl.shorttext = '" + codeCompanyType_type_2 + "'";

            ResultSet rs_2_companyType = statement.executeQuery(selectPicklistCompanyType_2);
            while (rs_2_companyType.next()) {
                companyType_type_2 = rs_2_companyType.getString("TEXT");
            }

            String selectPicklistOKOPF_2 = "select fullname " +
                    "from fb_okopf " +
                    "where code = " + codeOkopf_type_2;

            ResultSet rs_2_okopf = statement.executeQuery(selectPicklistOKOPF_2);
            while (rs_2_okopf.next()) {
                okopf_type_2 = rs_2_okopf.getString("FULLNAME");
            }

            // Get data for type 3 from the database
            ResultSet rs_3 = statement.executeQuery(selectTableSQLForType_3);

            // if something was received then the while loop will work
            while (rs_3.next()) {
                codeOkfs_type_3 = rs_3.getInt("OKFS");
                codeCompanyType_type_3 = rs_3.getString("COMPANYTYPE");
                codeOkopf_type_3 = rs_3.getInt("OKOPF");
                capitalAnnouncedSum_type_3 = rs_3.getString("CAPITALANNOUNCEDSUM");
                capitalCurrency_type_3 = rs_3.getString("CAPITALCURRENCY");
            }

            String selectPicklistOKFS_3 = "select shortname " +
                    "from fb_okfs " +
                    "where code = " + codeOkfs_type_3;

            ResultSet rs_3_okfs = statement.executeQuery(selectPicklistOKFS_3);
            while (rs_3_okfs.next()) {
                okfs_type_3 = rs_3_okfs.getString("SHORTNAME");
            }

            String selectPicklistCompanyType_3 = "select pl.text " +
                    "from picklist pl " +
                    "where pl.picklistid = 'k6UJ9A000FPX' " +
                    "AND pl.shorttext = '" + codeCompanyType_type_3 + "'";

            ResultSet rs_3_companyType = statement.executeQuery(selectPicklistCompanyType_3);
            while (rs_3_companyType.next()) {
                companyType_type_3 = rs_3_companyType.getString("TEXT");
            }

            String selectPicklistOKOPF_3 = "select fullname " +
                    "from fb_okopf " +
                    "where code = " + codeOkopf_type_3;

            ResultSet rs_3_okopf = statement.executeQuery(selectPicklistOKOPF_3);
            while (rs_3_okopf.next()) {
                okopf_type_3 = rs_3_okopf.getString("FULLNAME");
            }

            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        if(Objects.equals(test_OKFS, DataComparison.compareData(okfs_type_1, okfs_type_2, okfs_type_3))) {
            System.out.println("OKFS test passed!");
        }else {
            System.out.println("OKFS test failed! - X");
        }

        if(Objects.equals(test_COMPANYTYPE, DataComparison.compareData(companyType_type_1, companyType_type_2, companyType_type_3))) {
            System.out.println("COMPANYTYPE test passed!");
        }else {
            System.out.println("COMPANYTYPE test failed! - X");
        }

        if(Objects.equals(test_OKOPF, DataComparison.compareData(okopf_type_1, okopf_type_2, okopf_type_3))) {
            System.out.println("OKOPF test passed!");
        }else {
            System.out.println("OKOPF test failed! - X");
        }

        if(Objects.equals(test_CAPITALANNOUNCEDSUM, DataComparison.compareData(capitalAnnouncedSum_type_1, capitalAnnouncedSum_type_2, capitalAnnouncedSum_type_3))) {
            System.out.println("CAPITALANNOUNCEDSUM test passed!");
        }else {
            System.out.println("CAPITALANNOUNCEDSUM test failed! - X");
        }

        if(Objects.equals(test_CAPITALCURRENCY, DataComparison.compareData(capitalCurrency_type_1, capitalCurrency_type_2, capitalCurrency_type_3))) {
            System.out.println("CAPITALCURRENCY test passed!");
        }else {
            System.out.println("CAPITALCURRENCY test failed! - X");
        }

        System.out.println("----------------------------");

    }
}
