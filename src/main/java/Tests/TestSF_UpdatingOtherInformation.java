package Tests;

import Services.DataComparison;
import Services.DataConversion;
import Services.TestEnvironment;
import Services.XpathAuthorization;
import Services.XpathUpdatingOtherInformation;

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

public class TestSF_UpdatingOtherInformation {

    String requestMask = "UC-TSP";
    String productOrderNumber = null;

    String test_ISREGOFFSHORZONE = null;
    String test_OKPO = null;
    String test_OKOGU = null;
    String test_SWIFT = null;
    String test_EIN = null;
    String test_GIIN = null;
    String test_FATCADOCW9 = null;
    String test_FATCADOC = null;
    String test_DISREGARDED = null;
    String test_FATCASTATUS = null;
    String test_CRS_NALOG_RESIDENCE = null;
    String test_CRS_IINN_TYPE = null;
    String test_CRS_IINN = null;
    String test_CRS_NO_IINN_CODE = null;
    String test_CRS_NO_IINN_REASON = null;
    String test_CRS_DATE_BEGIN = null;
    String test_CRS_DATE_END = null;
    String test_CRS_STATUS = null;

    String isRegOffshorZone_type_1 = null;
    String okpo_type_1 = null;
    String okogu_type_1 = null;
    String swift_type_1 = null;
    String ein_type_1 = null;
    String giin_type_1 = null;
    String fatcaDocW9_type_1 = null;
    String fatcaDoc_type_1 = null;
    String disregarded_type_1 = null;
    String fatcaStatus_type_1 = null;
    String crsNalogResidence_type_1 = null;
    String crsIINNType_type_1 = null;
    String crsIINN_type_1 = null;
    String crsNoIINNCode_type_1 = null;
    String crsNoIINNReason_type_1 = null;
    String crsDateBegin_type_1 = null;
    String crsDateEnd_type_1 = null;
    String crsStatus_type_1 = null;

    String isRegOffshorZone_type_2 = null;
    String okpo_type_2 = null;
    String okogu_type_2 = null;
    String swift_type_2 = null;
    String ein_type_2 = null;
    String giin_type_2 = null;
    String fatcaDocW9_type_2 = null;
    String fatcaDoc_type_2 = null;
    String disregarded_type_2 = null;
    String fatcaStatus_type_2 = null;
    String crsNalogResidence_type_2 = null;
    String crsIINNType_type_2 = null;
    String crsIINN_type_2 = null;
    String crsNoIINNCode_type_2 = null;
    String crsNoIINNReason_type_2 = null;
    String crsDateBegin_type_2 = null;
    String crsDateEnd_type_2 = null;
    String crsStatus_type_2 = null;

    String isRegOffshorZone_type_3 = null;
    String okpo_type_3 = null;
    String okogu_type_3 = null;
    String swift_type_3 = null;
    String ein_type_3 = null;
    String giin_type_3 = null;
    String fatcaDocW9_type_3 = null;
    String fatcaDoc_type_3 = null;
    String disregarded_type_3 = null;
    String fatcaStatus_type_3 = null;
    String crsNalogResidence_type_3 = null;
    String crsIINNType_type_3 = null;
    String crsIINN_type_3 = null;
    String crsNoIINNCode_type_3 = null;
    String crsNoIINNReason_type_3 = null;
    String crsDateBegin_type_3 = null;
    String crsDateEnd_type_3 = null;
    String crsStatus_type_3 = null;

