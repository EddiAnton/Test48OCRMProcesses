package Tests_8083;

import Services.DataComparison;
import Services.DataConversion;
import Services.Rerty;
import Services.XpathAuthorization;
import Services.XpathRelatedLegalEntities;

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

public class TestRelatedLegalEntities {
    final String DB_Data = "jdbc:oracle:thin:@server:1521:slx0";

    String userName = "Admin";
    String requestMask = "UC-TSP";

    String productOrderNumber = null;

    String test_CODE_FACE = null;
    String test_ACCOUNTNAME = null;
    String test_AKA = null;
    String test_ENGNAME = null;
    String test_ENGNAMESHORT = null;
    String test_OKFS = null;
    String test_COMPANYTYPE = null;
    String test_OKOPF = null;
    String test_JURISDICTION = null;
    String test_ISREGOFFSHORZONE = null;
    String test_INN = null;
    String test_CODE_KPP = null;
    String test_SWIFT = null;
    String test_KIO = null;
    String test_OKATO = null;
    String test_OKTMO = null;
    String test_OKPO = null;
    String test_OKOGU = null;

    String codeFace_type_1 = null;
    String accountName_type_1 = null;
    String aka_type_1 = null;
    String engName_type_1 = null;
    String engNameShort_type_1 = null;
    int codeOkfs_type_1 = 0;
    String okfs_type_1 = null;
    String codeCompanyType_type_1 = null;
    String companyType_type_1 = null;
    int codeOkopf_type_1 = 0;
    String okopf_type_1 = null;
    String jurisdiction_type_1 = null;
    String isRegOffshorZone_type_1 = null;
    String inn_type_1 = null;
    String codeKPP_type_1 = null;
    String swift_type_1 = null;
    String kio_type_1 = null;
    String okato_type_1 = null;
    String oktmo_type_1 = null;
    String okpo_type_1 = null;
    String okogu_type_1 = null;

    String codeFace_type_2 = null;
    String accountName_type_2 = null;
    String aka_type_2 = null;
    String engName_type_2 = null;
    String engNameShort_type_2 = null;
    int codeOkfs_type_2 = 0;
    String okfs_type_2 = null;
    String codeCompanyType_type_2 = null;
    String companyType_type_2 = null;
    int codeOkopf_type_2 = 0;
    String okopf_type_2 = null;
    String jurisdiction_type_2 = null;
    String isRegOffshorZone_type_2 = null;
    String inn_type_2 = null;
    String codeKPP_type_2 = null;
    String swift_type_2 = null;
    String kio_type_2 = null;
    String okato_type_2 = null;
    String oktmo_type_2 = null;
    String okpo_type_2 = null;
    String okogu_type_2 = null;

    String codeFace_type_3 = null;
    String accountName_type_3 = null;
    String aka_type_3 = null;
    String engName_type_3 = null;
    String engNameShort_type_3 = null;
    int codeOkfs_type_3 = 0;
    String okfs_type_3 = null;
    String codeCompanyType_type_3 = null;
    String companyType_type_3 = null;
    int codeOkopf_type_3 = 0;
    String okopf_type_3 = null;
    String jurisdiction_type_3 = null;
    String isRegOffshorZone_type_3 = null;
    String inn_type_3 = null;
    String codeKPP_type_3 = null;
    String swift_type_3 = null;
    String kio_type_3 = null;
    String okato_type_3 = null;
    String oktmo_type_3 = null;
    String okpo_type_3 = null;
    String okogu_type_3 = null;

