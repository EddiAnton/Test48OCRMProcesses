package Tests_8092;

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

@Test
public class TestComplianceWEB_DBData {

    final String DB_Data = "jdbc:oracle:thin:@server:1521:slx10";

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

    // Variables for complianceAddressesOfCompany method
    String test_OKATO = null;
    String test_OKTMO = null;
    String test_ADDRESSTYPE = null;
    String test_COUNTRY = null;
    String test_POSTALCODE = null;
    String test_COUNTY = null;
    String test_DISTRICT = null;
    String test_CITY = null;
    String test_STREET = null;
    String test_HOUSE = null;
    String test_CORPUS = null;
    String test_APARTMENT = null;
    String test_FULLADDRESS = null;

    String okato_type_1 = null;
    String oktmo_type_1 = null;
    String addresstype_type_1 = null;
    String country_type_1 = null;
    String postalcode_type_1 = null;
    String county_type_1 = null;
    String district_type_1 = null;
    String city_type_1 = null;
    String street_type_1 = null;
    String house_type_1 = null;
    String corpus_type_1 = null;
    String apartment_type_1 = null;
    String fulladdress_type_1 = null;

    String okato_type_2 = null;
    String oktmo_type_2 = null;
    String addresstype_type_2 = null;
    String country_type_2 = null;
    String postalcode_type_2 = null;
    String county_type_2 = null;
    String district_type_2 = null;
    String city_type_2 = null;
    String street_type_2 = null;
    String house_type_2 = null;
    String corpus_type_2 = null;
    String apartment_type_2 = null;
    String fulladdress_type_2 = null;

    String okato_type_3 = null;
    String oktmo_type_3 = null;
    String addresstype_type_3 = null;
    String country_type_3 = null;
    String postalcode_type_3 = null;
    String county_type_3 = null;
    String district_type_3 = null;
    String city_type_3 = null;
    String street_type_3 = null;
    String house_type_3 = null;
    String corpus_type_3 = null;
    String apartment_type_3 = null;
    String fulladdress_type_3 = null;

    // Variables for complianceRelatedPrivatEntities method
    String test_LASTNAME = null;
    String test_FIRSTNAME = null;
    String test_MIDDLENAME = null;
    String test_BIRTHPLACE = null;
    String test_BIRTHDATE = null;
    String test_GENDER = null;
    String test_INN = null;
    String test_CITIZENSHIP = null;

    String lastName_type_1 = null;
    String firstName_type_1 = null;
    String middleName_type_1 = null;
    String birthPlace_type_1 = null;
    String birthDate_type_1 = null;
    String gender_type_1 = null;
    String inn_type_1 = null;
    String citizenship_type_1 = null;

    String lastName_type_2 = null;
    String firstName_type_2 = null;
    String middleName_type_2 = null;
    String birthPlace_type_2 = null;
    String birthDate_type_2 = null;
    String gender_type_2 = null;
    String inn_type_2 = null;
    String citizenship_type_2 = null;

    String lastName_type_3 = null;
    String firstName_type_3 = null;
    String middleName_type_3 = null;
    String birthPlace_type_3 = null;
    String birthDate_type_3 = null;
    String gender_type_3 = null;
    String inn_type_3 = null;
    String citizenship_type_3 = null;

    // Variables for complianceContacts method
    String test_CHANNEL_TYPE = null;
    String test_CHANNEL_VALUE = null;
    String test_CHANNEL_SUBTYPE = null;
    String test_ISACTIVE = null;
    String test_ISPRIMARY = null;
    String test_NOTE = null;

    String codeChannelType_type_1 = null;
    String channelType_type_1 = null;
    String channelValue_type_1 = null;
    int codeChannelSubtype_type_1;
    String channelSubtype_type_1 = null;
    String isActiveContact_type_1 = null;
    String isPrimaryContact_type_1 = null;
    String noteContact_type_1 = null;

    String codeChannelType_type_2 = null;
    String channelType_type_2 = null;
    String channelValue_type_2 = null;
    int codeChannelSubtype_type_2;
    String channelSubtype_type_2 = null;
    String isActiveContact_type_2 = null;
    String isPrimaryContact_type_2 = null;
    String noteContact_type_2 = null;

    String codeChannelType_type_3 = null;
    String channelType_type_3 = null;
    String channelValue_type_3 = null;
    int codeChannelSubtype_type_3;
    String channelSubtype_type_3 = null;
    String isActiveContact_type_3 = null;
    String isPrimaryContact_type_3 = null;
    String noteContact_type_3 = null;

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
        System.out.println("TEST 8092 IS STARTING...");
        System.out.println();
        System.out.println();
        System.out.println("Test Authorization is starting...");

