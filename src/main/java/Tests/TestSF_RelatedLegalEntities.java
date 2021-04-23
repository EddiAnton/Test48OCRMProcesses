package Tests;

import Services.*;
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

public class TestSF_RelatedLegalEntities {

    final String requestMask = "UC-TSP";
    String productOrderNumber = null;

    String test_CODE_FACE = null;
    String test_ACCOUNTNAME_RLE = null;
    String test_AKA_RLE = null;
    String test_ENGNAME_RLE = null;
    String test_ENGNAMESHORT_RLE = null;
    String test_OKFS_RLE = null;
    String test_COMPANYTYPE_RLE = null;
    String test_OKOPF_RLE = null;
    String test_JURISDICTION_RLE = null;
    String test_ISREGOFFSHORZONE_RLE = null;
    String test_INN_RLE = null;
    String test_CODE_KPP_RLE = null;
    String test_SWIFT_RLE = null;
    String test_KIO_RLE = null;
    String test_OKATO_RLE = null;
    String test_OKTMO_RLE = null;
    String test_OKPO_RLE = null;
    String test_OKOGU_RLE = null;

    String codeFace_type_1 = null;
    String accountNameRLE_type_1 = null;
    String akaRLE_type_1 = null;
    String engNameRLE_type_1 = null;
    String engNameShortRLE_type_1 = null;
    int codeOkfsRLE_type_1 = 0;
    String okfsRLE_type_1 = null;
    String codeCompanyTypeRLE_type_1 = null;
    String companyTypeRLE_type_1 = null;
    int codeOkopfRLE_type_1 = 0;
    String okopfRLE_type_1 = null;
    String jurisdictionRLE_type_1 = null;
    String isRegOffshorZoneRLE_type_1 = null;
    String innRLE_type_1 = null;
    String codeKPPRLE_type_1 = null;
    String swiftRLE_type_1 = null;
    String kioRLE_type_1 = null;
    String okatoRLE_type_1 = null;
    String oktmoRLE_type_1 = null;
    String okpoRLE_type_1 = null;
    String okoguRLE_type_1 = null;

    String codeFace_type_2 = null;
    String accountNameRLE_type_2 = null;
    String akaRLE_type_2 = null;
    String engNameRLE_type_2 = null;
    String engNameShortRLE_type_2 = null;
    int codeOkfsRLE_type_2 = 0;
    String okfsRLE_type_2 = null;
    String codeCompanyTypeRLE_type_2 = null;
    String companyTypeRLE_type_2 = null;
    int codeOkopfRLE_type_2 = 0;
    String okopfRLE_type_2 = null;
    String jurisdictionRLE_type_2 = null;
    String isRegOffshorZoneRLE_type_2 = null;
    String innRLE_type_2 = null;
    String codeKPPRLE_type_2 = null;
    String swiftRLE_type_2 = null;
    String kioRLE_type_2 = null;
    String okatoRLE_type_2 = null;
    String oktmoRLE_type_2 = null;
    String okpoRLE_type_2 = null;
    String okoguRLE_type_2 = null;

    String codeFace_type_3 = null;
    String accountNameRLE_type_3 = null;
    String akaRLE_type_3 = null;
    String engNameRLE_type_3 = null;
    String engNameShortRLE_type_3 = null;
    int codeOkfsRLE_type_3 = 0;
    String okfsRLE_type_3 = null;
    String codeCompanyTypeRLE_type_3 = null;
    String companyTypeRLE_type_3 = null;
    int codeOkopfRLE_type_3 = 0;
    String okopfRLE_type_3 = null;
    String jurisdictionRLE_type_3 = null;
    String isRegOffshorZoneRLE_type_3 = null;
    String innRLE_type_3 = null;
    String codeKPPRLE_type_3 = null;
    String swiftRLE_type_3 = null;
    String kioRLE_type_3 = null;
    String okatoRLE_type_3 = null;
    String oktmoRLE_type_3 = null;
    String okpoRLE_type_3 = null;
    String okoguRLE_type_3 = null;