    @Test(retryAnalyzer = Rerty.class)
    public void testRelatedLegalEntities() {

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8083/SlxClient/logoff.aspx");
            driver.manage().window().maximize();

            WebElement logoffHref = driver.findElement(By.linkText(XpathAuthorization.LOG_OFF_HREF));
            logoffHref.click();

            Thread.sleep(5000);

            // Authorization in system
            WebElement inputUserName = driver.findElement(By.xpath(XpathAuthorization.INPUT_USERNAME));
            inputUserName.sendKeys(userName);

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

            // Select the Related Legal Entities tab
            WebElement relatedLegalEntitiesTab = driver.findElement(By
                    .xpath(XpathRelatedLegalEntities.RELATED_LEGAL_ENTITIES_TAB));
            relatedLegalEntitiesTab.click();
            Thread.sleep(2000);

            // Disclose data on the Related Legal Entities - " V "
            WebElement openRelatedLegalEntities = driver.findElement(By
                    .xpath(XpathRelatedLegalEntities.OPEN_RELATED_LEGAL_ENTITIES));
            openRelatedLegalEntities.click();
            Thread.sleep(3000);

            // Get data of the Related Legal Entities type
            WebElement field_CODE_FACE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_CODE_FACE));
            test_CODE_FACE = field_CODE_FACE.getAttribute("value");

            WebElement field_ACCOUNTNAME = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_ACCOUNTNAME));
            test_ACCOUNTNAME = field_ACCOUNTNAME.getAttribute("value");

            WebElement field_AKA = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_AKA));
            test_AKA = field_AKA.getAttribute("value");

            WebElement field_ENGNAME = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_ENGNAME));
            test_ENGNAME = field_ENGNAME.getAttribute("value");

            WebElement field_ENGNAMESHORT = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_ENGNAMESHORT));
            test_ENGNAMESHORT = field_ENGNAMESHORT.getAttribute("value");

            WebElement field_OKFS = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKFS));
            test_OKFS = field_OKFS.getAttribute("value");

            WebElement field_COMPANYTYPE = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_COMPANYTYPE));
            test_COMPANYTYPE = field_COMPANYTYPE.getAttribute("value");

            WebElement field_OKOPF = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKOPF));
            test_OKOPF = field_OKOPF.getAttribute("value");

            WebElement field_JURISDICTION = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_JURISDICTION));
            test_JURISDICTION = field_JURISDICTION.getAttribute("value");

            WebElement field_ISREGOFFSHORZONE = driver.findElement(By
                    .xpath(XpathRelatedLegalEntities.FIELD_ISREGOFFSHORZONE));
            test_ISREGOFFSHORZONE = field_ISREGOFFSHORZONE.getAttribute("value");

            WebElement field_INN = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_INN));
            test_INN = field_INN.getAttribute("value");

            WebElement field_CODE_KPP = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_CODE_KPP));
            test_CODE_KPP = field_CODE_KPP.getAttribute("value");

            WebElement field_SWIFT = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_SWIFT));
            test_SWIFT = field_SWIFT.getAttribute("value");

            WebElement field_KIO = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_KIO));
            test_KIO = field_KIO.getAttribute("value");

            WebElement field_OKATO = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKATO));
            test_OKATO = field_OKATO.getAttribute("value");

            WebElement field_OKTMO = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKTMO));
            test_OKTMO = field_OKTMO.getAttribute("value");

            WebElement field_OKPO = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKPO));
            test_OKPO = field_OKPO.getAttribute("value");

            WebElement field_OKOGU = driver.findElement(By.xpath(XpathRelatedLegalEntities.FIELD_OKOGU));
            test_OKOGU = field_OKOGU.getAttribute("value");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

        System.out.println(productOrderNumber);
        System.out.println("---------------");
        System.out.println(test_CODE_FACE);
        System.out.println(test_ACCOUNTNAME);
        System.out.println(test_AKA);
        System.out.println(test_ENGNAME);
        System.out.println(test_ENGNAMESHORT);
        System.out.println(test_OKFS);
        System.out.println(test_COMPANYTYPE);
        System.out.println(test_OKOPF);
        System.out.println(test_JURISDICTION);
        System.out.println(test_ISREGOFFSHORZONE);
        System.out.println(test_INN);
        System.out.println(test_CODE_KPP);
        System.out.println(test_SWIFT);
        System.out.println(test_KIO);
        System.out.println(test_OKATO);
        System.out.println(test_OKTMO);
        System.out.println(test_OKPO);
        System.out.println(test_OKOGU);
        System.out.println("---------------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_Data, "SYSDBA", "masterkey");

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
                    "AND fbpomd.INN = '" + test_INN + "'";

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
                    "AND fbpomd.INN = '" + test_INN + "'";

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
                    "AND fbpomd.INN = '" + test_INN + "'";

            Statement statement = connection.createStatement();

            // Get data for type 1 from the database
            ResultSet rs_1 = statement.executeQuery(selectTableSQLForType_1);

            // if something was received then the while loop will work
            while (rs_1.next()) {
                accountName_type_1 = rs_1.getString("ACCOUNTNAME");
                aka_type_1 = rs_1.getString("AKA");
                engName_type_1 = rs_1.getString("ENGNAME");
                engNameShort_type_1 = rs_1.getString("ENGNAMESHORT");
                okfs_type_1 = rs_1.getString("OKFS");
                companyType_type_1 = rs_1.getString("COMPANYTYPE");
                okopf_type_1 = rs_1.getString("OKOPF");
                jurisdiction_type_1 = rs_1.getString("JURISDICTION");
                isRegOffshorZone_type_1 = rs_1.getString("ISREGOFFSHORZONE");
                inn_type_1 = rs_1.getString("INN");
                swift_type_1 = rs_1.getString("SWIFT");
                kio_type_1 = rs_1.getString("KIO");
                okato_type_1 = rs_1.getString("OKATO");
                oktmo_type_1 = rs_1.getString("OKTMO");
                okpo_type_1 = rs_1.getString("OKPO");
                okogu_type_1 = rs_1.getString("OKOGU");
            }

            // Get data for type 2 from the database
            ResultSet rs_2 = statement.executeQuery(selectTableSQLForType_2);

            // if something was received then the while loop will work
            while (rs_2.next()) {
                accountName_type_2 = rs_2.getString("ACCOUNTNAME");
                aka_type_2 = rs_2.getString("AKA");
                engName_type_2 = rs_2.getString("ENGNAME");
                engNameShort_type_2 = rs_2.getString("ENGNAMESHORT");
                okfs_type_2 = rs_2.getString("OKFS");
                companyType_type_2 = rs_2.getString("COMPANYTYPE");
                okopf_type_2 = rs_2.getString("OKOPF");
                jurisdiction_type_2 = rs_2.getString("JURISDICTION");
                isRegOffshorZone_type_2 = rs_2.getString("ISREGOFFSHORZONE");
                inn_type_2 = rs_2.getString("INN");
                swift_type_2 = rs_2.getString("SWIFT");
                kio_type_2 = rs_2.getString("KIO");
                okato_type_2 = rs_2.getString("OKATO");
                oktmo_type_2 = rs_2.getString("OKTMO");
                okpo_type_2 = rs_2.getString("OKPO");
                okogu_type_2 = rs_2.getString("OKOGU");
            }

            // Get data for type 3 from the database
            ResultSet rs_3 = statement.executeQuery(selectTableSQLForType_3);

            // if something was received then the while loop will work
            while (rs_3.next()) {
                accountName_type_3 = rs_3.getString("ACCOUNTNAME");
                aka_type_3 = rs_3.getString("AKA");
                engName_type_3 = rs_3.getString("ENGNAME");
                engNameShort_type_3 = rs_3.getString("ENGNAMESHORT");
                okfs_type_3 = rs_3.getString("OKFS");
                companyType_type_3 = rs_3.getString("COMPANYTYPE");
                okopf_type_3 = rs_3.getString("OKOPF");
                jurisdiction_type_3 = rs_3.getString("JURISDICTION");
                isRegOffshorZone_type_3 = rs_3.getString("ISREGOFFSHORZONE");
                inn_type_3 = rs_3.getString("INN");
                swift_type_3 = rs_3.getString("SWIFT");
                kio_type_3 = rs_3.getString("KIO");
                okato_type_3 = rs_3.getString("OKATO");
                oktmo_type_3 = rs_3.getString("OKTMO");
                okpo_type_3 = rs_3.getString("OKPO");
                okogu_type_3 = rs_3.getString("OKOGU");
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

        if(Objects.equals(test_ACCOUNTNAME, DataComparison.compareData(accountName_type_1, accountName_type_2, accountName_type_3))) {
            System.out.println("ACCOUNTNAME test passed!");
        }else {
            System.out.println("ACCOUNTNAME test failed! - X");
        }

        if(Objects.equals(test_AKA, DataComparison.compareData(aka_type_1, aka_type_2, aka_type_3))) {
            System.out.println("AKA test passed!");
        }else {
            System.out.println("AKA test failed! - X");
        }

        if(Objects.equals(test_ENGNAME, DataComparison.compareData(engName_type_1, engName_type_2, engName_type_3))) {
            System.out.println("ENGNAME test passed!");
        }else {
            System.out.println("ENGNAME test failed! - X");
        }

        if(Objects.equals(test_ENGNAMESHORT, DataComparison.compareData(engNameShort_type_1, engNameShort_type_2, engNameShort_type_3))) {
            System.out.println("ENGNAMESHORT test passed!");
        }else {
            System.out.println("ENGNAMESHORT test failed! - X");
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

        if(Objects.equals(test_JURISDICTION, DataComparison.compareData(jurisdiction_type_1, jurisdiction_type_2, jurisdiction_type_3))) {
            System.out.println("JURISDICTION test passed!");
        }else {
            System.out.println("JURISDICTION test failed! - X");
        }

        if(Objects.equals(test_ISREGOFFSHORZONE, DataComparison.compareData(isRegOffshorZone_type_1, isRegOffshorZone_type_2, isRegOffshorZone_type_3))) {
            System.out.println("ISREGOFFSHORZONE test passed!");
        }else {
            System.out.println("ISREGOFFSHORZONE test failed! - X");
        }

        if(Objects.equals(test_INN, DataComparison.compareData(inn_type_1, inn_type_2, inn_type_3))) {
            System.out.println("INN test passed!");
        }else {
            System.out.println("INN test failed! - X");
        }

        if(Objects.equals(test_CODE_KPP, DataComparison.compareData(codeKPP_type_1, codeKPP_type_2, codeKPP_type_3))) {
            System.out.println("CODE_KPP test passed!");
        }else {
            System.out.println("CODE_KPP test failed! - X");
        }

        if(Objects.equals(test_SWIFT, DataComparison.compareData(swift_type_1, swift_type_2, swift_type_3))) {
            System.out.println("SWIFT test passed!");
        }else {
            System.out.println("SWIFT test failed! - X");
        }

        if(Objects.equals(test_KIO, DataComparison.compareData(kio_type_1, kio_type_2, kio_type_3))) {
            System.out.println("KIO test passed!");
        }else {
            System.out.println("KIO test failed! - X");
        }

        if(Objects.equals(test_OKATO, DataComparison.compareData(okato_type_1, okato_type_2, okato_type_3))) {
            System.out.println("OKATO test passed!");
        }else {
            System.out.println("OKATO test failed! - X");
        }

        if(Objects.equals(test_OKTMO, DataComparison.compareData(oktmo_type_1, oktmo_type_2, oktmo_type_3))) {
            System.out.println("OKTMO test passed!");
        }else {
            System.out.println("OKTMO test failed! - X");
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

        System.out.println("----------------------------");
    }
}