        try {
            System.setProperty("webdriver.chrome.driver",
                    "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");
            driver =  new ChromeDriver();

            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8092/SlxClient/logoff.aspx");
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

        try {

            System.out.println();
            System.out.println();
            System.out.println("Test open DataChangeRequest is starting...");

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
            WebElement sortByModifiedDate = driver.findElement(By.xpath("//*[@id='dojoUnique22']"));
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
    public void complianceAddressesOfCompany() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance Addresses Of Company is starting...");

        try {

            // Select the Address tab
            WebElement addressTab = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[1]/div/div[3]/a"));
            addressTab.click();
            Thread.sleep(2000);

            // Get data OKATO & OKTMO
            WebElement field_OKATO = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[1]/div[1]/div[1]/div/div/textarea"));
            test_OKATO = field_OKATO.getAttribute("value");

            WebElement field_OKTMO = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[1]/div[2]/div[1]/div/div/textarea"));
            test_OKTMO = field_OKTMO.getAttribute("value");

            // Disclose data on the Address - " V "
            WebElement openAddress = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div/div[1]/div/div/i"));
            openAddress.click();
            Thread.sleep(3000);

            // Get data of the Address type
            WebElement field_ADDRESSTYPE = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div/div[1]/div[2]/div[2]/div[1]/div/div/div/div/div/div[1]/input"));
            test_ADDRESSTYPE = field_ADDRESSTYPE.getAttribute("value");

            WebElement field_COUNTRY = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div/div[1]/div[2]/div[2]/div[3]/div/div/div/div/div/div/input"));
            test_COUNTRY = field_COUNTRY.getAttribute("value");

            WebElement field_POSTALCODE = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div/div[1]/div[2]/div[2]/div[5]/div/div/textarea"));
            test_POSTALCODE = field_POSTALCODE.getAttribute("value");

            WebElement field_COUNTY = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div/div[1]/div[2]/div[2]/div[7]/div/div/div/div/div/div/input"));
            test_COUNTY = field_COUNTY.getAttribute("value");

            WebElement field_DISTRICT = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div/div[1]/div[2]/div[2]/div[9]/div/div/div/div/div/div/input"));
            test_DISTRICT = field_DISTRICT.getAttribute("value");

            WebElement field_CITY = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div/div[1]/div[2]/div[2]/div[11]/div/div/div/div/div/div/input"));
            test_CITY = field_CITY.getAttribute("value");

            WebElement field_STREET = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div/div[1]/div[2]/div[2]/div[13]/div/div/div/div/div/div/input"));
            test_STREET = field_STREET.getAttribute("value");

            WebElement field_HOUSE = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div/div[1]/div[2]/div[2]/div[15]/div/div/div[1]/div/div/div/div/input"));
            test_HOUSE = field_HOUSE.getAttribute("value");

            WebElement field_CORPUS = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div/div[1]/div[2]/div[2]/div[15]/div/div/div[2]/textarea"));
            test_CORPUS = field_CORPUS.getAttribute("value");

            WebElement field_APARTMENT = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div/div[1]/div[2]/div[2]/div[17]/div/div/textarea"));
            test_APARTMENT = field_APARTMENT.getAttribute("value");

            WebElement field_FULLADDRESS = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div/div[1]/div[2]/div[2]/div[19]/div/div/textarea"));
            test_FULLADDRESS = field_FULLADDRESS.getAttribute("value");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---------------");
        System.out.println(test_OKATO);
        System.out.println(test_OKTMO);
        System.out.println(test_ADDRESSTYPE);
        System.out.println(test_COUNTRY);
        System.out.println(test_POSTALCODE);
        System.out.println(test_COUNTY);
        System.out.println(test_DISTRICT);
        System.out.println(test_CITY);
        System.out.println(test_STREET);
        System.out.println(test_HOUSE);
        System.out.println(test_CORPUS);
        System.out.println(test_APARTMENT);
        System.out.println(test_FULLADDRESS);
        System.out.println("---------------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_Data, "SYSDBA", "masterkey");

            Statement statement = connection.createStatement();

            String selectCodeAddressTypeSQL = "select pl.shorttext " +
                    "from picklist pl " +
                    "inner join picklist pln " +
                    "on pln.itemid = pl.picklistid " +
                    "and pln.picklistid = 'PICKLISTLIST' " +
                    "where pln.text = 'Тип адреса' " +
                    "and pl.TEXT = '" + test_ADDRESSTYPE + "'";

            String codeAddressType = null;
            ResultSet rs_cat = statement.executeQuery(selectCodeAddressTypeSQL);
            while (rs_cat.next()) {
                codeAddressType = rs_cat.getString("SHORTTEXT");
            }

            String selectTableSQLForType_1 = "SELECT fbpomd.OKATO, " +
                    "fbpomd.OKTMO, " +
                    "fbpomad.ADDRESSTYPE, " +
                    "fbpomad.COUNTRY, " +
                    "fbpomad.POSTALCODE, " +
                    "fbpomad.COUNTY, " +
                    "fbpomad.DISTRICT, " +
                    "fbpomad.CITY, " +
                    "fbpomad.STREET, " +
                    "fbpomad.HOUSE, " +
                    "fbpomad.CORPUS, " +
                    "fbpomad.APARTMENT, " +
                    "fbpomad.FULLADDRESS " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_ADDR fbpomad " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpomad.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '1'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomad.ADDRESSTYPE = '" + codeAddressType + "'";

            String selectTableSQLForType_2 = "SELECT fbpomd.OKATO, " +
                    "fbpomd.OKTMO, " +
                    "fbpomad.ADDRESSTYPE, " +
                    "fbpomad.COUNTRY, " +
                    "fbpomad.POSTALCODE, " +
                    "fbpomad.COUNTY, " +
                    "fbpomad.DISTRICT, " +
                    "fbpomad.CITY, " +
                    "fbpomad.STREET, " +
                    "fbpomad.HOUSE, " +
                    "fbpomad.CORPUS, " +
                    "fbpomad.APARTMENT, " +
                    "fbpomad.FULLADDRESS " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_ADDR fbpomad " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpomad.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '2'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomad.ADDRESSTYPE = '" + codeAddressType + "'";

            String selectTableSQLForType_3 = "SELECT fbpomd.OKATO, " +
                    "fbpomd.OKTMO, " +
                    "fbpomad.ADDRESSTYPE, " +
                    "fbpomad.COUNTRY, " +
                    "fbpomad.POSTALCODE, " +
                    "fbpomad.COUNTY, " +
                    "fbpomad.DISTRICT, " +
                    "fbpomad.CITY, " +
                    "fbpomad.STREET, " +
                    "fbpomad.HOUSE, " +
                    "fbpomad.CORPUS, " +
                    "fbpomad.APARTMENT, " +
                    "fbpomad.FULLADDRESS " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_ADDR fbpomad " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpomad.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '3'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomad.ADDRESSTYPE = '" + codeAddressType + "'";

            // Get data for type 1 from the database
            ResultSet rs_1 = statement.executeQuery(selectTableSQLForType_1);

            // if something was received then the while loop will work
            while (rs_1.next()) {
                okato_type_1 = rs_1.getString("OKATO");
                oktmo_type_1 = rs_1.getString("OKTMO");
                addresstype_type_1 = rs_1.getString("ADDRESSTYPE");
                country_type_1 = rs_1.getString("COUNTRY");
                postalcode_type_1 = rs_1.getString("POSTALCODE");
                county_type_1 = rs_1.getString("COUNTY");
                district_type_1 = rs_1.getString("DISTRICT");
                city_type_1 = rs_1.getString("CITY");
                street_type_1 = rs_1.getString("STREET");
                house_type_1 = rs_1.getString("HOUSE");
                corpus_type_1 = rs_1.getString("CORPUS");
                apartment_type_1 = rs_1.getString("APARTMENT");
                fulladdress_type_1 = rs_1.getString("FULLADDRESS");
            }

            // Get data for type 2 from the database
            ResultSet rs_2 = statement.executeQuery(selectTableSQLForType_2);

            // if something was received then the while loop will work
            while (rs_2.next()) {
                okato_type_2 = rs_2.getString("OKATO");
                oktmo_type_2 = rs_2.getString("OKTMO");
                addresstype_type_2 = rs_2.getString("ADDRESSTYPE");
                country_type_2 = rs_2.getString("COUNTRY");
                postalcode_type_2 = rs_2.getString("POSTALCODE");
                county_type_2 = rs_2.getString("COUNTY");
                district_type_2 = rs_2.getString("DISTRICT");
                city_type_2 = rs_2.getString("CITY");
                street_type_2 = rs_2.getString("STREET");
                house_type_2 = rs_2.getString("HOUSE");
                corpus_type_2 = rs_2.getString("CORPUS");
                apartment_type_2 = rs_2.getString("APARTMENT");
                fulladdress_type_2 = rs_2.getString("FULLADDRESS");
            }

            // Get data for type 3 from the database
            ResultSet rs_3 = statement.executeQuery(selectTableSQLForType_3);

            // if something was received then the while loop will work
            while (rs_3.next()) {
                okato_type_3 = rs_3.getString("OKATO");
                oktmo_type_3 = rs_3.getString("OKTMO");
                addresstype_type_3 = rs_3.getString("ADDRESSTYPE");
                country_type_3 = rs_3.getString("COUNTRY");
                postalcode_type_3 = rs_3.getString("POSTALCODE");
                county_type_3 = rs_3.getString("COUNTY");
                district_type_3 = rs_3.getString("DISTRICT");
                city_type_3 = rs_3.getString("CITY");
                street_type_3 = rs_3.getString("STREET");
                house_type_3 = rs_3.getString("HOUSE");
                corpus_type_3 = rs_3.getString("CORPUS");
                apartment_type_3 = rs_3.getString("APARTMENT");
                fulladdress_type_3 = rs_3.getString("FULLADDRESS");
            }

            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
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

        if(Objects.equals(test_ADDRESSTYPE, DataComparison.compareData(addresstype_type_1, addresstype_type_2, addresstype_type_3))) {
            System.out.println("ADDRESSTYPE test passed!");
        }else {
            System.out.println("ADDRESSTYPE test failed! - X");
        }

        if(Objects.equals(test_COUNTRY, DataComparison.compareData(country_type_1, country_type_2, country_type_3))) {
            System.out.println("COUNTRY test passed!");
        }else {
            System.out.println("COUNTRY test failed! - X");
        }

        if(Objects.equals(test_POSTALCODE, DataComparison.compareData(postalcode_type_1, postalcode_type_2, postalcode_type_3))) {
            System.out.println("POSTALCODE test passed!");
        }else {
            System.out.println("POSTALCODE test failed! - X");
        }

        if(Objects.equals(test_COUNTY, DataComparison.compareData(county_type_1, county_type_2, county_type_3))) {
            System.out.println("COUNTY test passed!");
        }else {
            System.out.println("COUNTY test failed! - X");
        }

        if(Objects.equals(test_DISTRICT, DataComparison.compareData(district_type_1, district_type_2, district_type_3))) {
            System.out.println("DISTRICT test passed!");
        }else {
            System.out.println("DISTRICT test failed! - X");
        }

        if(Objects.equals(test_CITY, DataComparison.compareData(city_type_1, city_type_2, city_type_3))) {
            System.out.println("CITY test passed!");
        }else {
            System.out.println("CITY test failed! - X");
        }

        if(Objects.equals(test_STREET, DataComparison.compareData(street_type_1, street_type_2, street_type_3))) {
            System.out.println("STREET test passed!");
        }else {
            System.out.println("STREET test failed! - X");
        }

        if(Objects.equals(test_HOUSE, DataComparison.compareData(house_type_1, house_type_2, house_type_3))) {
            System.out.println("HOUSE test passed!");
        }else {
            System.out.println("HOUSE test failed! - X");
        }

        if(Objects.equals(test_CORPUS, DataComparison.compareData(corpus_type_1, corpus_type_2, corpus_type_3))) {
            System.out.println("CORPUS test passed!");
        }else {
            System.out.println("CORPUS test failed! - X");
        }

        if(Objects.equals(test_APARTMENT, DataComparison.compareData(apartment_type_1, apartment_type_2, apartment_type_3))) {
            System.out.println("APARTMENT test passed!");
        }else {
            System.out.println("APARTMENT test failed! - X");
        }

        if(Objects.equals(test_FULLADDRESS, DataComparison.compareData(fulladdress_type_1, fulladdress_type_2, fulladdress_type_3))) {
            System.out.println("FULLADDRESS test passed!");
        }else {
            System.out.println("FULLADDRESS test failed! - X");
        }

        System.out.println("----------------------------");

    }


    @Test (groups = {"regress"},
            dependsOnMethods = "complianceAddressesOfCompany",
            retryAnalyzer = Rerty.class)
    public void complianceRelatedPrivatEntities() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance Related Privat Entities is starting...");

        try {

            // Select the Related Privat Entities tab
            WebElement relatedPrivatEntitiesTab = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[1]/div/div[4]/a"));
            relatedPrivatEntitiesTab.click();
            Thread.sleep(2000);

            // Disclose data on the Related Privat Entities - " V "
            WebElement openrelatedPrivatEntities = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div/div/i"));
            openrelatedPrivatEntities.click();
            Thread.sleep(3000);

            // Get data of the Related Privat Entities type
            WebElement field_LASTNAME = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div[2]/div[2]/div[1]/div[1]/div/div/textarea"));
            test_LASTNAME = field_LASTNAME.getAttribute("value");

            WebElement field_FIRSTNAME = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div[2]/div[2]/div[2]/div[1]/div/div/textarea"));
            test_FIRSTNAME = field_FIRSTNAME.getAttribute("value");

            WebElement field_MIDDLENAME = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div[2]/div[2]/div[3]/div[1]/div/div/textarea"));
            test_MIDDLENAME = field_MIDDLENAME.getAttribute("value");

            WebElement field_BIRTHPLACE = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div[2]/div[2]/div[4]/div[1]/div/div/div/div/div/div/input"));
            test_BIRTHPLACE = field_BIRTHPLACE.getAttribute("value");

            WebElement field_BIRTHDATE = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div[2]/div[2]/div[5]/div[1]/div/div/div/div/div/div[1]/input"));
            test_BIRTHDATE = field_BIRTHDATE.getAttribute("value");

            WebElement field_GENDER = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div[2]/div[2]/div[6]/div[1]/div/div/div/div/div/div[1]/input"));
            test_GENDER = field_GENDER.getAttribute("value");

            WebElement field_INN = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div[2]/div[2]/div[7]/div[1]/div/div/textarea"));
            test_INN = field_INN.getAttribute("value");

            WebElement field_CITIZENSHIP = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div/div[2]/div[2]/div[8]/div[1]/div/div/div/div/div/div[1]/input"));
            test_CITIZENSHIP = field_CITIZENSHIP.getAttribute("value");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---------------");
        System.out.println(test_LASTNAME);
        System.out.println(test_FIRSTNAME);
        System.out.println(test_MIDDLENAME);
        System.out.println(test_BIRTHPLACE);
        System.out.println(test_BIRTHDATE);
        System.out.println(test_GENDER);
        System.out.println(test_INN);
        System.out.println(test_CITIZENSHIP);
        System.out.println("---------------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_Data, "SYSDBA", "masterkey");

            String selectTableSQLForType_1 = "SELECT fbpomd.LASTNAME, " +
                    "fbpomd.FIRSTNAME, " +
                    "fbpomd.MIDDLENAME, " +
                    "fbpomd.BIRTHPLACE, " +
                    "fbpomd.BIRTHDATE, " +
                    "fbpomd.GENDER, " +
                    "fbpomd.INN, " +
                    "fbpomd.COUNTRY " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.isprimary = 'F' " +
                    "AND fbpomd.memberclass = 'CL_PRIV' " +
                    "AND fbpomd.INN = '" + test_INN + "' " +
                    "AND fbpomd.memberdatatype = '1'";

            String selectTableSQLForType_2 = "SELECT fbpomd.LASTNAME, " +
                    "fbpomd.FIRSTNAME, " +
                    "fbpomd.MIDDLENAME, " +
                    "fbpomd.BIRTHPLACE, " +
                    "fbpomd.BIRTHDATE, " +
                    "fbpomd.GENDER, " +
                    "fbpomd.INN, " +
                    "fbpomd.COUNTRY " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.isprimary = 'F' " +
                    "AND fbpomd.memberclass = 'CL_PRIV' " +
                    "AND fbpomd.INN = '" + test_INN + "' " +
                    "AND fbpomd.memberdatatype = '2'";

            String selectTableSQLForType_3 = "SELECT fbpomd.LASTNAME, " +
                    "fbpomd.FIRSTNAME, " +
                    "fbpomd.MIDDLENAME, " +
                    "fbpomd.BIRTHPLACE, " +
                    "fbpomd.BIRTHDATE, " +
                    "fbpomd.GENDER, " +
                    "fbpomd.INN, " +
                    "fbpomd.COUNTRY " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.isprimary = 'F' " +
                    "AND fbpomd.memberclass = 'CL_PRIV' " +
                    "AND fbpomd.INN = '" + test_INN + "' " +
                    "AND fbpomd.memberdatatype = '3'";

            Statement statement = connection.createStatement();

            // Get data for type 1 from the database
            ResultSet rs_1 = statement.executeQuery(selectTableSQLForType_1);

            // if something was received then the while loop will work
            while (rs_1.next()) {
                lastName_type_1 = rs_1.getString("LASTNAME");
                firstName_type_1 = rs_1.getString("FIRSTNAME");
                middleName_type_1 = rs_1.getString("MIDDLENAME");
                birthPlace_type_1 = rs_1.getString("BIRTHPLACE");
                birthDate_type_1 = DateReplace.replaceInputDate(rs_1.getString("BIRTHDATE"));
                gender_type_1 = rs_1.getString("GENDER");
                inn_type_1 = rs_1.getString("INN");
                citizenship_type_1 = rs_1.getString("COUNTRY");
            }

            // Get data for type 2 from the database
            ResultSet rs_2 = statement.executeQuery(selectTableSQLForType_2);

            // if something was received then the while loop will work
            while (rs_2.next()) {
                lastName_type_2 = rs_2.getString("LASTNAME");
                firstName_type_2 = rs_2.getString("FIRSTNAME");
                middleName_type_2 = rs_2.getString("MIDDLENAME");
                birthPlace_type_2 = rs_2.getString("BIRTHPLACE");
                birthDate_type_2 = DateReplace.replaceInputDate(rs_2.getString("BIRTHDATE"));
                gender_type_2 = rs_2.getString("GENDER");
                inn_type_2 = rs_2.getString("INN");
                citizenship_type_2 = rs_2.getString("COUNTRY");
            }

            // Get data for type 3 from the database
            ResultSet rs_3 = statement.executeQuery(selectTableSQLForType_3);

            // if something was received then the while loop will work
            while (rs_3.next()) {
                lastName_type_3 = rs_3.getString("LASTNAME");
                firstName_type_3 = rs_3.getString("FIRSTNAME");
                middleName_type_3 = rs_3.getString("MIDDLENAME");
                birthPlace_type_3 = rs_3.getString("BIRTHPLACE");
                birthDate_type_3 = DateReplace.replaceInputDate(rs_3.getString("BIRTHDATE"));
                gender_type_3 = rs_3.getString("GENDER");
                inn_type_3 = rs_3.getString("INN");
                citizenship_type_3 = rs_3.getString("COUNTRY");
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        if(Objects.equals(test_LASTNAME, DataComparison.compareData(lastName_type_1, lastName_type_2, lastName_type_3))) {
            System.out.println("LASTNAME test passed!");
        }else {
            System.out.println("LASTNAME test failed! - X");
        }

        if(Objects.equals(test_FIRSTNAME, DataComparison.compareData(firstName_type_1, firstName_type_2, firstName_type_3))) {
            System.out.println("FIRSTNAME test passed!");
        }else {
            System.out.println("FIRSTNAME test failed! - X");
        }

        if(Objects.equals(test_MIDDLENAME, DataComparison.compareData(middleName_type_1, middleName_type_2, middleName_type_3))) {
            System.out.println("MIDDLENAME test passed!");
        }else {
            System.out.println("MIDDLENAME test failed! - X");
        }

        if(Objects.equals(test_BIRTHPLACE, DataComparison.compareData(birthPlace_type_1, birthPlace_type_2, birthPlace_type_3))) {
            System.out.println("BIRTHPLACE test passed!");
        }else {
            System.out.println("BIRTHPLACE test failed! - X");
        }

        if(Objects.equals(test_BIRTHDATE, DataComparison.compareData(birthDate_type_1, birthDate_type_2, birthDate_type_3))) {
            System.out.println("BIRTHDATE test passed!");
        }else {
            System.out.println("BIRTHDATE test failed! - X");
        }

        if(Objects.equals(test_GENDER, DataComparison.compareData(gender_type_1, gender_type_2, gender_type_3))) {
            System.out.println("GENDER test passed!");
        }else {
            System.out.println("GENDER test failed! - X");
        }

        if(Objects.equals(test_INN, DataComparison.compareData(inn_type_1, inn_type_2, inn_type_3))) {
            System.out.println("INN test passed!");
        }else {
            System.out.println("INN test failed! - X");
        }

        if(Objects.equals(test_CITIZENSHIP, DataComparison.compareData(citizenship_type_1, citizenship_type_2, citizenship_type_3))) {
            System.out.println("COUNTRY test passed!");
        }else {
            System.out.println("COUNTRY test failed! - X");
        }

        System.out.println("----------------------------");

    }


    @Test (groups = {"regress"},
            dependsOnMethods = "complianceRelatedPrivatEntities",
            retryAnalyzer = Rerty.class)
    public void complianceContacts() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance Contacts is starting...");

        try {
            // Select the Contacts tab
            WebElement contactsTab = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[1]/div/div[7]/a"));
            contactsTab.click();
            Thread.sleep(2000);

            // Disclose data on the Contact - " V "
            WebElement openContact = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div[2]/div[1]/div/div/i"));
            openContact.click();
            Thread.sleep(3000);

            // Get data of the Contact type
            WebElement field_CHANNEL_TYPE = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div[2]/div[1]/div[2]/div[2]/div[1]/div[1]/div/div/div/div/div/div[1]/input"));
            test_CHANNEL_TYPE = field_CHANNEL_TYPE.getAttribute("value");

            WebElement field_CHANNEL_VALUE = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div/textarea"));
            test_CHANNEL_VALUE = field_CHANNEL_VALUE.getAttribute("value");

            WebElement field_CHANNEL_SUBTYPE = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div[2]/div[1]/div[2]/div[2]/div[3]/div[1]/div/div/div/div/div/div[1]/input"));
            test_CHANNEL_SUBTYPE = field_CHANNEL_SUBTYPE.getAttribute("value");

            WebElement field_ISACTIVE = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div[2]/div[1]/div[2]/div[2]/div[4]/div[1]/div/div/div/div/input"));
            test_ISACTIVE = field_ISACTIVE.getAttribute("value");

            WebElement field_ISPRIMARY = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div[2]/div[1]/div[2]/div[2]/div[5]/div[1]/div/div/div/div/input"));
            test_ISPRIMARY = field_ISPRIMARY.getAttribute("value");

            WebElement field_NOTE = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div[2]/div[1]/div[2]/div[2]/div[6]/div[1]/div/div/textarea"));
            test_NOTE = field_NOTE.getAttribute("value");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---------------");
        System.out.println(test_CHANNEL_TYPE);
        System.out.println(test_CHANNEL_VALUE);
        System.out.println(test_CHANNEL_SUBTYPE);
        System.out.println(test_ISACTIVE);
        System.out.println(test_ISPRIMARY);
        System.out.println(test_NOTE);
        System.out.println("---------------");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_Data, "SYSDBA", "masterkey");

            Statement statement = connection.createStatement();

            String selectTableSQLForType_1 = "SELECT fbpomcont.CHANNEL_TYPE, " +
                    "fbpomcont.CHANNEL_VALUE, " +
                    "fbpomcont.CHANNEL_SUBTYPE, " +
                    "fbpomcont.ISACTIVE, " +
                    "fbpomcont.ISPRIMARY, " +
                    "fbpomcont.NOTE " +
                    "FROM sysdba.fb_productordmemb_cont fbpomcont " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpomcont.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "' " +
                    "AND fbpomd.MEMBERDATATYPE = '1' " +
                    "AND fbpomd.ISPRIMARY = 'T' " +
                    "AND fbpomcont.CHANNEL_VALUE = '" + test_CHANNEL_VALUE + "'";

            String selectTableSQLForType_2 = "SELECT fbpomcont.CHANNEL_TYPE, " +
                    "fbpomcont.CHANNEL_VALUE, " +
                    "fbpomcont.CHANNEL_SUBTYPE, " +
                    "fbpomcont.ISACTIVE, " +
                    "fbpomcont.ISPRIMARY, " +
                    "fbpomcont.NOTE " +
                    "FROM sysdba.fb_productordmemb_cont fbpomcont " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpomcont.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "' " +
                    "AND fbpomd.MEMBERDATATYPE = '2' " +
                    "AND fbpomd.ISPRIMARY = 'T' " +
                    "AND fbpomcont.CHANNEL_VALUE = '" + test_CHANNEL_VALUE + "'";

            String selectTableSQLForType_3 = "SELECT fbpomcont.CHANNEL_TYPE, " +
                    "fbpomcont.CHANNEL_VALUE, " +
                    "fbpomcont.CHANNEL_SUBTYPE, " +
                    "fbpomcont.ISACTIVE, " +
                    "fbpomcont.ISPRIMARY, " +
                    "fbpomcont.NOTE " +
                    "FROM sysdba.fb_productordmemb_cont fbpomcont " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpomcont.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "' " +
                    "AND fbpomd.MEMBERDATATYPE = '3' " +
                    "AND fbpomd.ISPRIMARY = 'T' " +
                    "AND fbpomcont.CHANNEL_VALUE = '" + test_CHANNEL_VALUE + "'";

            // Get data for type 1 from the database
            ResultSet rs_1 = statement.executeQuery(selectTableSQLForType_1);

            // if something was received then the while loop will work
            while (rs_1.next()) {
                codeChannelType_type_1 = rs_1.getString("CHANNEL_TYPE");
                channelValue_type_1 = rs_1.getString("CHANNEL_VALUE");
                codeChannelSubtype_type_1 = rs_1.getInt("CHANNEL_SUBTYPE");
                isActiveContact_type_1 = DataConversion.booleanConversion(rs_1.getString("ISACTIVE"));
                isPrimaryContact_type_1 = DataConversion.booleanConversion(rs_1.getString("ISPRIMARY"));
                noteContact_type_1 = rs_1.getString("NOTE");
            }

            String selectCodeContactTypeSQL_1 = "select pl.text " +
                    "from picklist pl " +
                    "inner join picklist pln " +
                    "on pln.itemid = pl.picklistid " +
                    "and pln.picklistid = 'PICKLISTLIST' " +
                    "where pln.text = 'Тип контакта' " +
                    "and pl.SHORTTEXT = '" + codeChannelType_type_1 + "'";


            ResultSet rs_cct_1 = statement.executeQuery(selectCodeContactTypeSQL_1);
            while (rs_cct_1.next()) {
                channelType_type_1 = rs_cct_1.getString("TEXT");
            }

            String selectCodeContactSubTypeSQL_1 = "select pl.text " +
                    "from picklist pl " +
                    "inner join picklist pln " +
                    "on pln.itemid = pl.picklistid " +
                    "and pln.picklistid = 'PICKLISTLIST' " +
                    "where pln.text = 'Принадлежность' " +
                    "and pl.SHORTTEXT = '" + codeChannelSubtype_type_1 + "'";


            ResultSet rs_ccst_1 = statement.executeQuery(selectCodeContactSubTypeSQL_1);
            while (rs_ccst_1.next()) {
                channelSubtype_type_1 = CheckData.checkContactChanelSubtype(rs_ccst_1.getString("TEXT"));
            }

            // Get data for type 2 from the database
            ResultSet rs_2 = statement.executeQuery(selectTableSQLForType_2);

            // if something was received then the while loop will work
            while (rs_2.next()) {
                channelType_type_2 = rs_2.getString("CHANNEL_TYPE");
                channelValue_type_2 = rs_2.getString("CHANNEL_VALUE");
                codeChannelSubtype_type_2 = rs_2.getInt("CHANNEL_SUBTYPE");
                isActiveContact_type_2 = DataConversion.booleanConversion(rs_2.getString("ISACTIVE"));
                isPrimaryContact_type_2 = DataConversion.booleanConversion(rs_2.getString("ISPRIMARY"));
                noteContact_type_2 = rs_2.getString("NOTE");
            }

            String selectCodeContactTypeSQL_2 = "select pl.text " +
                    "from picklist pl " +
                    "inner join picklist pln " +
                    "on pln.itemid = pl.picklistid " +
                    "and pln.picklistid = 'PICKLISTLIST' " +
                    "where pln.text = 'Тип контакта' " +
                    "and pl.SHORTTEXT = '" + codeChannelType_type_2 + "'";


            ResultSet rs_cct_2 = statement.executeQuery(selectCodeContactTypeSQL_2);
            while (rs_cct_2.next()) {
                channelType_type_2 = rs_cct_2.getString("TEXT");
            }

            String selectCodeContactSubTypeSQL_2 = "select pl.text " +
                    "from picklist pl " +
                    "inner join picklist pln " +
                    "on pln.itemid = pl.picklistid " +
                    "and pln.picklistid = 'PICKLISTLIST' " +
                    "where pln.text = 'Принадлежность' " +
                    "and pl.SHORTTEXT = '" + codeChannelSubtype_type_2 + "'";


            ResultSet rs_ccst_2 = statement.executeQuery(selectCodeContactSubTypeSQL_2);
            while (rs_ccst_2.next()) {
                channelSubtype_type_2 = CheckData.checkContactChanelSubtype(rs_ccst_2.getString("TEXT"));
            }

            // Get data for type 3 from the database
            ResultSet rs_3 = statement.executeQuery(selectTableSQLForType_3);

            // if something was received then the while loop will work
            while (rs_3.next()) {
                channelType_type_3 = rs_3.getString("CHANNEL_TYPE");
                channelValue_type_3 = rs_3.getString("CHANNEL_VALUE");
                codeChannelSubtype_type_3 = rs_3.getInt("CHANNEL_SUBTYPE");
                isActiveContact_type_3 = DataConversion.booleanConversion(rs_3.getString("ISACTIVE"));
                isPrimaryContact_type_3 = DataConversion.booleanConversion(rs_3.getString("ISPRIMARY"));
                noteContact_type_3 = rs_3.getString("NOTE");
            }

            String selectCodeContactTypeSQL_3 = "select pl.text " +
                    "from picklist pl " +
                    "inner join picklist pln " +
                    "on pln.itemid = pl.picklistid " +
                    "and pln.picklistid = 'PICKLISTLIST' " +
                    "where pln.text = 'Тип контакта' " +
                    "and pl.SHORTTEXT = '" + codeChannelType_type_3 + "'";


            ResultSet rs_cct_3 = statement.executeQuery(selectCodeContactTypeSQL_3);
            while (rs_cct_3.next()) {
                channelType_type_3 = rs_cct_3.getString("TEXT");
            }

            String selectCodeContactSubTypeSQL_3 = "select pl.text " +
                    "from picklist pl " +
                    "inner join picklist pln " +
                    "on pln.itemid = pl.picklistid " +
                    "and pln.picklistid = 'PICKLISTLIST' " +
                    "where pln.text = 'Принадлежность' " +
                    "and pl.SHORTTEXT = '" + codeChannelSubtype_type_3 + "'";


            ResultSet rs_ccst_3 = statement.executeQuery(selectCodeContactSubTypeSQL_3);
            while (rs_ccst_3.next()) {
                channelSubtype_type_3 = CheckData.checkContactChanelSubtype(rs_ccst_3.getString("TEXT"));
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        if(Objects.equals(test_CHANNEL_TYPE, DataComparison.compareData(channelType_type_1, channelType_type_2, channelType_type_3))) {
            System.out.println("CHANNEL_TYPE test passed!");
        }else {
            System.out.println("CHANNEL_TYPE test failed! - X");
        }

        if(Objects.equals(test_CHANNEL_VALUE, DataComparison.compareData(channelValue_type_1, channelValue_type_2, channelValue_type_3))) {
            System.out.println("CHANNEL_VALUE test passed!");
        }else {
            System.out.println("CHANNEL_VALUE test failed! - X");
        }

        if(Objects.equals(test_CHANNEL_SUBTYPE, DataComparison.compareData(channelSubtype_type_1, channelSubtype_type_2, channelSubtype_type_3))) {
            System.out.println("CHANNEL_SUBTYPE test passed!");
        }else {
            System.out.println("CHANNEL_SUBTYPE test failed! - X");
        }

        if(Objects.equals(test_ISACTIVE, DataComparison.compareData(isActiveContact_type_1, isActiveContact_type_2, isActiveContact_type_3))) {
            System.out.println("ISACTIVE test passed!");
        }else {
            System.out.println("ISACTIVE test failed! - X");
        }

        if(Objects.equals(test_ISPRIMARY, DataComparison.compareData(isPrimaryContact_type_1, isPrimaryContact_type_2, isPrimaryContact_type_3))) {
            System.out.println("ISPRIMARY test passed!");
        }else {
            System.out.println("ISPRIMARY test failed! - X");
        }

        if(Objects.equals(test_NOTE, DataComparison.compareData(noteContact_type_1, noteContact_type_2, noteContact_type_3))) {
            System.out.println("NOTE test passed!");
        }else {
            System.out.println("NOTE test failed! - X");
        }

        System.out.println("----------------------------");

    }


    @Test (groups = {"regress"},
           dependsOnMethods = "complianceContacts",
            retryAnalyzer = Rerty.class)
    public void complianceGoverningBodies() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance Governing Bodies is starting...");

        try {

            // Select the Governing Bodies tab
            WebElement governingBodiesTab = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[1]/div/div[8]/a"));
            governingBodiesTab.click();
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
        System.out.println("Test compliance Other Changes In Doc is starting...");

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