    @Parameters({"contour"})
    @Test
    public void testUpdatingOtherInformation(String contour) {

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

            // Select the Updating Other Information tab
            WebElement updatingOtherInformationTab = new WebDriverWait(driver, 15).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathUpdatingOtherInformation.UPDATING_OTHER_INFORMATION_TAB)));
            updatingOtherInformationTab.click();

            // Get data of the Other information
            WebElement field_ISREGOFFSHORZONE;
            if (contour.equals("8083")) {
                field_ISREGOFFSHORZONE = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathUpdatingOtherInformation.FIELD_ISREGOFFSHORZONE_8083)));
            } else {
                field_ISREGOFFSHORZONE = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathUpdatingOtherInformation.FIELD_ISREGOFFSHORZONE_8092)));
            }
            test_ISREGOFFSHORZONE = field_ISREGOFFSHORZONE.getAttribute("value");

            WebElement field_OKPO;
            if (contour.equals("8083")) {
                field_OKPO = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_OKPO_8083));
            } else {
                field_OKPO = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_OKPO_8092));
            }
            test_OKPO = field_OKPO.getAttribute("value");

            WebElement field_OKOGU;
            if (contour.equals("8083")) {
                field_OKOGU = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_OKOGU_8083));
            } else {
                field_OKOGU = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_OKOGU_8092));
            }
            test_OKOGU = field_OKOGU.getAttribute("value");

            WebElement field_SWIFT;
            if (contour.equals("8083")) {
                field_SWIFT = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_SWIFT_8083));
            } else {
                field_SWIFT = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_SWIFT_8092));
            }
            test_SWIFT = field_SWIFT.getAttribute("value");

            WebElement field_EIN;
            if (contour.equals("8083")) {
                field_EIN = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_EIN_8083));
            } else {
                field_EIN = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_EIN_8092));
            }
            test_EIN = field_EIN.getAttribute("value");

            WebElement field_GIIN;
            if (contour.equals("8083")) {
                field_GIIN = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_GIIN_8083));
            } else {
                field_GIIN = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_GIIN_8092));
            }
            test_GIIN = field_GIIN.getAttribute("value");

            WebElement field_FATCADOCW9;
            if (contour.equals("8083")) {
                field_FATCADOCW9 = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_FATCADOCW9_8083));
            } else {
                field_FATCADOCW9 = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_FATCADOCW9_8092));
            }
            test_FATCADOCW9 = field_FATCADOCW9.getAttribute("value");

            WebElement field_FATCADOC;
            if (contour.equals("8083")) {
                field_FATCADOC = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_FATCADOC_8083));
            } else {
                field_FATCADOC = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_FATCADOC_8092));
            }
            test_FATCADOC = field_FATCADOC.getAttribute("value");

            WebElement field_DISREGARDED;
            if (contour.equals("8083")) {
                field_DISREGARDED = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_DISREGARDED_8083));
            } else {
                field_DISREGARDED = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_DISREGARDED_8092));
            }
            test_DISREGARDED = field_DISREGARDED.getAttribute("value");

            WebElement field_FATCASTATUS;
            if (contour.equals("8083")) {
                field_FATCASTATUS = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_FATCASTATUS_8083));
            } else {
                field_FATCASTATUS = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_FATCASTATUS_8092));
            }
            test_FATCASTATUS = field_FATCASTATUS.getAttribute("value");

            // Disclose data on the CRS - " V "
            WebElement openCRS;
            if (contour.equals("8083")) {
                openCRS = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathUpdatingOtherInformation.OPEN_CRS_8083)));
            } else {
                openCRS = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathUpdatingOtherInformation.OPEN_CRS_8092)));
            }
            openCRS.click();

            // Get data of the CRS
            WebElement field_CRS_NALOG_RESIDENCE;
            if (contour.equals("8083")) {
                field_CRS_NALOG_RESIDENCE = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_NALOG_RESIDENCE_8083)));
            } else {
                field_CRS_NALOG_RESIDENCE = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_NALOG_RESIDENCE_8092)));
            }
            test_CRS_NALOG_RESIDENCE = field_CRS_NALOG_RESIDENCE.getAttribute("value");

            WebElement field_CRS_IINN_TYPE;
            if (contour.equals("8083")) {
                field_CRS_IINN_TYPE = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_IINN_TYPE_8083));
            } else {
                field_CRS_IINN_TYPE = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_IINN_TYPE_8092));
            }
            test_CRS_IINN_TYPE = field_CRS_IINN_TYPE.getAttribute("value");

            WebElement field_CRS_IINN;
            if (contour.equals("8083")) {
                field_CRS_IINN = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_IINN_8083));
            } else {
                field_CRS_IINN = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_IINN_8092));
            }
            test_CRS_IINN = field_CRS_IINN.getAttribute("value");

            WebElement field_CRS_NO_IINN_CODE;
            if (contour.equals("8083")) {
                field_CRS_NO_IINN_CODE = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_NO_IINN_CODE_8083));
            } else {
                field_CRS_NO_IINN_CODE = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_NO_IINN_CODE_8092));
            }
            test_CRS_NO_IINN_CODE = field_CRS_NO_IINN_CODE.getAttribute("value");

            WebElement field_CRS_NO_IINN_REASON;
            if (contour.equals("8083")) {
                field_CRS_NO_IINN_REASON = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_NO_IINN_REASON_8083));
            } else {
                field_CRS_NO_IINN_REASON = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_NO_IINN_REASON_8092));
            }
            test_CRS_NO_IINN_REASON = field_CRS_NO_IINN_REASON.getAttribute("value");

            WebElement field_CRS_DATE_BEGIN;
            if (contour.equals("8083")) {
                field_CRS_DATE_BEGIN = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_DATE_BEGIN_8083));
            } else {
                field_CRS_DATE_BEGIN = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_DATE_BEGIN_8092));
            }
            test_CRS_DATE_BEGIN = field_CRS_DATE_BEGIN.getAttribute("value");

            WebElement field_CRS_DATE_END;
            if (contour.equals("8083")) {
                field_CRS_DATE_END = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_DATE_END_8083));
            } else {
                field_CRS_DATE_END = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_DATE_END_8092));
            }
            test_CRS_DATE_END = field_CRS_DATE_END.getAttribute("value");

            WebElement field_CRS_STATUS;
            if (contour.equals("8083")) {
                field_CRS_STATUS = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_STATUS_8083));
            } else {
                field_CRS_STATUS = driver.findElement(By.xpath(XpathUpdatingOtherInformation.FIELD_CRS_STATUS_8092));
            }
            test_CRS_STATUS = field_CRS_STATUS.getAttribute("value");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

        System.out.println(productOrderNumber);
        System.out.println("---------------");
        System.out.println(test_ISREGOFFSHORZONE);
        System.out.println(test_OKPO);
        System.out.println(test_OKOGU);
        System.out.println(test_SWIFT);
        System.out.println(test_EIN);
        System.out.println(test_GIIN);
        System.out.println(test_FATCADOCW9);
        System.out.println(test_FATCADOC);
        System.out.println(test_DISREGARDED);
        System.out.println(test_FATCASTATUS);
        System.out.println(test_CRS_NALOG_RESIDENCE);
        System.out.println(test_CRS_IINN_TYPE);
        System.out.println(test_CRS_IINN);
        System.out.println(test_CRS_NO_IINN_CODE);
        System.out.println(test_CRS_NO_IINN_REASON);
        System.out.println(test_CRS_DATE_BEGIN);
        System.out.println(test_CRS_DATE_END);
        System.out.println(test_CRS_STATUS);
        System.out.println("---------------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");

            String selectTableSQLForType_1 = "SELECT fbpomd.ISREGOFFSHORZONE, " +
                    "fbpomd.OKPO, " +
                    "fbpomd.OKOGU, " +
                    "fbpomd.SWIFT, " +
                    "fbpomd.EIN, " +
                    "fbpomd.GIIN, " +
                    "fbpomd.FATCADOCW9, " +
                    "fbpomd.FATCADOC, " +
                    "fbpomd.IS_DISREGARDED, " +
                    "fbpomd.FATCASTATUS " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "' " +
                    "AND fbpomd.MEMBERDATATYPE = '1' " +
                    "AND fbpomd.ISPRIMARY = 'T' ";

            String selectTableSQLForType_2 = "SELECT fbpomd.ISREGOFFSHORZONE, " +
                    "fbpomd.OKPO, " +
                    "fbpomd.OKOGU, " +
                    "fbpomd.SWIFT, " +
                    "fbpomd.EIN, " +
                    "fbpomd.GIIN, " +
                    "fbpomd.FATCADOCW9, " +
                    "fbpomd.FATCADOC, " +
                    "fbpomd.IS_DISREGARDED, " +
                    "fbpomd.FATCASTATUS " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "' " +
                    "AND fbpomd.MEMBERDATATYPE = '2' " +
                    "AND fbpomd.ISPRIMARY = 'T' ";

            String selectTableSQLForType_3 = "SELECT fbpomd.ISREGOFFSHORZONE, " +
                    "fbpomd.OKPO, " +
                    "fbpomd.OKOGU, " +
                    "fbpomd.SWIFT, " +
                    "fbpomd.EIN, " +
                    "fbpomd.GIIN, " +
                    "fbpomd.FATCADOCW9, " +
                    "fbpomd.FATCADOC, " +
                    "fbpomd.IS_DISREGARDED, " +
                    "fbpomd.FATCASTATUS " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "' " +
                    "AND fbpomd.MEMBERDATATYPE = '3' " +
                    "AND fbpomd.ISPRIMARY = 'T' ";

            Statement statement = connection.createStatement();

            // Get data for type 1 from the database
            ResultSet rs_1 = statement.executeQuery(selectTableSQLForType_1);

            // if something was received then the while loop will work
            while (rs_1.next()) {
                isRegOffshorZone_type_1 = DataConversion.testSF_booleanConversion(rs_1.getString("ISREGOFFSHORZONE"));
                okpo_type_1 = rs_1.getString("OKPO");
                okogu_type_1 = rs_1.getString("OKOGU");
                swift_type_1 = rs_1.getString("SWIFT");
                ein_type_1 = rs_1.getString("EIN");
                giin_type_1 = rs_1.getString("GIIN");
                fatcaDocW9_type_1 = DataConversion.testSF_booleanConversion(rs_1.getString("FATCADOCW9"));
                fatcaDoc_type_1 = DataConversion.testSF_booleanConversion(rs_1.getString("FATCADOC"));
                disregarded_type_1 = DataConversion.testSF_booleanConversion(rs_1.getString("IS_DISREGARDED"));
                fatcaStatus_type_1 = rs_1.getString("FATCASTATUS");
            }

            // Get data for type 2 from the database
            ResultSet rs_2 = statement.executeQuery(selectTableSQLForType_2);

            // if something was received then the while loop will work
            while (rs_2.next()) {
                isRegOffshorZone_type_2 = DataConversion.testSF_booleanConversion(rs_2.getString("ISREGOFFSHORZONE"));
                okpo_type_2 = rs_2.getString("OKPO");
                okogu_type_2 = rs_2.getString("OKOGU");
                swift_type_2 = rs_2.getString("SWIFT");
                ein_type_2 = rs_2.getString("EIN");
                giin_type_2 = rs_2.getString("GIIN");
                fatcaDocW9_type_2 = DataConversion.testSF_booleanConversion(rs_2.getString("FATCADOCW9"));
                fatcaDoc_type_2 = DataConversion.testSF_booleanConversion(rs_2.getString("FATCADOC"));
                disregarded_type_2 = DataConversion.testSF_booleanConversion(rs_2.getString("IS_DISREGARDED"));
                fatcaStatus_type_2 = rs_2.getString("FATCASTATUS");
            }

            // Get data for type 3 from the database
            ResultSet rs_3 = statement.executeQuery(selectTableSQLForType_3);

            // if something was received then the while loop will work
            while (rs_3.next()) {
                isRegOffshorZone_type_3 = DataConversion.testSF_booleanConversion(rs_3.getString("ISREGOFFSHORZONE"));
                okpo_type_3 = rs_3.getString("OKPO");
                okogu_type_3 = rs_3.getString("OKOGU");
                swift_type_3 = rs_3.getString("SWIFT");
                ein_type_3 = rs_3.getString("EIN");
                giin_type_3 = rs_3.getString("GIIN");
                fatcaDocW9_type_3 = DataConversion.testSF_booleanConversion(rs_3.getString("FATCADOCW9"));
                fatcaDoc_type_3 = DataConversion.testSF_booleanConversion(rs_3.getString("FATCADOC"));
                disregarded_type_3 = DataConversion.testSF_booleanConversion(rs_3.getString("IS_DISREGARDED"));
                fatcaStatus_type_3 = rs_3.getString("FATCASTATUS");
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        //Comparison of data from a Web service with data from a database.
        if(Objects.equals(test_ISREGOFFSHORZONE, DataComparison.compareData(isRegOffshorZone_type_1, isRegOffshorZone_type_2, isRegOffshorZone_type_3))) {
            System.out.println("ISREGOFFSHORZONE test passed!");
        }else {
            System.out.println("ISREGOFFSHORZONE test failed! - X");
        }

        if(Objects.equals(test_OKPO, DataComparison.compareData(okpo_type_1, okpo_type_2, okpo_type_3))) {
            System.out.println("OKPO test passed!");
        }else {
            System.out.println("OKPO test failed! - X");
        }

        if(Objects.equals(test_OKOGU, DataComparison.compareData(okogu_type_1, okogu_type_2, okogu_type_3))) {
            System.out.println("OKOGU test passed!");
        }else {
            System.out.println("OKOGU test failed! - X");
        }

        if(Objects.equals(test_SWIFT, DataComparison.compareData(swift_type_1, swift_type_2, swift_type_3))) {
            System.out.println("SWIFT test passed!");
        }else {
            System.out.println("SWIFT test failed! - X");
        }

        if(Objects.equals(test_EIN, DataComparison.compareData(ein_type_1, ein_type_2, ein_type_3))) {
            System.out.println("EIN test passed!");
        }else {
            System.out.println("EIN test failed! - X");
        }

        if(Objects.equals(test_GIIN, DataComparison.compareData(giin_type_1, giin_type_2, giin_type_3))) {
            System.out.println("GIIN test passed!");
        }else {
            System.out.println("GIIN test failed! - X");
        }

        if(Objects.equals(test_FATCADOCW9, DataComparison.compareData(fatcaDocW9_type_1, fatcaDocW9_type_2, fatcaDocW9_type_3))) {
            System.out.println("FATCADOCW9 test passed!");
        }else {
            System.out.println("FATCADOCW9 test failed! - X");
        }

        if(Objects.equals(test_FATCADOC, DataComparison.compareData(fatcaDoc_type_1, fatcaDoc_type_2, fatcaDoc_type_3))) {
            System.out.println("FATCADOC test passed!");
        }else {
            System.out.println("FATCADOC test failed! - X");
        }

        if(Objects.equals(test_DISREGARDED, DataComparison.compareData(disregarded_type_1, disregarded_type_2, disregarded_type_3))) {
            System.out.println("DISREGARDED test passed!");
        }else {
            System.out.println("DISREGARDED test failed! - X");
        }

        if(Objects.equals(test_FATCASTATUS, DataComparison.compareData(fatcaStatus_type_1, fatcaStatus_type_2, fatcaStatus_type_3))) {
            System.out.println("FATCASTATUS test passed!");
        }else {
            System.out.println("FATCASTATUS test failed! - X");
        }

        if(Objects.equals(test_CRS_NALOG_RESIDENCE, DataComparison.compareData(crsNalogResidence_type_1, crsNalogResidence_type_2, crsNalogResidence_type_3))) {
            System.out.println("CRS_NALOG_RESIDENCE test passed!");
        }else {
            System.out.println("CRS_NALOG_RESIDENCE test failed! - X");
        }

        if(Objects.equals(test_CRS_IINN_TYPE, DataComparison.compareData(crsIINNType_type_1, crsIINNType_type_2, crsIINNType_type_3))) {
            System.out.println("CRS_IINN_TYPE test passed!");
        }else {
            System.out.println("CRS_IINN_TYPE test failed! - X");
        }

        if(Objects.equals(test_CRS_IINN, DataComparison.compareData(crsIINN_type_1, crsIINN_type_2, crsIINN_type_3))) {
            System.out.println("CRS_IINN test passed!");
        }else {
            System.out.println("CRS_IINN test failed! - X");
        }

        if(Objects.equals(test_CRS_NO_IINN_CODE, DataComparison.compareData(crsNoIINNCode_type_1, crsNoIINNCode_type_2, crsNoIINNCode_type_3))) {
            System.out.println("CRS_NO_IINN_CODE test passed!");
        }else {
            System.out.println("CRS_NO_IINN_CODE test failed! - X");
        }

        if(Objects.equals(test_CRS_NO_IINN_REASON, DataComparison.compareData(crsNoIINNReason_type_1, crsNoIINNReason_type_2, crsNoIINNReason_type_3))) {
            System.out.println("CRS_NO_IINN_REASON test passed!");
        }else {
            System.out.println("CRS_NO_IINN_REASON test failed! - X");
        }

        if(Objects.equals(test_CRS_DATE_BEGIN, DataComparison.compareData(crsDateBegin_type_1, crsDateBegin_type_2, crsDateBegin_type_3))) {
            System.out.println("CRS_DATE_BEGIN test passed!");
        }else {
            System.out.println("CRS_DATE_BEGIN test failed! - X");
        }

        if(Objects.equals(test_CRS_DATE_END, DataComparison.compareData(crsDateEnd_type_1, crsDateEnd_type_2, crsDateEnd_type_3))) {
            System.out.println("CRS_DATE_END test passed!");
        }else {
            System.out.println("CRS_DATE_END test failed! - X");
        }

        if(Objects.equals(test_CRS_STATUS, DataComparison.compareData(crsStatus_type_1, crsStatus_type_2, crsStatus_type_3))) {
            System.out.println("CRS_STATUS test passed!");
        }else {
            System.out.println("CRS_STATUS test failed! - X");
        }

        System.out.println("----------------------------");
    }
}
