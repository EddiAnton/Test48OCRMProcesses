package Tests_8083;

import Services.DataComparison;
import Services.DateReplace;
import Services.Rerty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.JsonOutput;
import org.testng.annotations.Test;

import java.sql.*;
import java.util.Objects;

@Test
public class TestComplianceWEB_DBData {

    final String DB_Data = "jdbc:oracle:thin:@server:1521:slx0";

    String userName = "Admin";
    String requestMask = "UC-TSP";

    String productOrderNumber = null;

    // Variables for complianceNameOfCompany method
    String test_ACCOUNTNAME = null;
    String test_AKA = null;
    String test_ENGNAME = null;
    String test_ENGNAMESHORT = null;

    String accountName_type_1 = null;
    String aka_type_1 = null;
    String engName_type_1 = null;
    String engNameShort_type_1 = null;

    String accountName_type_2 = null;
    String aka_type_2 = null;
    String engName_type_2 = null;
    String engNameShort_type_2 = null;

    String accountName_type_3 = null;
    String aka_type_3 = null;
    String engName_type_3 = null;
    String engNameShort_type_3 = null;

    // Variables for complianceLicense method
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

    // Variables for complianceGoverningBodies method
    String test_MANAGE_PERSON = null;
    String test_MANAGE_STRUCTURE = null;

    String managePerson_type_1 = null;
    String manageStructure_type_1 = null;

    String managePerson_type_2 = null;
    String manageStructure_type_2 = null;

    String managePerson_type_3 = null;
    String manageStructure_type_3 = null;

    // Variables for complianceOtherChangesInDoc method
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

    WebDriver driver;

    @Test (groups = {"smoke", "regress"},
            retryAnalyzer = Rerty.class)
    public void testAuthorization() {

        System.out.println();
        System.out.println("TEST 8083 IS STARTING...");
        System.out.println();
        System.out.println();
        System.out.println("Test Authorization is starting...");

        try {
            System.setProperty("webdriver.chrome.driver",
                    "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");
            driver =  new ChromeDriver();

            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8083/SlxClient/logoff.aspx");
            driver.manage().window().maximize();

            WebElement logoffHref = driver.findElement(By
                    .linkText("Вернуться на страницу входа"));
            logoffHref.click();

            Thread.sleep(5000);

            // Authorization in system
            WebElement inputUserName = driver.findElement(By
                    .xpath("//input[@name='ctl00$ContentPlaceHolderArea$slxLogin$UserName']"));
            inputUserName.sendKeys(userName);

            WebElement submitButton = driver.findElement(By
                    .xpath("//input[@name='ctl00$ContentPlaceHolderArea$slxLogin$btnLogin']"));
            submitButton.click();


        } catch (InterruptedException e) {
            System.out.println("/TestAuthorization/ test failed");
            e.printStackTrace();
        }
        System.out.println("/TestAuthorization/ test passed");
    }


    @Test (groups = {"smoke", "regress"},
            dependsOnMethods = "testAuthorization",
            retryAnalyzer = Rerty.class)
    public void openDataChangeRequest() {

        System.out.println();
        System.out.println();
        System.out.println("Test open DataChangeRequest is starting...");

        try {

            Thread.sleep(3000);

            // Enter to "Data change requests"
            WebElement requestsHref = driver.findElement(By.xpath("//*[text()='Заявки']"));
            requestsHref.click();

            Thread.sleep(5000);

            // Select UC requests
            WebElement filterUC = driver.findElement(By.xpath("//*[@id='GroupLookupButton']"));
            filterUC.click();

            Thread.sleep(2000);

            WebElement inputNumberOfRequest = driver.findElement(By
                    .xpath("//*[@id='widget_GroupLookup-ConditionManager-SearchCondition0-TextValue']/div/input"));
            inputNumberOfRequest.sendKeys(requestMask);

            WebElement submitSelect = driver.findElement(By
                    .xpath("//*[@id='GroupLookup-ConditionManager-Search_label']"));
            submitSelect.click();
            Thread.sleep(2000);

            // Sort search result
            WebElement sortByModifiedDate = driver.findElement(By.xpath("//*[@id='dojoUnique27']/div"));
            sortByModifiedDate.click();
            Thread.sleep(1000);
            sortByModifiedDate.click();
            Thread.sleep(5000);

            // Open the last application
            //WebElement lastApplication = driver.findElement(By.xpath("//*[@id='listGrid-row-:r6AiXwz1uQM=']/table/tr/td[1]/a"));
            WebElement lastApplication = driver.findElement(By
                    .xpath("//div[@id='dijit_layout_StackContainer_0']//td/a"));
            lastApplication.click();
            Thread.sleep(5000);

            // Get data of the PRODUCTORDERNUMBER
            WebElement field_PRODUCTORDERNUMBER = driver.findElement(By
                    .xpath("//*[@id='PageTitle']"));
            String productOrderNumberFull = field_PRODUCTORDERNUMBER.getText();
            // Отрезать "Заявка - "
            String [] splitString = productOrderNumberFull.split(" ");
            productOrderNumber = splitString[2];
            Thread.sleep(3000);

        } catch (InterruptedException e) {
            System.out.println("/OpenDataChangeRequest/ test failed");
            e.printStackTrace();
        }
        System.out.println("/OpenDataChangeRequest/ test passed");
        System.out.println("---------------");
        System.out.println(productOrderNumber);
    }