    @Parameters({"contour"})
    @Test
    public void testRelatedLegalEntities(String contour) {

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

            // Select the Related Legal Entities tab
            WebElement relatedLegalEntitiesTab = new WebDriverWait(driver, 15).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathRelatedLegalEntities.RELATED_LEGAL_ENTITIES_TAB)));
            relatedLegalEntitiesTab.click();

            // Disclose data on the Related Legal Entities - " V "
            WebElement openRelatedLegalEntities;
            if (contour.equals("8083")) {
                openRelatedLegalEntities = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathRelatedLegalEntities.OPEN_RELATED_LEGAL_ENTITIES_8083)));
            } else {
                openRelatedLegalEntities = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathRelatedLegalEntities.OPEN_RELATED_LEGAL_ENTITIES_8092)));
            }
            openRelatedLegalEntities.click();

            // Get data of the Related Legal Entities type
            WebElement field_CODE_FACE;
            if (contour.equals("8083")) {
                field_CODE_FACE = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathRelatedLegalEntities.FIELD_CODE_FACE_8083)));
            } else {
                field_CODE_FACE = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathRelatedLegalEntities.FIELD_CODE_FACE_8092)));
            }
            test_CODE_FACE = field_CODE_FACE.getAttribute("value");

            WebElement field_ACCOUNTNAME_RLE;
            if (contour.equals("8083")) {
                field_ACCOUNTNAME_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_ACCOUNTNAME_8083));
            } else {
                field_ACCOUNTNAME_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_ACCOUNTNAME_8092));
            }
            test_ACCOUNTNAME_RLE = field_ACCOUNTNAME_RLE.getAttribute("value");

            WebElement field_AKA_RLE;
            if (contour.equals("8083")) {
                field_AKA_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_AKA_8083));
            } else {
                field_AKA_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_AKA_8092));
            }
            test_AKA_RLE = field_AKA_RLE.getAttribute("value");

            WebElement field_ENGNAME_RLE;
            if (contour.equals("8083")) {
                field_ENGNAME_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_ENGNAME_8083));
            } else {
                field_ENGNAME_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_ENGNAME_8092));
            }
            test_ENGNAME_RLE = field_ENGNAME_RLE.getAttribute("value");

            WebElement field_ENGNAMESHORT_RLE;
            if (contour.equals("8083")) {
                field_ENGNAMESHORT_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_ENGNAMESHORT_8083));
            } else {
                field_ENGNAMESHORT_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_ENGNAMESHORT_8092));
            }
            test_ENGNAMESHORT_RLE = field_ENGNAMESHORT_RLE.getAttribute("value");

            WebElement field_OKFS_RLE;
            if (contour.equals("8083")) {
                field_OKFS_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKFS_8083));
            } else {
                field_OKFS_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKFS_8092));
            }
            test_OKFS_RLE = field_OKFS_RLE.getAttribute("value");

            WebElement field_COMPANYTYPE_RLE;
            if (contour.equals("8083")) {
                field_COMPANYTYPE_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_COMPANYTYPE_8083));
            } else {
                field_COMPANYTYPE_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_COMPANYTYPE_8092));
            }
            test_COMPANYTYPE_RLE = field_COMPANYTYPE_RLE.getAttribute("value");

            WebElement field_OKOPF_RLE;
            if (contour.equals("8083")) {
                field_OKOPF_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKOPF_8083));
            } else {
                field_OKOPF_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKOPF_8092));
            }
            test_OKOPF_RLE = field_OKOPF_RLE.getAttribute("value");

            WebElement field_JURISDICTION_RLE;
            if (contour.equals("8083")) {
                field_JURISDICTION_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_JURISDICTION_8083));
            } else {
                field_JURISDICTION_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_JURISDICTION_8092));
            }
            test_JURISDICTION_RLE = field_JURISDICTION_RLE.getAttribute("value");

            WebElement field_ISREGOFFSHORZONE_RLE;
            if (contour.equals("8083")) {
                field_ISREGOFFSHORZONE_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_ISREGOFFSHORZONE_8083));
            } else {
                field_ISREGOFFSHORZONE_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_ISREGOFFSHORZONE_8092));
            }
            test_ISREGOFFSHORZONE_RLE = field_ISREGOFFSHORZONE_RLE.getAttribute("value");

            WebElement field_INN_RLE;
            if (contour.equals("8083")) {
                field_INN_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_INN_8083));
            } else {
                field_INN_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_INN_8092));
            }
            test_INN_RLE = field_INN_RLE.getAttribute("value");

            WebElement field_CODE_KPP_RLE;
            if (contour.equals("8083")) {
                field_CODE_KPP_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_CODE_KPP_8083));
            } else {
                field_CODE_KPP_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_CODE_KPP_8092));
            }
            test_CODE_KPP_RLE = field_CODE_KPP_RLE.getAttribute("value");

            WebElement field_SWIFT_RLE;
            if (contour.equals("8083")) {
                field_SWIFT_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_SWIFT_8083));
            } else {
                field_SWIFT_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_SWIFT_8092));
            }
            test_SWIFT_RLE = field_SWIFT_RLE.getAttribute("value");

            WebElement field_KIO_RLE;
            if (contour.equals("8083")) {
                field_KIO_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_KIO_8083));
            } else {
                field_KIO_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_KIO_8092));
            }
            test_KIO_RLE = field_KIO_RLE.getAttribute("value");

            WebElement field_OKATO_RLE;
            if (contour.equals("8083")) {
                field_OKATO_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKATO_8083));
            } else {
                field_OKATO_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKATO_8092));
            }
            test_OKATO_RLE = field_OKATO_RLE.getAttribute("value");

            WebElement field_OKTMO_RLE;
            if (contour.equals("8083")) {
                field_OKTMO_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKTMO_8083));
            } else {
                field_OKTMO_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKTMO_8092));
            }
            test_OKTMO_RLE = field_OKTMO_RLE.getAttribute("value");

            WebElement field_OKPO_RLE;
            if (contour.equals("8083")) {
                field_OKPO_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKPO_8083));
            } else {
                field_OKPO_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKPO_8092));
            }
            test_OKPO_RLE = field_OKPO_RLE.getAttribute("value");

            WebElement field_OKOGU_RLE;
            if (contour.equals("8083")) {
                field_OKOGU_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKOGU_8083));
            } else {
                field_OKOGU_RLE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKOGU_8092));
            }
            test_OKOGU_RLE = field_OKOGU_RLE.getAttribute("value");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

        System.out.println(productOrderNumber);
        System.out.println("---------------");
        System.out.println(test_CODE_FACE);
        System.out.println(test_ACCOUNTNAME_RLE);
        System.out.println(test_AKA_RLE);
        System.out.println(test_ENGNAME_RLE);
        System.out.println(test_ENGNAMESHORT_RLE);
        System.out.println(test_OKFS_RLE);
        System.out.println(test_COMPANYTYPE_RLE);
        System.out.println(test_OKOPF_RLE);
        System.out.println(test_JURISDICTION_RLE);
        System.out.println(test_ISREGOFFSHORZONE_RLE);
        System.out.println(test_INN_RLE);
        System.out.println(test_CODE_KPP_RLE);
        System.out.println(test_SWIFT_RLE);
        System.out.println(test_KIO_RLE);
        System.out.println(test_OKATO_RLE);
        System.out.println(test_OKTMO_RLE);
        System.out.println(test_OKPO_RLE);
        System.out.println(test_OKOGU_RLE);
        System.out.println("---------------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");

            String selectTableSQLForType_1 = "SELECT fbpomd.ACCOUNTNAME, " +
                    "fbpomd.AKA, " +
                    "fbpomd.ENGNAME, " +
                    "fbpomd.ENGNAMESHORT, " +
                    "fbpomd.OKFS, " +
                    "fbpomd.COMPANYTYPE, " +
                    "fbpomd.OKOPF, " +
                    "fbpomd.JURISDICTION, " +
                    "fbpomd.ISREGOFFSHORZONE, " +
                    "fbpomd.INN, " +
                    "fbpomd.SWIFT, " +
                    "fbpomd.KIO, " +
                    "fbpomd.OKATO, " +
                    "fbpomd.OKTMO, " +
                    "fbpomd.OKPO, " +
                    "fbpomd.OKOGU " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "' " +
                    "AND fbpomd.MEMBERDATATYPE = '1' " +
                    "AND fbpomd.ISPRIMARY = 'F' " +
                    "AND fbpomd.INN = '" + test_INN_RLE + "'";

            String selectTableSQLForType_2 = "SELECT fbpomd.ACCOUNTNAME, " +
                    "fbpomd.AKA, " +
                    "fbpomd.ENGNAME, " +
                    "fbpomd.ENGNAMESHORT, " +
                    "fbpomd.OKFS, " +
                    "fbpomd.COMPANYTYPE, " +
                    "fbpomd.OKOPF, " +
                    "fbpomd.JURISDICTION, " +
                    "fbpomd.ISREGOFFSHORZONE, " +
                    "fbpomd.INN, " +
                    "fbpomd.SWIFT, " +
                    "fbpomd.KIO, " +
                    "fbpomd.OKATO, " +
                    "fbpomd.OKTMO, " +
                    "fbpomd.OKPO, " +
                    "fbpomd.OKOGU " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "' " +
                    "AND fbpomd.MEMBERDATATYPE = '2' " +
                    "AND fbpomd.ISPRIMARY = 'F' " +
                    "AND fbpomd.INN = '" + test_INN_RLE + "'";

            String selectTableSQLForType_3 = "SELECT fbpomd.ACCOUNTNAME, " +
                    "fbpomd.AKA, " +
                    "fbpomd.ENGNAME, " +
                    "fbpomd.ENGNAMESHORT, " +
                    "fbpomd.OKFS, " +
                    "fbpomd.COMPANYTYPE, " +
                    "fbpomd.OKOPF, " +
                    "fbpomd.JURISDICTION, " +
                    "fbpomd.ISREGOFFSHORZONE, " +
                    "fbpomd.INN, " +
                    "fbpomd.SWIFT, " +
                    "fbpomd.KIO, " +
                    "fbpomd.OKATO, " +
                    "fbpomd.OKTMO, " +
                    "fbpomd.OKPO, " +
                    "fbpomd.OKOGU " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "' " +
                    "AND fbpomd.MEMBERDATATYPE = '3' " +
                    "AND fbpomd.ISPRIMARY = 'F' " +
                    "AND fbpomd.INN = '" + test_INN_RLE + "'";

            Statement statement = connection.createStatement();

            // Get data for type 1 from the database
            ResultSet rs_1 = statement.executeQuery(selectTableSQLForType_1);

            // if something was received then the while loop will work
            while (rs_1.next()) {
                accountNameRLE_type_1 = rs_1.getString("ACCOUNTNAME");
                akaRLE_type_1 = rs_1.getString("AKA");
                engNameRLE_type_1 = rs_1.getString("ENGNAME");
                engNameShortRLE_type_1 = rs_1.getString("ENGNAMESHORT");
                codeOkfsRLE_type_1 = rs_1.getInt("OKFS");
                codeCompanyTypeRLE_type_1 = rs_1.getString("COMPANYTYPE");
                codeOkopfRLE_type_1 = rs_1.getInt("OKOPF");
                jurisdictionRLE_type_1 = rs_1.getString("JURISDICTION");
                isRegOffshorZoneRLE_type_1 = rs_1.getString("ISREGOFFSHORZONE");
                innRLE_type_1 = rs_1.getString("INN");
                swiftRLE_type_1 = rs_1.getString("SWIFT");
                kioRLE_type_1 = rs_1.getString("KIO");
                okatoRLE_type_1 = rs_1.getString("OKATO");
                oktmoRLE_type_1 = rs_1.getString("OKTMO");
                okpoRLE_type_1 = rs_1.getString("OKPO");
                okoguRLE_type_1 = rs_1.getString("OKOGU");
            }

            String selectPicklistOKFS_1 = "select shortname " +
                    "from fb_okfs " +
                    "where code = " + codeOkfsRLE_type_1;

            ResultSet rs_1_okfs = statement.executeQuery(selectPicklistOKFS_1);
            while (rs_1_okfs.next()) {
                okfsRLE_type_1 = rs_1_okfs.getString("SHORTNAME");
            }

            String selectPicklistCompanyType_1 = "select pl.text " +
                    "from picklist pl " +
                    "where pl.picklistid = 'k6UJ9A000FPX' " +
                    "AND pl.shorttext = '" + codeCompanyTypeRLE_type_1 + "'";

            ResultSet rs_1_companyType = statement.executeQuery(selectPicklistCompanyType_1);
            while (rs_1_companyType.next()) {
                companyTypeRLE_type_1 = rs_1_companyType.getString("TEXT");
            }

            String selectPicklistOKOPF_1 = "select fullname " +
                    "from fb_okopf " +
                    "where code = " + codeOkopfRLE_type_1;

            ResultSet rs_1_okopf = statement.executeQuery(selectPicklistOKOPF_1);
            while (rs_1_okopf.next()) {
                okopfRLE_type_1 = rs_1_okopf.getString("FULLNAME");
            }


            // Get data for type 2 from the database
            ResultSet rs_2 = statement.executeQuery(selectTableSQLForType_2);

            // if something was received then the while loop will work
            while (rs_2.next()) {
                accountNameRLE_type_2 = rs_2.getString("ACCOUNTNAME");
                akaRLE_type_2 = rs_2.getString("AKA");
                engNameRLE_type_2 = rs_2.getString("ENGNAME");
                engNameShortRLE_type_2 = rs_2.getString("ENGNAMESHORT");
                codeOkfsRLE_type_2 = rs_2.getInt("OKFS");
                codeCompanyTypeRLE_type_2 = rs_2.getString("COMPANYTYPE");
                codeOkopfRLE_type_2 = rs_2.getInt("OKOPF");
                jurisdictionRLE_type_2 = rs_2.getString("JURISDICTION");
                isRegOffshorZoneRLE_type_2 = rs_2.getString("ISREGOFFSHORZONE");
                innRLE_type_2 = rs_2.getString("INN");
                swiftRLE_type_2 = rs_2.getString("SWIFT");
                kioRLE_type_2 = rs_2.getString("KIO");
                okatoRLE_type_2 = rs_2.getString("OKATO");
                oktmoRLE_type_2 = rs_2.getString("OKTMO");
                okpoRLE_type_2 = rs_2.getString("OKPO");
                okoguRLE_type_2 = rs_2.getString("OKOGU");
            }

            String selectPicklistOKFS_2 = "select shortname " +
                    "from fb_okfs " +
                    "where code = " + codeOkfsRLE_type_2;

            ResultSet rs_2_okfs = statement.executeQuery(selectPicklistOKFS_2);
            while (rs_2_okfs.next()) {
                okfsRLE_type_2 = rs_2_okfs.getString("SHORTNAME");
            }

            String selectPicklistCompanyType_2 = "select pl.text " +
                    "from picklist pl " +
                    "where pl.picklistid = 'k6UJ9A000FPX' " +
                    "AND pl.shorttext = '" + codeCompanyTypeRLE_type_2 + "'";

            ResultSet rs_2_companyType = statement.executeQuery(selectPicklistCompanyType_2);
            while (rs_2_companyType.next()) {
                companyTypeRLE_type_2 = rs_2_companyType.getString("TEXT");
            }

            String selectPicklistOKOPF_2 = "select fullname " +
                    "from fb_okopf " +
                    "where code = " + codeOkopfRLE_type_2;

            ResultSet rs_2_okopf = statement.executeQuery(selectPicklistOKOPF_2);
            while (rs_2_okopf.next()) {
                okopfRLE_type_2 = rs_2_okopf.getString("FULLNAME");
            }


            // Get data for type 3 from the database
            ResultSet rs_3 = statement.executeQuery(selectTableSQLForType_3);

            // if something was received then the while loop will work
            while (rs_3.next()) {
                accountNameRLE_type_3 = rs_3.getString("ACCOUNTNAME");
                akaRLE_type_3 = rs_3.getString("AKA");
                engNameRLE_type_3 = rs_3.getString("ENGNAME");
                engNameShortRLE_type_3 = rs_3.getString("ENGNAMESHORT");
                codeOkfsRLE_type_3 = rs_3.getInt("OKFS");
                codeCompanyTypeRLE_type_3 = rs_3.getString("COMPANYTYPE");
                codeOkopfRLE_type_3 = rs_3.getInt("OKOPF");
                jurisdictionRLE_type_3 = rs_3.getString("JURISDICTION");
                isRegOffshorZoneRLE_type_3 = rs_3.getString("ISREGOFFSHORZONE");
                innRLE_type_3 = rs_3.getString("INN");
                swiftRLE_type_3 = rs_3.getString("SWIFT");
                kioRLE_type_3 = rs_3.getString("KIO");
                okatoRLE_type_3 = rs_3.getString("OKATO");
                oktmoRLE_type_3 = rs_3.getString("OKTMO");
                okpoRLE_type_3 = rs_3.getString("OKPO");
                okoguRLE_type_3 = rs_3.getString("OKOGU");
            }

            String selectPicklistOKFS_3 = "select shortname " +
                    "from fb_okfs " +
                    "where code = " + codeOkfsRLE_type_3;

            ResultSet rs_3_okfs = statement.executeQuery(selectPicklistOKFS_3);
            while (rs_3_okfs.next()) {
                okfsRLE_type_3 = rs_3_okfs.getString("SHORTNAME");
            }

            String selectPicklistCompanyType_3 = "select pl.text " +
                    "from picklist pl " +
                    "where pl.picklistid = 'k6UJ9A000FPX' " +
                    "AND pl.shorttext = '" + codeCompanyTypeRLE_type_3 + "'";

            ResultSet rs_3_companyType = statement.executeQuery(selectPicklistCompanyType_3);
            while (rs_3_companyType.next()) {
                companyTypeRLE_type_3 = rs_3_companyType.getString("TEXT");
            }

            String selectPicklistOKOPF_3 = "select fullname " +
                    "from fb_okopf " +
                    "where code = " + codeOkopfRLE_type_3;

            ResultSet rs_3_okopf = statement.executeQuery(selectPicklistOKOPF_3);
            while (rs_3_okopf.next()) {
                okopfRLE_type_3 = rs_3_okopf.getString("FULLNAME");
            }


            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        //Comparison of data from a Web service with data from a database.
        if(Objects.equals(test_CODE_FACE, DataComparison.compareData(codeFace_type_1, codeFace_type_2, codeFace_type_3))) {
            System.out.println("CODE_FACE test passed!");
        }else {
            System.out.println("CODE_FACE test failed! - X");
        }

        if(Objects.equals(test_ACCOUNTNAME_RLE, DataComparison.compareData(accountNameRLE_type_1, accountNameRLE_type_2, accountNameRLE_type_3))) {
            System.out.println("ACCOUNTNAME test passed!");
        }else {
            System.out.println("ACCOUNTNAME test failed! - X");
        }

        if(Objects.equals(test_AKA_RLE, DataComparison.compareData(akaRLE_type_1, akaRLE_type_2, akaRLE_type_3))) {
            System.out.println("AKA test passed!");
        }else {
            System.out.println("AKA test failed! - X");
        }

        if(Objects.equals(test_ENGNAME_RLE, DataComparison.compareData(engNameRLE_type_1, engNameRLE_type_2, engNameRLE_type_3))) {
            System.out.println("ENGNAME test passed!");
        }else {
            System.out.println("ENGNAME test failed! - X");
        }

        if(Objects.equals(test_ENGNAMESHORT_RLE, DataComparison.compareData(engNameShortRLE_type_1, engNameShortRLE_type_2, engNameShortRLE_type_3))) {
            System.out.println("ENGNAMESHORT test passed!");
        }else {
            System.out.println("ENGNAMESHORT test failed! - X");
        }

        if(Objects.equals(test_OKFS_RLE, DataComparison.compareData(okfsRLE_type_1, okfsRLE_type_2, okfsRLE_type_3))) {
            System.out.println("OKFS test passed!");
        }else {
            System.out.println("OKFS test failed! - X");
        }

        if(Objects.equals(test_COMPANYTYPE_RLE, DataComparison.compareData(companyTypeRLE_type_1, companyTypeRLE_type_2, companyTypeRLE_type_3))) {
            System.out.println("COMPANYTYPE test passed!");
        }else {
            System.out.println("COMPANYTYPE test failed! - X");
        }

        if(Objects.equals(test_OKOPF_RLE, DataComparison.compareData(okopfRLE_type_1, okopfRLE_type_2, okopfRLE_type_3))) {
            System.out.println("OKOPF test passed!");
        }else {
            System.out.println("OKOPF test failed! - X");
        }

        if(Objects.equals(test_JURISDICTION_RLE, DataComparison.compareData(jurisdictionRLE_type_1, jurisdictionRLE_type_2, jurisdictionRLE_type_3))) {
            System.out.println("JURISDICTION test passed!");
        }else {
            System.out.println("JURISDICTION test failed! - X");
        }

        if(Objects.equals(test_ISREGOFFSHORZONE_RLE, DataComparison.compareData(isRegOffshorZoneRLE_type_1, isRegOffshorZoneRLE_type_2, isRegOffshorZoneRLE_type_3))) {
            System.out.println("ISREGOFFSHORZONE test passed!");
        }else {
            System.out.println("ISREGOFFSHORZONE test failed! - X");
        }

        if(Objects.equals(test_INN_RLE, DataComparison.compareData(innRLE_type_1, innRLE_type_2, innRLE_type_3))) {
            System.out.println("INN test passed!");
        }else {
            System.out.println("INN test failed! - X");
        }

        if(Objects.equals(test_CODE_KPP_RLE, DataComparison.compareData(codeKPPRLE_type_1, codeKPPRLE_type_2, codeKPPRLE_type_3))) {
            System.out.println("CODE_KPP test passed!");
        }else {
            System.out.println("CODE_KPP test failed! - X");
        }

        if(Objects.equals(test_SWIFT_RLE, DataComparison.compareData(swiftRLE_type_1, swiftRLE_type_2, swiftRLE_type_3))) {
            System.out.println("SWIFT test passed!");
        }else {
            System.out.println("SWIFT test failed! - X");
        }

        if(Objects.equals(test_KIO_RLE, DataComparison.compareData(kioRLE_type_1, kioRLE_type_2, kioRLE_type_3))) {
            System.out.println("KIO test passed!");
        }else {
            System.out.println("KIO test failed! - X");
        }

        if(Objects.equals(test_OKATO_RLE, DataComparison.compareData(okatoRLE_type_1, okatoRLE_type_2, okatoRLE_type_3))) {
            System.out.println("OKATO test passed!");
        }else {
            System.out.println("OKATO test failed! - X");
        }

        if(Objects.equals(test_OKTMO_RLE, DataComparison.compareData(oktmoRLE_type_1, oktmoRLE_type_2, oktmoRLE_type_3))) {
            System.out.println("OKTMO test passed!");
        }else {
            System.out.println("OKTMO test failed! - X");
        }

        if(Objects.equals(test_OKPO_RLE, DataComparison.compareData(okpoRLE_type_1, okpoRLE_type_2, okpoRLE_type_3))) {
            System.out.println("OKPO test passed!");
        }else {
            System.out.println("OKPO test failed! - X");
        }

        if(Objects.equals(test_OKOGU_RLE, DataComparison.compareData(okoguRLE_type_1, okoguRLE_type_2, okoguRLE_type_3))) {
            System.out.println("OKOGU test passed!");
        }else {
            System.out.println("OKOGU test failed! - X");
        }

        System.out.println("----------------------------");
    }
}