    @Test (groups = {"regress"},
            dependsOnMethods = "openDataChangeRequest",
            retryAnalyzer = Rerty.class)
    public void complianceNameOfCompany() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance NameOfCompany is starting...");

        try {

            // Select the Organization Name tab
            WebElement organizationNameTab = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[1]/div/div[1]/a"));
            organizationNameTab.click();
            Thread.sleep(2000);

            // Get data of the Name type
            WebElement field_ACCOUNTNAME = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div//div[1]/div[1]/div/div/textarea"));
            test_ACCOUNTNAME = field_ACCOUNTNAME.getAttribute("value");

            WebElement field_AKA = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div//div[2]/div[1]/div/div/textarea"));
            test_AKA = field_AKA.getAttribute("value");

            WebElement field_ENGNAME = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div//div[3]/div[1]/div/div/textarea"));
            test_ENGNAME = field_ENGNAME.getAttribute("value");

            WebElement field_ENGNAMESHORT = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div//div[4]/div[1]/div/div/textarea"));
            test_ENGNAMESHORT = field_ENGNAMESHORT.getAttribute("value");

        } catch (InterruptedException e) {
            System.out.println("Get web NameOfCompany data failed");
            e.printStackTrace();
        }

        System.out.println("---------------");
        System.out.println(test_ACCOUNTNAME);
        System.out.println(test_AKA);
        System.out.println(test_ENGNAME);
        System.out.println(test_ENGNAMESHORT);
        System.out.println("---------------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_Data, "SYSDBA", "masterkey");

            String selectTableSQLForType_1 = "SELECT fbpomd.ACCOUNTNAME, fbpomd.AKA, fbpomd.ENGNAME, fbpomd.ENGNAMESHORT " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '1'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomd.MEMBERCLASS IS NULL";

            String selectTableSQLForType_2 = "SELECT fbpomd.ACCOUNTNAME, fbpomd.AKA, fbpomd.ENGNAME, fbpomd.ENGNAMESHORT " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '2'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomd.MEMBERCLASS IS NULL";

            String selectTableSQLForType_3 = "SELECT fbpomd.ACCOUNTNAME, fbpomd.AKA, fbpomd.ENGNAME, fbpomd.ENGNAMESHORT " +
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
                accountName_type_1 = rs_1.getString("ACCOUNTNAME");
                aka_type_1 = rs_1.getString("AKA");
                engName_type_1 = rs_1.getString("ENGNAME");
                engNameShort_type_1 = rs_1.getString("ENGNAMESHORT");
            }

            // Get data for type 2 from the database
            ResultSet rs_2 = statement.executeQuery(selectTableSQLForType_2);

            // if something was received then the while loop will work
            while (rs_2.next()) {
                accountName_type_2 = rs_2.getString("ACCOUNTNAME");
                aka_type_2 = rs_2.getString("AKA");
                engName_type_2 = rs_2.getString("ENGNAME");
                engNameShort_type_2 = rs_2.getString("ENGNAMESHORT");
            }

            // Get data for type 3 from the database
            ResultSet rs_3 = statement.executeQuery(selectTableSQLForType_3);

            // if something was received then the while loop will work
            while (rs_3.next()) {
                accountName_type_3 = rs_3.getString("ACCOUNTNAME");
                aka_type_3 = rs_3.getString("AKA");
                engName_type_3 = rs_3.getString("ENGNAME");
                engNameShort_type_3 = rs_3.getString("ENGNAMESHORT");
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Get database NameOfCompany data failed");
            ex.printStackTrace();
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

        System.out.println("----------------------------");

    }

    @Test (groups = {"regress"},
            dependsOnMethods = "complianceNameOfCompany",
            retryAnalyzer = Rerty.class)
    public void complianceLicense() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance License is starting...");

        try {

            Thread.sleep(2000);
            // Select the License tab
            WebElement licenseTab = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[1]/div/div[2]/a"));
            licenseTab.click();
            Thread.sleep(2000);

            // Disclose data on the License - " V "
            WebElement openLicense = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div/div"));
            openLicense.click();
            Thread.sleep(2000);

            // Get data of the License type
            WebElement field_LICENSENUMBER = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div[2]/div[2]/div[1]/div[1]/div/div/textarea"));
            test_LICENSENUMBER = field_LICENSENUMBER.getAttribute("value");

            WebElement field_ACTIVITYKIND = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div/div/div/div/div[1]/input"));
            test_ACTIVITYKIND = field_ACTIVITYKIND.getAttribute("value");

            WebElement field_ISSUEDBY = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div[2]/div[2]/div[3]/div[1]/div/div/textarea"));
            test_ISSUEDBY = field_ISSUEDBY.getAttribute("value");

            WebElement field_ISSUEDATE = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div[2]/div[2]/div[4]/div[1]/div[1]/div/div/div/div/div/div[1]/input"));
            test_ISSUEDATE = field_ISSUEDATE.getAttribute("value");

            WebElement field_EXPIRYDATE = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div[2]/div[2]/div[4]/div[2]/div[1]/div/div/div/div/div/div[1]/input"));
            test_EXPIRYDATE = field_EXPIRYDATE.getAttribute("value");

            WebElement field_ACTIVITYKINDLIST = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div[2]/div[2]/div[5]/div[1]/div/div/textarea"));
            test_ACTIVITYKINDLIST = field_ACTIVITYKINDLIST.getAttribute("value");
        } catch (InterruptedException e) {
            System.out.println("Get web License data failed");
            e.printStackTrace();
        }

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
            Connection connection = DriverManager.getConnection(DB_Data, "SYSDBA", "masterkey");

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
            System.out.println("Get database License data failed");
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

    @Test (groups = {"regress"},
            dependsOnMethods = "complianceLicense",
            retryAnalyzer = Rerty.class)
    public void complianceGoverningBodies() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance GoverningBodies is starting...");

        try {

            // Select the Governing Bodies tab
            WebElement licenseTab = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[1]/div/div[8]/a"));
            licenseTab.click();
            Thread.sleep(2000);

            // Get data of the Governing Bodies type
            WebElement field_MANAGE_PERSON = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[1]/div[1]/div/div/textarea"));
            test_MANAGE_PERSON = field_MANAGE_PERSON.getAttribute("value");

            WebElement field_MANAGE_STRUCTURE = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div[1]/div/div/textarea"));
            test_MANAGE_STRUCTURE = field_MANAGE_STRUCTURE.getAttribute("value");

        } catch (InterruptedException e) {
            System.out.println("Get web GoverningBodies data failed");
            e.printStackTrace();
        }

        System.out.println("---------------");
        System.out.println(test_MANAGE_PERSON);
        System.out.println(test_MANAGE_STRUCTURE);
        System.out.println("---------------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_Data, "SYSDBA", "masterkey");

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
            System.out.println("Get database GoverningBodies data failed");
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

    @Test (groups = {"regress"},
            dependsOnMethods = "complianceGoverningBodies",
            retryAnalyzer = Rerty.class)
    public void complianceOtherChangesInDoc() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance OtherChangesInDoc is starting...");

        try{

            // Select the Other Changes in Doc tab
            WebElement OtherChangesInDoc = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[1]/div/div[9]/a"));
            OtherChangesInDoc.click();
            Thread.sleep(2000);

            // Get data of the Other changes type
            WebElement field_OKFS = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[1]/div[1]/div/div/div/div/div/div[1]/input"));
            test_OKFS = field_OKFS.getAttribute("value");

            WebElement field_COMPANYTYPE = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div[1]/div/div/div/div/div/div[1]/input"));
            test_COMPANYTYPE = field_COMPANYTYPE.getAttribute("value");

            WebElement field_OKOPF = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[3]/div[1]/div/div/div/div/div/div[1]/input"));
            test_OKOPF = field_OKOPF.getAttribute("value");

            WebElement field_CAPITALANNOUNCEDSUM = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[4]/div[1]/div/div/textarea"));
            test_CAPITALANNOUNCEDSUM = field_CAPITALANNOUNCEDSUM.getAttribute("value");

            WebElement field_CAPITALCURRENCY = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[5]/div[1]/div/div/div/div/div/div[1]/input"));
            test_CAPITALCURRENCY = field_CAPITALCURRENCY.getAttribute("value");

        } catch (InterruptedException e) {
            System.out.println("Get web Other Changes data failed");
            e.printStackTrace();
        }

        System.out.println("----------------");
        System.out.println(test_OKFS);
        System.out.println(test_COMPANYTYPE);
        System.out.println(test_OKOPF);
        System.out.println(test_CAPITALANNOUNCEDSUM);
        System.out.println(test_CAPITALCURRENCY);
        System.out.println("----------------");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_Data, "SYSDBA", "masterkey");

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
            System.out.println("Get database Other Changes data failed");
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
            System.out.println("OKCOMPANYTYPEFS test failed! - X");
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