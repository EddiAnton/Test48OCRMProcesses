package org.fbconsult.Tests;

import org.fbconsult.Services.*;

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

public class TestSF_ComplianceWEB_DBData {

    String contour;
    final String requestMask = "UC-TSP";
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
    String codeActivityKind_type_1 = null;
    String activityKind_type_1 = null;
    String issuedBy_type_1 = null;
    String issueDate_type_1 = null;
    String expiryDate_type_1 = null;
    String activityKindList_type_1 = null;

    String licenseNumber_type_2 = null;
    String codeActivityKind_type_2 = null;
    String activityKind_type_2 = null;
    String issuedBy_type_2 = null;
    String issueDate_type_2 = null;
    String expiryDate_type_2 = null;
    String activityKindList_type_2 = null;

    String licenseNumber_type_3 = null;
    String codeActivityKind_type_3 = null;
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
    String codeAddresstype_type_1 = null;
    String addresstype_type_1 = null;
    String codeCountry_type_1 = null;
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
    String codeAddresstype_type_2 = null;
    String addresstype_type_2 = null;
    String codeCountry_type_2 = null;
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
    String codeAddresstype_type_3 = null;
    String addresstype_type_3 = null;
    String codeCountry_type_3 = null;
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
    String test_FOUNDER = null;
    String test_BENEFICIAR = null;
    String test_ISEIO = null;
    String test_ALL_BOSS = null;
    String test_CAPITALPERCENT = null;
    String test_TITLE = null;
    String test_ISNOCOPOP = null;
    String test_IS_CONNECTED_BP = null;
    String test_SIGNATURETYPEBP = null;
    String test_ROLEBP = null;
    String test_PHONEBP = null;
    String test_MAILBP = null;

    String lastName_type_1 = null;
    String firstName_type_1 = null;
    String middleName_type_1 = null;
    String birthPlace_type_1 = null;
    String birthDate_type_1 = null;
    String codeGender_type_1 = null;
    String gender_type_1 = null;
    String inn_type_1 = null;
    String codeCitizenship_type_1 = null;
    String citizenship_type_1 = null;
    String founder_type_1 = null;
    String beneficiar_type_1 = null;
    String iseio_type_1 = null;
    String allBoss_type_1 = null;
    String capitalPercent_type_1 = null;
    String title_type_1 = null;
    String isNoCOPOP_type_1 = null;
    String isConnectedBP_type_1 = null;
    String codeSignatureTypeBP_type_1 = null;
    String signatureTypeBP_type_1 = null;
    String roleBP_type_1 = null;
    String phoneBP_type_1 = null;
    String mailBP_type_1 = null;

    String lastName_type_2 = null;
    String firstName_type_2 = null;
    String middleName_type_2 = null;
    String birthPlace_type_2 = null;
    String birthDate_type_2 = null;
    String codeGender_type_2 = null;
    String gender_type_2 = null;
    String inn_type_2 = null;
    String codeCitizenship_type_2 = null;
    String citizenship_type_2 = null;
    String founder_type_2 = null;
    String beneficiar_type_2 = null;
    String iseio_type_2 = null;
    String allBoss_type_2 = null;
    String capitalPercent_type_2 = null;
    String title_type_2 = null;
    String isNoCOPOP_type_2 = null;
    String isConnectedBP_type_2 = null;
    String codeSignatureTypeBP_type_2 = null;
    String signatureTypeBP_type_2 = null;
    String roleBP_type_2 = null;
    String phoneBP_type_2 = null;
    String mailBP_type_2 = null;

    String lastName_type_3 = null;
    String firstName_type_3 = null;
    String middleName_type_3 = null;
    String birthPlace_type_3 = null;
    String birthDate_type_3 = null;
    String codeGender_type_3 = null;
    String gender_type_3 = null;
    String inn_type_3 = null;
    String codeCitizenship_type_3 = null;
    String citizenship_type_3 = null;
    String founder_type_3 = null;
    String beneficiar_type_3 = null;
    String iseio_type_3 = null;
    String allBoss_type_3 = null;
    String capitalPercent_type_3 = null;
    String title_type_3 = null;
    String isNoCOPOP_type_3 = null;
    String isConnectedBP_type_3 = null;
    String codeSignatureTypeBP_type_3 = null;
    String signatureTypeBP_type_3 = null;
    String roleBP_type_3 = null;
    String phoneBP_type_3 = null;
    String mailBP_type_3 = null;


    // Variables for complianceRelatedLegalEntities method
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


    // Variables for complianceTaxAccounting method
    String test_CODE_TAX = null;
    String test_CODENAME_TAX = null;
    String test_BEGINDATE_TAX = null;
    String test_CODE_KPP = null;
    String test_ISPRIMARY_KPP = null;
    String test_ISADDITIONALPROPERTY1 = null;

    String codeTax_type_1 = null;
    String codeNameTax_type_1 = null;
    String beginDateTax_type_1 = null;
    String codeKPP_type_1 = null;
    String isPrimaryKPP_type_1 = null;
    String isAdditionalProperty1_type_1 = null;

    String codeTax_type_2 = null;
    String codeNameTax_type_2 = null;
    String beginDateTax_type_2 = null;
    String codeKPP_type_2 = null;
    String isPrimaryKPP_type_2 = null;
    String isAdditionalProperty1_type_2 = null;

    String codeTax_type_3 = null;
    String codeNameTax_type_3 = null;
    String beginDateTax_type_3 = null;
    String codeKPP_type_3 = null;
    String isPrimaryKPP_type_3 = null;
    String isAdditionalProperty1_type_3 = null;


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


    // Variables for complianceOKVED method
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


    // Variables for complianceUpdatingOtherInformation method
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

    TestEnvironment testEnvironment;
    WebDriver driver;

    @Parameters({"contour"})
    @Test (groups = {"regress"},
            retryAnalyzer = Rerty.class)
    public void testAuthorization(String contour) {

        this.contour = contour;
        System.out.println();
        System.out.println("TEST Compliance IS STARTING...");
        System.out.println();
        System.out.println();
        System.out.println("Test Authorization is starting...");

        try {

            testEnvironment = new TestEnvironment(contour);
            System.setProperty("webdriver.chrome.driver",
                    "D:\\selenium\\drivers\\chromedriver_90\\chromedriver.exe");
            driver =  new ChromeDriver();

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


        } catch (InterruptedException e) {
            System.out.println("/TestAuthorization/ test failed");
            e.printStackTrace();
        }
        System.out.println("/TestAuthorization/ test passed");
    }


    @Test (groups = {"regress"},
            dependsOnMethods = "testAuthorization",
            retryAnalyzer = Rerty.class)
    public void openDataChangeRequest() {

        System.out.println();
        System.out.println();
        System.out.println("Test open DataChangeRequest is starting...");

        try {

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
            WebElement sortByModifiedDate;
            if (contour.equals("8083")) {
                sortByModifiedDate = driver.findElement(By.xpath(XpathAuthorization.SORT_BY_MODIFIED_DATE_83));
            } else {
                sortByModifiedDate = driver.findElement(By.xpath(XpathAuthorization.SORT_BY_MODIFIED_DATE));
            }
            sortByModifiedDate.click();
            Thread.sleep(1000);
            sortByModifiedDate.click();
            Thread.sleep(5000);

            // Open the last application
            WebElement lastApplication = driver.findElement(By.xpath(XpathAuthorization.LAST_APPLICATION));
            lastApplication.click();
            Thread.sleep(5000);

            // Get data of the PRODUCTORDERNUMBER
            WebElement field_PRODUCTORDERNUMBER = driver.findElement(By
                    .xpath(XpathAuthorization.FIELD_PRODUCTORDERNUMBER));
            productOrderNumber = DataConversion.getProductOrderNumber(field_PRODUCTORDERNUMBER.getText());
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
            WebElement organizationNameTab = new WebDriverWait(driver, 15).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathNameOfCompany.ORGANIZATION_NAME_TAB)));
            organizationNameTab.click();

            // Get data of the Name type
            WebElement field_ACCOUNTNAME;
            if (contour.equals("8083")) {
                field_ACCOUNTNAME = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathNameOfCompany.FIELD_ACCOUNTNAME_8083)));
            } else {
                field_ACCOUNTNAME = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathNameOfCompany.FIELD_ACCOUNTNAME_8092)));
            }
            test_ACCOUNTNAME = field_ACCOUNTNAME.getAttribute("value");

            WebElement field_AKA;
            if (contour.equals("8083")) {
                field_AKA = driver.findElement(By.xpath(XpathNameOfCompany.FIELD_AKA_8083));
            } else {
                field_AKA = driver.findElement(By.xpath(XpathNameOfCompany.FIELD_AKA_8092));
            }
            test_AKA = field_AKA.getAttribute("value");

            WebElement field_ENGNAME;
            if (contour.equals("8083")) {
                field_ENGNAME = driver.findElement(By.xpath(XpathNameOfCompany.FIELD_ENGNAME_8083));
            } else {
                field_ENGNAME = driver.findElement(By.xpath(XpathNameOfCompany.FIELD_ENGNAME_8092));
            }
            test_ENGNAME = field_ENGNAME.getAttribute("value");

            WebElement field_ENGNAMESHORT;
            if (contour.equals("8083")) {
                field_ENGNAMESHORT = driver.findElement(By.xpath(XpathNameOfCompany.FIELD_ENGNAMESHORT_8083));
            } else {
                field_ENGNAMESHORT = driver.findElement(By.xpath(XpathNameOfCompany.FIELD_ENGNAMESHORT_8092));
            }
            test_ENGNAMESHORT = field_ENGNAMESHORT.getAttribute("value");
            Thread.sleep(1000);

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
            Connection connection = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");

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

            // Select the License tab
            WebElement licenseTab = new WebDriverWait(driver, 15).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathLicense.LICENSE_TAB)));
            licenseTab.click();

            // Disclose data on the License - " V "
            WebElement openLicense;
            if (contour.equals("8083")) {
                openLicense = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathLicense.OPEN_LICENSE_8083)));
            } else {
                openLicense = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathLicense.OPEN_LICENSE_8092)));
            }
            openLicense.click();

            // Get data of the License type
            WebElement field_LICENSENUMBER;
            if (contour.equals("8083")) {
                field_LICENSENUMBER = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathLicense.FIELD_LICENSENUMBER_8083)));
            } else {
                field_LICENSENUMBER = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathLicense.FIELD_LICENSENUMBER_8092)));
            }
            test_LICENSENUMBER = field_LICENSENUMBER.getAttribute("value");

            WebElement field_ACTIVITYKIND;
            if (contour.equals("8083")) {
                field_ACTIVITYKIND = driver.findElement(By.xpath(XpathLicense.FIELD_ACTIVITYKIND_8083));
            } else {
                field_ACTIVITYKIND = driver.findElement(By.xpath(XpathLicense.FIELD_ACTIVITYKIND_8092));
            }
            test_ACTIVITYKIND = field_ACTIVITYKIND.getAttribute("value");

            WebElement field_ISSUEDBY;
            if (contour.equals("8083")) {
                field_ISSUEDBY = driver.findElement(By.xpath(XpathLicense.FIELD_ISSUEDBY_8083));
            } else {
                field_ISSUEDBY = driver.findElement(By.xpath(XpathLicense.FIELD_ISSUEDBY_8092));
            }
            test_ISSUEDBY = field_ISSUEDBY.getAttribute("value");

            WebElement field_ISSUEDATE;
            if (contour.equals("8083")) {
                field_ISSUEDATE = driver.findElement(By.xpath(XpathLicense.FIELD_ISSUEDATE_8083));
            } else {
                field_ISSUEDATE = driver.findElement(By.xpath(XpathLicense.FIELD_ISSUEDATE_8092));
            }
            test_ISSUEDATE = field_ISSUEDATE.getAttribute("value");

            WebElement field_EXPIRYDATE;
            if (contour.equals("8083")) {
                field_EXPIRYDATE = driver.findElement(By.xpath(XpathLicense.FIELD_EXPIRYDATE_8083));
            } else {
                field_EXPIRYDATE = driver.findElement(By.xpath(XpathLicense.FIELD_EXPIRYDATE_8092));
            }
            test_EXPIRYDATE = field_EXPIRYDATE.getAttribute("value");

            WebElement field_ACTIVITYKINDLIST;
            if (contour.equals("8083")) {
                field_ACTIVITYKINDLIST = driver.findElement(By.xpath(XpathLicense.FIELD_ACTIVITYKINDLIST_8083));
            } else {
                field_ACTIVITYKINDLIST = driver.findElement(By.xpath(XpathLicense.FIELD_ACTIVITYKINDLIST_8092));
            }
            test_ACTIVITYKINDLIST = field_ACTIVITYKINDLIST.getAttribute("value");
            Thread.sleep(1000);

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
                codeActivityKind_type_1 = rs_1.getString("ACTIVITYKIND");
                issuedBy_type_1 = rs_1.getString("ISSUEDBY");
                issueDate_type_1 = DateReplace.replaceInputDate(rs_1.getString("ISSUEDATE"));
                expiryDate_type_1 = DateReplace.replaceInputDate(rs_1.getString("EXPIRYDATE"));
                activityKindList_type_1 = rs_1.getString("ACTIVITYKINDLIST");
            }

            String selectPicklistLicense = "SELECT ITEMVALUE " +
                    "FROM fb_picklist " +
                    "WHERE PICKLISTNAME = 'Виды лицензий' " +
                    "AND ITEMNAME = '" + codeActivityKind_type_1 + "'";

            ResultSet rs_1_license = statement.executeQuery(selectPicklistLicense);
            while (rs_1_license.next()) {
                activityKind_type_1 = rs_1_license.getString("ITEMVALUE");
            }

            // Get data for type 2 from the database
            ResultSet rs_2 = statement.executeQuery(selectTableSQLForType_2);

            // if something was received then the while loop will work
            while (rs_2.next()) {
                licenseNumber_type_2 = rs_2.getString("LICENSENUMBER");
                codeActivityKind_type_2 = rs_2.getString("ACTIVITYKIND");
                issuedBy_type_2 = rs_2.getString("ISSUEDBY");
                issueDate_type_2 = DateReplace.replaceInputDate(rs_2.getString("ISSUEDATE"));
                expiryDate_type_2 = DateReplace.replaceInputDate(rs_2.getString("EXPIRYDATE"));
                activityKindList_type_2 = rs_2.getString("ACTIVITYKINDLIST");
            }

            String selectPicklistLicense_2 = "SELECT ITEMVALUE " +
                    "FROM fb_picklist " +
                    "WHERE PICKLISTNAME = 'Виды лицензий' " +
                    "AND ITEMNAME = '" + codeActivityKind_type_2 + "'";

            ResultSet rs_2_license = statement.executeQuery(selectPicklistLicense_2);
            while (rs_2_license.next()) {
                activityKind_type_2 = rs_2_license.getString("ITEMVALUE");
            }

            // Get data for type 3 from the database
            ResultSet rs_3 = statement.executeQuery(selectTableSQLForType_3);

            // if something was received then the while loop will work
            while (rs_3.next()) {
                licenseNumber_type_3 = rs_3.getString("LICENSENUMBER");
                codeActivityKind_type_3 = rs_3.getString("ACTIVITYKIND");
                issuedBy_type_3 = rs_3.getString("ISSUEDBY");
                issueDate_type_3 = DateReplace.replaceInputDate(rs_3.getString("ISSUEDATE"));
                expiryDate_type_3 = DateReplace.replaceInputDate(rs_3.getString("EXPIRYDATE"));
                activityKindList_type_3 = rs_3.getString("ACTIVITYKINDLIST");
            }

            String selectPicklistLicense_3 = "SELECT ITEMVALUE " +
                    "FROM fb_picklist " +
                    "WHERE PICKLISTNAME = 'Виды лицензий' " +
                    "AND ITEMNAME = '" + codeActivityKind_type_3 + "'";

            ResultSet rs_3_license = statement.executeQuery(selectPicklistLicense_3);
            while (rs_3_license.next()) {
                activityKind_type_3 = rs_3_license.getString("ITEMVALUE");
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
            alwaysRun = true,
            retryAnalyzer = Rerty.class)
    public void complianceAddressesOfCompany() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance Addresses Of Company is starting...");

        try {

            // Select the Address tab
            WebElement addressTab = new WebDriverWait(driver, 15).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathAddress.ADDRESS_TAB)));
            addressTab.click();

            // Get data OKATO & OKTMO
            WebElement field_OKATO;
            if (contour.equals("8083")) {
                field_OKATO = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAddress.FIELD_OKATO_8083)));
            } else {
                field_OKATO = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAddress.FIELD_OKATO_8092)));
            }
            test_OKATO = field_OKATO.getAttribute("value");

            WebElement field_OKTMO;
            if (contour.equals("8083")) {
                field_OKTMO = driver.findElement(By.xpath(XpathAddress.FIELD_OKTMO_8083));
            } else {
                field_OKTMO = driver.findElement(By.xpath(XpathAddress.FIELD_OKTMO_8092));
            }
            test_OKTMO = field_OKTMO.getAttribute("value");

            // Disclose data on the Address - " V "
            WebElement openAddress;
            if (contour.equals("8083")) {
                openAddress = driver.findElement(By.xpath(XpathAddress.OPEN_ADDRESS_8083));
            } else {
                openAddress = driver.findElement(By.xpath(XpathAddress.OPEN_ADDRESS_8092));
            }
            openAddress.click();

            // Get data of the Address type
            WebElement field_ADDRESSTYPE;
            if (contour.equals("8083")) {
                field_ADDRESSTYPE = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAddress.FIELD_ADDRESSTYPE_8083)));
            } else {
                field_ADDRESSTYPE = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAddress.FIELD_ADDRESSTYPE_8092)));
            }
            test_ADDRESSTYPE = field_ADDRESSTYPE.getAttribute("value");

            WebElement field_COUNTRY;
            if (contour.equals("8083")) {
                field_COUNTRY = driver.findElement(By.xpath(XpathAddress.FIELD_COUNTRY_8083));
            } else {
                field_COUNTRY = driver.findElement(By.xpath(XpathAddress.FIELD_COUNTRY_8092));
            }
            test_COUNTRY = field_COUNTRY.getAttribute("value");

            WebElement field_POSTALCODE;
            if (contour.equals("8083")) {
                field_POSTALCODE = driver.findElement(By.xpath(XpathAddress.FIELD_POSTALCODE_8083));
            } else {
                field_POSTALCODE = driver.findElement(By.xpath(XpathAddress.FIELD_POSTALCODE_8092));
            }
            test_POSTALCODE = field_POSTALCODE.getAttribute("value");

            WebElement field_COUNTY;
            if (contour.equals("8083")) {
                field_COUNTY = driver.findElement(By.xpath(XpathAddress.FIELD_COUNTY_8083));
            } else {
                field_COUNTY = driver.findElement(By.xpath(XpathAddress.FIELD_COUNTY_8092));
            }
            test_COUNTY = field_COUNTY.getAttribute("value");

            WebElement field_DISTRICT;
            if (contour.equals("8083")) {
                field_DISTRICT = driver.findElement(By.xpath(XpathAddress.FIELD_DISTRICT_8083));
            } else {
                field_DISTRICT = driver.findElement(By.xpath(XpathAddress.FIELD_DISTRICT_8092));
            }
            test_DISTRICT = field_DISTRICT.getAttribute("value");

            WebElement field_CITY;
            if (contour.equals("8083")) {
                field_CITY = driver.findElement(By.xpath(XpathAddress.FIELD_CITY_8083));
            } else {
                field_CITY = driver.findElement(By.xpath(XpathAddress.FIELD_CITY_8092));
            }
            test_CITY = field_CITY.getAttribute("value");

            WebElement field_STREET;
            if (contour.equals("8083")) {
                field_STREET = driver.findElement(By.xpath(XpathAddress.FIELD_STREET_8083));
            } else {
                field_STREET = driver.findElement(By.xpath(XpathAddress.FIELD_STREET_8092));
            }
            test_STREET = field_STREET.getAttribute("value");

            WebElement field_HOUSE;
            if (contour.equals("8083")) {
                field_HOUSE = driver.findElement(By.xpath(XpathAddress.FIELD_HOUSE_8083));
            } else {
                field_HOUSE = driver.findElement(By.xpath(XpathAddress.FIELD_HOUSE_8092));
            }
            test_HOUSE = field_HOUSE.getAttribute("value");

            WebElement field_CORPUS;
            if (contour.equals("8083")) {
                field_CORPUS = driver.findElement(By.xpath(XpathAddress.FIELD_CORPUS_8083));
            } else {
                field_CORPUS = driver.findElement(By.xpath(XpathAddress.FIELD_CORPUS_8092));
            }
            test_CORPUS = field_CORPUS.getAttribute("value");

            WebElement field_APARTMENT;
            if (contour.equals("8083")) {
                field_APARTMENT = driver.findElement(By.xpath(XpathAddress.FIELD_APARTMENT_8083));
            } else {
                field_APARTMENT = driver.findElement(By.xpath(XpathAddress.FIELD_APARTMENT_8092));
            }
            test_APARTMENT = field_APARTMENT.getAttribute("value");

            WebElement field_FULLADDRESS;
            if (contour.equals("8083")) {
                field_FULLADDRESS = driver.findElement(By.xpath(XpathAddress.FIELD_FULLADDRESS_8083));
            } else {
                field_FULLADDRESS = driver.findElement(By.xpath(XpathAddress.FIELD_FULLADDRESS_8092));
            }
            test_FULLADDRESS = field_FULLADDRESS.getAttribute("value");
            Thread.sleep(1000);

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
            Connection connection = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");

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
                codeAddresstype_type_1 = rs_1.getString("ADDRESSTYPE");
                codeCountry_type_1 = rs_1.getString("COUNTRY");
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

            String selectPicklistAddressType = "SELECT pl.TEXT " +
                    "FROM picklist pl " +
                    "INNER JOIN picklist pln " +
                    "ON pln.itemid = pl.picklistid " +
                    "AND pln.picklistid = 'PICKLISTLIST' " +
                    "WHERE pln.text = 'Тип адреса' " +
                    "AND pl.SHORTTEXT = '" + codeAddresstype_type_1 + "'";

            ResultSet rs_1_addressType = statement.executeQuery(selectPicklistAddressType);
            while (rs_1_addressType.next()) {
                addresstype_type_1 = rs_1_addressType.getString("TEXT");
            }

            String selectPicklistCountry = "SELECT pl.TEXT " +
                    "FROM picklist pl " +
                    "INNER JOIN picklist pln " +
                    "ON pln.itemid = pl.picklistid " +
                    "AND pln.picklistid = 'PICKLISTLIST' " +
                    "WHERE pln.text = 'Страны' " +
                    "AND pl.SHORTTEXT = '" + codeCountry_type_1 + "'";

            ResultSet rs_1_country = statement.executeQuery(selectPicklistCountry);
            while (rs_1_country.next()) {
                country_type_1 = rs_1_country.getString("TEXT");
            }


            // Get data for type 2 from the database
            ResultSet rs_2 = statement.executeQuery(selectTableSQLForType_2);

            // if something was received then the while loop will work
            while (rs_2.next()) {
                okato_type_2 = rs_2.getString("OKATO");
                oktmo_type_2 = rs_2.getString("OKTMO");
                codeAddresstype_type_2 = rs_2.getString("ADDRESSTYPE");
                codeCountry_type_2 = rs_2.getString("COUNTRY");
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

            String selectPicklistAddressType_2 = "SELECT pl.TEXT " +
                    "FROM picklist pl " +
                    "INNER JOIN picklist pln " +
                    "ON pln.itemid = pl.picklistid " +
                    "AND pln.picklistid = 'PICKLISTLIST' " +
                    "WHERE pln.text = 'Тип адреса' " +
                    "AND pl.SHORTTEXT = ' " + codeAddresstype_type_2 + "'";

            ResultSet rs_2_addressType = statement.executeQuery(selectPicklistAddressType_2);
            while (rs_2_addressType.next()) {
                addresstype_type_2 = rs_2_addressType.getString("TEXT");
            }

            String selectPicklistCountry_2 = "SELECT pl.TEXT " +
                    "FROM picklist pl " +
                    "INNER JOIN picklist pln " +
                    "ON pln.itemid = pl.picklistid " +
                    "AND pln.picklistid = 'PICKLISTLIST' " +
                    "WHERE pln.text = 'Страны' " +
                    "AND pl.SHORTTEXT = '" + codeCountry_type_2 + "'";

            ResultSet rs_2_country = statement.executeQuery(selectPicklistCountry_2);
            while (rs_2_country.next()) {
                country_type_2 = rs_2_country.getString("TEXT");
            }


            // Get data for type 3 from the database
            ResultSet rs_3 = statement.executeQuery(selectTableSQLForType_3);

            // if something was received then the while loop will work
            while (rs_3.next()) {
                okato_type_3 = rs_3.getString("OKATO");
                oktmo_type_3 = rs_3.getString("OKTMO");
                codeAddresstype_type_3 = rs_3.getString("ADDRESSTYPE");
                codeCountry_type_3 = rs_3.getString("COUNTRY");
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

            String selectPicklistAddressType_3 = "SELECT pl.TEXT " +
                    "FROM picklist pl " +
                    "INNER JOIN picklist pln " +
                    "ON pln.itemid = pl.picklistid " +
                    "AND pln.picklistid = 'PICKLISTLIST' " +
                    "WHERE pln.text = 'Тип адреса' " +
                    "AND pl.SHORTTEXT = ' " + codeAddresstype_type_3 + "'";

            ResultSet rs_3_addressType = statement.executeQuery(selectPicklistAddressType_3);
            while (rs_3_addressType.next()) {
                addresstype_type_3 = rs_3_addressType.getString("TEXT");
            }

            String selectPicklistCountry_3 = "SELECT pl.TEXT " +
                    "FROM picklist pl " +
                    "INNER JOIN picklist pln " +
                    "ON pln.itemid = pl.picklistid " +
                    "AND pln.picklistid = 'PICKLISTLIST' " +
                    "WHERE pln.text = 'Страны' " +
                    "AND pl.SHORTTEXT = '" + codeCountry_type_3 + "'";

            ResultSet rs_3_country = statement.executeQuery(selectPicklistCountry_3);
            while (rs_3_country.next()) {
                country_type_3 = rs_3_country.getString("TEXT");
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
            alwaysRun = true,
            retryAnalyzer = Rerty.class)
    public void complianceRelatedPrivatEntities() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance Related Privat Entities is starting...");

        try {

            // Select the Related Privat Entities tab
            WebElement relatedPrivatEntitiesTab = new WebDriverWait(driver, 15).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathRelatedPrivatEntities.RELATED_PRIVAT_ENTITIES_TAB)));
            relatedPrivatEntitiesTab.click();

            // Disclose data on the Related Privat Entities - " V "
            WebElement openRelatedPrivatEntities;
            if (contour.equals("8083")) {
                openRelatedPrivatEntities = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathRelatedPrivatEntities.OPEN_RELATED_PRIVAT_ENTITIES_8083)));
            } else {
                openRelatedPrivatEntities = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathRelatedPrivatEntities.OPEN_RELATED_PRIVAT_ENTITIES_8092)));
            }
            openRelatedPrivatEntities.click();

            // Get data of the Related Privat Entities type
            WebElement field_LASTNAME;
            if (contour.equals("8083")) {
                field_LASTNAME = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathRelatedPrivatEntities.FIELD_LASTNAME_8083)));
            } else {
                field_LASTNAME = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathRelatedPrivatEntities.FIELD_LASTNAME_8092)));
            }
            test_LASTNAME = field_LASTNAME.getAttribute("value");

            WebElement field_FIRSTNAME;
            if (contour.equals("8083")) {
                field_FIRSTNAME = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_FIRSTNAME_8083));
            } else {
                field_FIRSTNAME = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_FIRSTNAME_8092));
            }
            test_FIRSTNAME = field_FIRSTNAME.getAttribute("value");

            WebElement field_MIDDLENAME;
            if (contour.equals("8083")) {
                field_MIDDLENAME = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_MIDDLENAME_8083));
            } else {
                field_MIDDLENAME = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_MIDDLENAME_8092));
            }
            test_MIDDLENAME = field_MIDDLENAME.getAttribute("value");

            WebElement field_BIRTHPLACE;
            if (contour.equals("8083")) {
                field_BIRTHPLACE = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_BIRTHPLACE_8083));
            } else {
                field_BIRTHPLACE = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_BIRTHPLACE_8092));
            }
            test_BIRTHPLACE = field_BIRTHPLACE.getAttribute("value");

            WebElement field_BIRTHDATE;
            if (contour.equals("8083")) {
                field_BIRTHDATE = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_BIRTHDATE_8083));
            } else {
                field_BIRTHDATE = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_BIRTHDATE_8092));
            }
            test_BIRTHDATE = field_BIRTHDATE.getAttribute("value");

            WebElement field_GENDER;
            if (contour.equals("8083")) {
                field_GENDER = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_GENDER_8083));
            } else {
                field_GENDER = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_GENDER_8092));
            }
            test_GENDER = field_GENDER.getAttribute("value");

            WebElement field_INN;
            if (contour.equals("8083")) {
                field_INN = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_INN_8083));
            } else {
                field_INN = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_INN_8092));
            }
            test_INN = field_INN.getAttribute("value");

            WebElement field_CITIZENSHIP;
            if (contour.equals("8083")) {
                field_CITIZENSHIP = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_CITIZENSHIP_8083));
            } else {
                field_CITIZENSHIP = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_CITIZENSHIP_8092));
            }
            test_CITIZENSHIP = field_CITIZENSHIP.getAttribute("value");

            WebElement field_FOUNDER;
            if (contour.equals("8083")) {
                field_FOUNDER = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_FOUNDER_8083));
            } else {
                field_FOUNDER = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_FOUNDER_8092));
            }
            test_FOUNDER = field_FOUNDER.getAttribute("value");

            WebElement field_BENEFICIAR;
            if (contour.equals("8083")) {
                field_BENEFICIAR = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_BENEFICIAR_8083));
            } else {
                field_BENEFICIAR = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_BENEFICIAR_8092));
            }
            test_BENEFICIAR = field_BENEFICIAR.getAttribute("value");

            WebElement field_ISEIO;
            if (contour.equals("8083")) {
                field_ISEIO = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_ISEIO_8083));
            } else {
                field_ISEIO = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_ISEIO_8092));
            }
            test_ISEIO = field_ISEIO.getAttribute("value");

            WebElement field_ALL_BOSS;
            if (contour.equals("8083")) {
                field_ALL_BOSS = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_ALL_BOSS_8083));
            } else {
                field_ALL_BOSS = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_ALL_BOSS_8092));
            }
            test_ALL_BOSS = field_ALL_BOSS.getAttribute("value");

            WebElement field_CAPITALPERCENT;
            if (contour.equals("8083")) {
                field_CAPITALPERCENT = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_CAPITALPERCENT_8083));
            } else {
                field_CAPITALPERCENT = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_CAPITALPERCENT_8092));
            }
            test_CAPITALPERCENT = field_CAPITALPERCENT.getAttribute("value");

            WebElement field_TITLE;
            if (contour.equals("8083")) {
                field_TITLE = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_TITLE_8083));
            } else {
                field_TITLE = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_TITLE_8092));
            }
            test_TITLE = field_TITLE.getAttribute("value");

            WebElement field_ISNOCOPOP;
            if (contour.equals("8083")) {
                field_ISNOCOPOP = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_ISNOCOPOP_8083));
            } else {
                field_ISNOCOPOP = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_ISNOCOPOP_8092));
            }
            test_ISNOCOPOP = field_ISNOCOPOP.getAttribute("value");

            WebElement field_IS_CONNECTED_BP;
            if (contour.equals("8083")) {
                field_IS_CONNECTED_BP = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_IS_CONNECTED_BP_8083));
            } else {
                field_IS_CONNECTED_BP = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_IS_CONNECTED_BP_8092));
            }
            test_IS_CONNECTED_BP = field_IS_CONNECTED_BP.getAttribute("value");

            WebElement field_SIGNATURETYPEBP;
            if (contour.equals("8083")) {
                field_SIGNATURETYPEBP = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_SIGNATURETYPEBP_8083));
            } else {
                field_SIGNATURETYPEBP = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_SIGNATURETYPEBP_8092));
            }
            test_SIGNATURETYPEBP = field_SIGNATURETYPEBP.getAttribute("value");

            WebElement field_ROLEBP;
            if (contour.equals("8083")) {
                field_ROLEBP = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_ROLEBP_8083));
            } else {
                field_ROLEBP = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_ROLEBP_8092));
            }
            test_ROLEBP = field_ROLEBP.getAttribute("value");

            WebElement field_PHONEBP;
            if (contour.equals("8083")) {
                field_PHONEBP = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_PHONEBP_8083));
            } else {
                field_PHONEBP = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_PHONEBP_8092));
            }
            test_PHONEBP = field_PHONEBP.getAttribute("value");

            WebElement field_MAILBP;
            if (contour.equals("8083")) {
                field_MAILBP = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_MAILBP_8083));
            } else {
                field_MAILBP = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_MAILBP_8092));
            }
            test_MAILBP = field_MAILBP.getAttribute("value");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(productOrderNumber);
        System.out.println("---------------");
        System.out.println("Основная информация");
        System.out.println(test_LASTNAME);
        System.out.println(test_FIRSTNAME);
        System.out.println(test_MIDDLENAME);
        System.out.println(test_BIRTHPLACE);
        System.out.println(test_BIRTHDATE);
        System.out.println(test_GENDER);
        System.out.println(test_INN);
        System.out.println(test_CITIZENSHIP);
        System.out.println();
        System.out.println("Связь с основным клиентом");
        System.out.println(test_FOUNDER);
        System.out.println(test_BENEFICIAR);
        System.out.println(test_ISEIO);
        System.out.println(test_ALL_BOSS);
        System.out.println(test_CAPITALPERCENT);
        System.out.println(test_TITLE);
        System.out.println(test_ISNOCOPOP);
        System.out.println();
        System.out.println("Подключение к БП");
        System.out.println(test_IS_CONNECTED_BP);
        System.out.println(test_SIGNATURETYPEBP);
        System.out.println(test_ROLEBP);
        System.out.println(test_PHONEBP);
        System.out.println(test_MAILBP);
        System.out.println("---------------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");

            String selectTableSQLForType_1 = "SELECT fbpomd.LASTNAME, " +
                    "fbpomd.FIRSTNAME, " +
                    "fbpomd.MIDDLENAME, " +
                    "fbpomd.BIRTHPLACE, " +
                    "fbpomd.BIRTHDATE, " +
                    "fbpomd.GENDER, " +
                    "fbpomd.INN, " +
                    "fbpomd.COUNTRY, " +
                    "fbpomd.IS_CONNECTED_BP, " +
                    "fbpomd.SIGNATURETYPEBP, " +
                    "fbpomd.ROLEBP, " +
                    "fbpomd.PHONEBP, " +
                    "fbpomd.MAILBP " +
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
                    "fbpomd.COUNTRY, " +
                    "fbpomd.IS_CONNECTED_BP, " +
                    "fbpomd.SIGNATURETYPEBP, " +
                    "fbpomd.ROLEBP, " +
                    "fbpomd.PHONEBP, " +
                    "fbpomd.MAILBP " +
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
                    "fbpomd.COUNTRY, " +
                    "fbpomd.IS_CONNECTED_BP, " +
                    "fbpomd.SIGNATURETYPEBP, " +
                    "fbpomd.ROLEBP, " +
                    "fbpomd.PHONEBP, " +
                    "fbpomd.MAILBP " +
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
                codeGender_type_1 = rs_1.getString("GENDER");
                inn_type_1 = rs_1.getString("INN");
                codeCitizenship_type_1 = rs_1.getString("COUNTRY");
                isConnectedBP_type_1 = DataConversion.testSF_booleanConversion(rs_1.getString("IS_CONNECTED_BP"));
                codeSignatureTypeBP_type_1 = rs_1.getString("SIGNATURETYPEBP");
                roleBP_type_1 = rs_1.getString("ROLEBP");
                phoneBP_type_1 = rs_1.getString("PHONEBP");
                mailBP_type_1 = rs_1.getString("MAILBP");
            }

            String selectPicklistGender = "SELECT pl.TEXT " +
                    "FROM picklist pl " +
                    "INNER JOIN picklist pln " +
                    "ON pln.itemid = pl.picklistid " +
                    "AND pln.picklistid = 'PICKLISTLIST' " +
                    "WHERE pln.text = 'Пол' " +
                    "AND pl.SHORTTEXT = '" + codeGender_type_1 + "'";

            ResultSet rs_1_gender = statement.executeQuery(selectPicklistGender);
            while (rs_1_gender.next()) {
                gender_type_1 = rs_1_gender.getString("TEXT");
            }


            String selectPicklistCitizenship = "SELECT pl.TEXT " +
                    "FROM picklist pl " +
                    "INNER JOIN picklist pln " +
                    "ON pln.itemid = pl.picklistid " +
                    "AND pln.picklistid = 'PICKLISTLIST' " +
                    "WHERE pln.text = 'Страны' " +
                    "AND pl.SHORTTEXT = '" + codeCitizenship_type_1 + "'";

            ResultSet rs_1_citizenship = statement.executeQuery(selectPicklistCitizenship);
            while (rs_1_citizenship.next()) {
                citizenship_type_1 = rs_1_citizenship.getString("TEXT");
            }


            String selectPicklist_SIGNATURETYPEBP_1 = "select pl.text " +
                    "from picklist pl " +
                    "inner join picklist pln " +
                    "on pln.itemid = pl.picklistid " +
                    "and pln.picklistid = 'PICKLISTLIST' " +
                    "where pln.text = 'Типы подписи' " +
                    "and pl.SHORTTEXT = '" + codeSignatureTypeBP_type_1 + "'";

            ResultSet rs_1_SIGNATURETYPEBP = statement.executeQuery(selectPicklist_SIGNATURETYPEBP_1);
            while (rs_1_SIGNATURETYPEBP.next()) {
                signatureTypeBP_type_1 = rs_1_SIGNATURETYPEBP.getString("TEXT");
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
                codeGender_type_2 = rs_2.getString("GENDER");
                inn_type_2 = rs_2.getString("INN");
                codeCitizenship_type_2 = rs_2.getString("COUNTRY");
                isConnectedBP_type_2 = DataConversion.testSF_booleanConversion(rs_2.getString("IS_CONNECTED_BP"));
                codeSignatureTypeBP_type_2 = rs_2.getString("SIGNATURETYPEBP");
                roleBP_type_2 = rs_2.getString("ROLEBP");
                phoneBP_type_2 = rs_2.getString("PHONEBP");
                mailBP_type_2 = rs_2.getString("MAILBP");
            }

            String selectPicklistGender_2 = "SELECT pl.TEXT " +
                    "FROM picklist pl " +
                    "INNER JOIN picklist pln " +
                    "ON pln.itemid = pl.picklistid " +
                    "AND pln.picklistid = 'PICKLISTLIST' " +
                    "WHERE pln.text = 'Пол' " +
                    "AND pl.SHORTTEXT = '" + codeGender_type_2 + "'";

            ResultSet rs_2_gender = statement.executeQuery(selectPicklistGender_2);
            while (rs_2_gender.next()) {
                gender_type_2 = rs_2_gender.getString("TEXT");
            }


            String selectPicklistCitizenship_2 = "SELECT pl.TEXT " +
                    "FROM picklist pl " +
                    "INNER JOIN picklist pln " +
                    "ON pln.itemid = pl.picklistid " +
                    "AND pln.picklistid = 'PICKLISTLIST' " +
                    "WHERE pln.text = 'Страны' " +
                    "AND pl.SHORTTEXT = '" + codeCitizenship_type_2 + "'";

            ResultSet rs_2_citizenship = statement.executeQuery(selectPicklistCitizenship_2);
            while (rs_2_citizenship.next()) {
                citizenship_type_2 = rs_2_citizenship.getString("TEXT");
            }

            String selectPicklist_SIGNATURETYPEBP_2 = "select pl.text " +
                    "from picklist pl " +
                    "inner join picklist pln " +
                    "on pln.itemid = pl.picklistid " +
                    "and pln.picklistid = 'PICKLISTLIST' " +
                    "where pln.text = 'Типы подписи' " +
                    "and pl.SHORTTEXT = '" + codeSignatureTypeBP_type_2 + "'";

            ResultSet rs_2_SIGNATURETYPEBP = statement.executeQuery(selectPicklist_SIGNATURETYPEBP_2);
            while (rs_2_SIGNATURETYPEBP.next()) {
                signatureTypeBP_type_2 = rs_2_SIGNATURETYPEBP.getString("TEXT");
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
                codeGender_type_3 = rs_3.getString("GENDER");
                inn_type_3 = rs_3.getString("INN");
                codeCitizenship_type_3 = rs_3.getString("COUNTRY");
                isConnectedBP_type_3 = DataConversion.testSF_booleanConversion(rs_3.getString("IS_CONNECTED_BP"));
                codeSignatureTypeBP_type_3 = rs_3.getString("SIGNATURETYPEBP");
                roleBP_type_3 = rs_3.getString("ROLEBP");
                phoneBP_type_3 = rs_3.getString("PHONEBP");
                mailBP_type_3 = rs_3.getString("MAILBP");
            }

            String selectPicklistGender_3 = "SELECT pl.TEXT " +
                    "FROM picklist pl " +
                    "INNER JOIN picklist pln " +
                    "ON pln.itemid = pl.picklistid " +
                    "AND pln.picklistid = 'PICKLISTLIST' " +
                    "WHERE pln.text = 'Пол' " +
                    "AND pl.SHORTTEXT = '" + codeGender_type_3 + "'";

            ResultSet rs_3_gender = statement.executeQuery(selectPicklistGender_3);
            while (rs_3_gender.next()) {
                gender_type_3 = rs_3_gender.getString("TEXT");
            }


            String selectPicklistCitizenship_3 = "SELECT pl.TEXT " +
                    "FROM picklist pl " +
                    "INNER JOIN picklist pln " +
                    "ON pln.itemid = pl.picklistid " +
                    "AND pln.picklistid = 'PICKLISTLIST' " +
                    "WHERE pln.text = 'Страны' " +
                    "AND pl.SHORTTEXT = '" + codeCitizenship_type_3 + "'";

            ResultSet rs_3_citizenship = statement.executeQuery(selectPicklistCitizenship_3);
            while (rs_3_citizenship.next()) {
                citizenship_type_3 = rs_3_citizenship.getString("TEXT");
            }

            String selectPicklist_SIGNATURETYPEBP_3 = "select pl.text " +
                    "from picklist pl " +
                    "inner join picklist pln " +
                    "on pln.itemid = pl.picklistid " +
                    "and pln.picklistid = 'PICKLISTLIST' " +
                    "where pln.text = 'Типы подписи' " +
                    "and pl.SHORTTEXT = '" + codeSignatureTypeBP_type_3 + "'";

            ResultSet rs_3_SIGNATURETYPEBP = statement.executeQuery(selectPicklist_SIGNATURETYPEBP_3);
            while (rs_3_SIGNATURETYPEBP.next()) {
                signatureTypeBP_type_3 = rs_3_SIGNATURETYPEBP.getString("TEXT");
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
            System.out.println("CITIZENSHIP test passed!");
        }else {
            System.out.println("CITIZENSHIP test failed! - X");
        }

        if(Objects.equals(test_FOUNDER, DataComparison.compareData(founder_type_1, founder_type_2, founder_type_3))) {
            System.out.println("FOUNDER test passed!");
        }else {
            System.out.println("FOUNDER test failed! - X");
        }

        if(Objects.equals(test_BENEFICIAR, DataComparison.compareData(beneficiar_type_1, beneficiar_type_2, beneficiar_type_3))) {
            System.out.println("BENEFICIAR test passed!");
        }else {
            System.out.println("BENEFICIAR test failed! - X");
        }

        if(Objects.equals(test_ISEIO, DataComparison.compareData(iseio_type_1, iseio_type_2, iseio_type_3))) {
            System.out.println("ISEIO test passed!");
        }else {
            System.out.println("ISEIO test failed! - X");
        }

        if(Objects.equals(test_ALL_BOSS, DataComparison.compareData(allBoss_type_1, allBoss_type_2, allBoss_type_3))) {
            System.out.println("ALL_BOSS test passed!");
        }else {
            System.out.println("ALL_BOSS test failed! - X");
        }

        if(Objects.equals(test_CAPITALPERCENT, DataComparison.compareData(capitalPercent_type_1, capitalPercent_type_2, capitalPercent_type_3))) {
            System.out.println("CAPITALPERCENT test passed!");
        }else {
            System.out.println("CAPITALPERCENT test failed! - X");
        }

        if(Objects.equals(test_TITLE, DataComparison.compareData(title_type_1, title_type_2, title_type_3))) {
            System.out.println("TITLE test passed!");
        }else {
            System.out.println("TITLE test failed! - X");
        }

        if(Objects.equals(test_ISNOCOPOP, DataComparison.compareData(isNoCOPOP_type_1, isNoCOPOP_type_2, isNoCOPOP_type_3))) {
            System.out.println("ISNOCOPOP test passed!");
        }else {
            System.out.println("ISNOCOPOP test failed! - X");
        }

        if(Objects.equals(test_IS_CONNECTED_BP, DataComparison.compareData(isConnectedBP_type_1, isConnectedBP_type_2, isConnectedBP_type_3))) {
            System.out.println("IS_CONNECTED_BP test passed!");
        }else {
            System.out.println("IS_CONNECTED_BP test failed! - X");
        }

        if(Objects.equals(test_SIGNATURETYPEBP, DataComparison.compareData(signatureTypeBP_type_1, signatureTypeBP_type_2, signatureTypeBP_type_3))) {
            System.out.println("SIGNATURETYPEBP test passed!");
        }else {
            System.out.println("SIGNATURETYPEBP test failed! - X");
        }

        if(Objects.equals(test_ROLEBP, DataComparison.compareData(roleBP_type_1, roleBP_type_2, roleBP_type_3))) {
            System.out.println("ROLEBP test passed!");
        }else {
            System.out.println("ROLEBP test failed! - X");
        }

        if(Objects.equals(test_PHONEBP, DataComparison.compareData(phoneBP_type_1, phoneBP_type_2, phoneBP_type_3))) {
            System.out.println("PHONEBP test passed!");
        }else {
            System.out.println("PHONEBP test failed! - X");
        }

        if(Objects.equals(test_MAILBP, DataComparison.compareData(mailBP_type_1, mailBP_type_2, mailBP_type_3))) {
            System.out.println("MAILBP test passed!");
        }else {
            System.out.println("MAILBP test failed! - X");
        }

        System.out.println("----------------------------");

    }


    @Test (groups = {"regress"},
            dependsOnMethods = "complianceRelatedPrivatEntities",
            alwaysRun = true,
            retryAnalyzer = Rerty.class)
    public void complianceRelatedLegalEntities() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance Related Legal Entities is starting...");

        try {

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
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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


    @Test (groups = {"regress"},
            dependsOnMethods = "complianceRelatedLegalEntities",
            alwaysRun = true,
            retryAnalyzer = Rerty.class)
    public void complianceTaxAccounting() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance Tax Accounting is starting...");

        try {

            // Select the Tax Accounting tab
            WebElement taxAccountingTab = new WebDriverWait(driver, 15).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathTaxAccounting.TAX_ACCOUNTING_TAB)));
            taxAccountingTab.click();

            // Disclose data on the Tax - " V "
            WebElement openTax;
            if (contour.equals("8083")) {
                openTax = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathTaxAccounting.OPEN_TAX_8083)));
            } else {
                openTax = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathTaxAccounting.OPEN_TAX_8092)));
            }
            openTax.click();

            // Get data of the Tax type
            WebElement field_CODE_TAX;
            if (contour.equals("8083")) {
                field_CODE_TAX = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathTaxAccounting.FIELD_CODE_TAX_8083)));
            } else {
                field_CODE_TAX = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathTaxAccounting.FIELD_CODE_TAX_8092)));
            }
            test_CODE_TAX = field_CODE_TAX.getAttribute("value");

            WebElement field_CODENAME_TAX;
            if (contour.equals("8083")) {
                field_CODENAME_TAX = driver.findElement(By.xpath(XpathTaxAccounting.FIELD_CODENAME_TAX_8083));
            } else {
                field_CODENAME_TAX = driver.findElement(By.xpath(XpathTaxAccounting.FIELD_CODENAME_TAX_8092));
            }
            test_CODENAME_TAX = field_CODENAME_TAX.getAttribute("value");

            WebElement field_BEGINDATE_TAX;
            if (contour.equals("8083")) {
                field_BEGINDATE_TAX = driver.findElement(By.xpath(XpathTaxAccounting.FIELD_BEGINDATE_TAX_8083));
            } else {
                field_BEGINDATE_TAX = driver.findElement(By.xpath(XpathTaxAccounting.FIELD_BEGINDATE_TAX_8092));
            }
            test_BEGINDATE_TAX = field_BEGINDATE_TAX.getAttribute("value");

            // Disclose data on the KPP - " V "
            WebElement openKPP;
            if (contour.equals("8083")) {
                openKPP = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathTaxAccounting.OPEN_KPP_8083)));
            } else {
                openKPP = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathTaxAccounting.OPEN_KPP_8092)));
            }
            openKPP.click();

            // Get data of the KPP type
            WebElement field_CODE_KPP;
            if (contour.equals("8083")) {
                field_CODE_KPP = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathTaxAccounting.FIELD_CODE_KPP_8083)));
            } else {
                field_CODE_KPP = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathTaxAccounting.FIELD_CODE_KPP_8092)));
            }
            test_CODE_KPP = field_CODE_KPP.getAttribute("value");

            WebElement field_ISPRIMARY_KPP;
            if (contour.equals("8083")) {
                field_ISPRIMARY_KPP = driver.findElement(By.xpath(XpathTaxAccounting.FIELD_ISPRIMARY_KPP_8083));
            } else {
                field_ISPRIMARY_KPP = driver.findElement(By.xpath(XpathTaxAccounting.FIELD_ISPRIMARY_KPP_8092));
            }
            test_ISPRIMARY_KPP = field_ISPRIMARY_KPP.getAttribute("value");

            WebElement field_ISADDITIONALPROPERTY1;
            if (contour.equals("8083")) {
                field_ISADDITIONALPROPERTY1 = driver.findElement(By.xpath(XpathTaxAccounting.FIELD_ISADDITIONALPROPERTY1_8083));
            } else {
                field_ISADDITIONALPROPERTY1 = driver.findElement(By.xpath(XpathTaxAccounting.FIELD_ISADDITIONALPROPERTY1_8092));
            }
            test_ISADDITIONALPROPERTY1 = field_ISADDITIONALPROPERTY1.getAttribute("value");
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---------------");
        System.out.println(test_CODE_TAX);
        System.out.println(test_CODENAME_TAX);
        System.out.println(test_BEGINDATE_TAX);
        System.out.println(test_CODE_KPP);
        System.out.println(test_ISPRIMARY_KPP);
        System.out.println(test_ISADDITIONALPROPERTY1);
        System.out.println("---------------");

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");

            String selectTableSQLForType_1_tax = "SELECT fbpomcode.CODE, " +
                    "fbpomcode.CODENAME, " +
                    "fbpomcode.BEGINDATE " +
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
                    "AND fbpomcode.codetype = '4' ";

            String selectTableSQLForType_2_tax = "SELECT fbpomcode.CODE, " +
                    "fbpomcode.CODENAME, " +
                    "fbpomcode.BEGINDATE " +
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
                    "AND fbpomcode.codetype = '4' ";

            String selectTableSQLForType_3_tax = "SELECT fbpomcode.CODE, " +
                    "fbpomcode.CODENAME, " +
                    "fbpomcode.BEGINDATE " +
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
                    "AND fbpomcode.codetype = '4' ";

            Statement statement = connection.createStatement();

            // Get Tax data for type 1 from the database
            ResultSet rs_tax_1 = statement.executeQuery(selectTableSQLForType_1_tax);

            // if something was received then the while loop will work
            while (rs_tax_1.next()) {
                codeTax_type_1 = rs_tax_1.getString("CODE");
                codeNameTax_type_1 = rs_tax_1.getString("CODENAME");
                beginDateTax_type_1 = DateReplace.replaceInputDate(rs_tax_1.getString("BEGINDATE"));
            }

            // Get Tax data for type 2 from the database
            ResultSet rs_tax_2 = statement.executeQuery(selectTableSQLForType_2_tax);

            // if something was received then the while loop will work
            while (rs_tax_2.next()) {
                codeTax_type_2 = rs_tax_2.getString("CODE");
                codeNameTax_type_2 = rs_tax_2.getString("CODENAME");
                beginDateTax_type_2 = DateReplace.replaceInputDate(rs_tax_2.getString("BEGINDATE"));
            }

            // Get Tax data for type 3 from the database
            ResultSet rs_tax_3 = statement.executeQuery(selectTableSQLForType_3_tax);

            // if something was received then the while loop will work
            while (rs_tax_3.next()) {
                codeTax_type_3 = rs_tax_3.getString("CODE");
                codeNameTax_type_3 = rs_tax_3.getString("CODENAME");
                beginDateTax_type_3 = DateReplace.replaceInputDate(rs_tax_3.getString("BEGINDATE"));
            }


            String selectTableSQLForType_1_kpp = "SELECT fbpomcode.CODE, " +
                    "fbpomcode.ISPRIMARY, " +
                    "fbpomcode.ISADDITIONALPROPERTY1 " +
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
                    "AND fbpomcode.codetype = '2' ";

            String selectTableSQLForType_2_kpp = "SELECT fbpomcode.CODE, " +
                    "fbpomcode.ISPRIMARY, " +
                    "fbpomcode.ISADDITIONALPROPERTY1 " +
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
                    "AND fbpomcode.codetype = '2' ";

            String selectTableSQLForType_3_kpp = "SELECT fbpomcode.CODE, " +
                    "fbpomcode.ISPRIMARY, " +
                    "fbpomcode.ISADDITIONALPROPERTY1 " +
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
                    "AND fbpomcode.codetype = '2' ";

            // Get KPP data for type 1 from the database
            ResultSet rs_kpp_1 = statement.executeQuery(selectTableSQLForType_1_kpp);

            // if something was received then the while loop will work
            while (rs_kpp_1.next()) {
                codeKPP_type_1 = rs_kpp_1.getString("CODE");
                isPrimaryKPP_type_1 = DataConversion.testSF_booleanConversion(rs_kpp_1.getString("ISPRIMARY"));
                isAdditionalProperty1_type_1 = DataConversion.testSF_booleanConversion(rs_kpp_1.getString("ISADDITIONALPROPERTY1"));
            }

            // Get KPP data for type 2 from the database
            ResultSet rs_kpp_2 = statement.executeQuery(selectTableSQLForType_2_kpp);

            // if something was received then the while loop will work
            while (rs_kpp_2.next()) {
                codeKPP_type_2 = rs_kpp_2.getString("CODE");
                isPrimaryKPP_type_2 = DataConversion.testSF_booleanConversion(rs_kpp_2.getString("ISPRIMARY"));
                isAdditionalProperty1_type_2 = DataConversion.testSF_booleanConversion(rs_kpp_2.getString("ISADDITIONALPROPERTY1"));
            }

            // Get KPP data for type 3 from the database
            ResultSet rs_kpp_3 = statement.executeQuery(selectTableSQLForType_3_kpp);

            // if something was received then the while loop will work
            while (rs_kpp_3.next()) {
                codeKPP_type_3 = rs_kpp_3.getString("CODE");
                isPrimaryKPP_type_3 = DataConversion.testSF_booleanConversion(rs_kpp_3.getString("ISPRIMARY"));
                isAdditionalProperty1_type_3 = DataConversion.testSF_booleanConversion(rs_kpp_3.getString("ISADDITIONALPROPERTY1"));
            }

            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        if(Objects.equals(test_CODE_TAX, DataComparison.compareData(codeTax_type_1, codeTax_type_2, codeTax_type_3))) {
            System.out.println("CODE_TAX test passed!");
        }else {
            System.out.println("CODE_TAX test failed! - X");
        }

        if(Objects.equals(test_CODENAME_TAX, DataComparison.compareData(codeNameTax_type_1, codeNameTax_type_2, codeNameTax_type_3))) {
            System.out.println("CODENAME_TAX test passed!");
        }else {
            System.out.println("CODENAME_TAX test failed! - X");
        }

        if(Objects.equals(test_BEGINDATE_TAX, DataComparison.compareData(beginDateTax_type_1, beginDateTax_type_2, beginDateTax_type_3))) {
            System.out.println("BEGINDATE_TAX test passed!");
        }else {
            System.out.println("BEGINDATE_TAX test failed! - X");
        }

        if(Objects.equals(test_CODE_KPP, DataComparison.compareData(codeKPP_type_1, codeKPP_type_2, codeKPP_type_3))) {
            System.out.println("CODE_KPP test passed!");
        }else {
            System.out.println("CODE_KPP test failed! - X");
        }

        if(Objects.equals(test_ISPRIMARY_KPP, DataComparison.compareData(isPrimaryKPP_type_1, isPrimaryKPP_type_2, isPrimaryKPP_type_3))) {
            System.out.println("ISPRIMARY_KPP test passed!");
        }else {
            System.out.println("ISPRIMARY_KPP test failed! - X");
        }

        if(Objects.equals(test_ISADDITIONALPROPERTY1, DataComparison.compareData(isAdditionalProperty1_type_1, isAdditionalProperty1_type_2, isAdditionalProperty1_type_3))) {
            System.out.println("ISADDITIONALPROPERTY1 test passed!");
        }else {
            System.out.println("ISADDITIONALPROPERTY1 test failed! - X");
        }

        System.out.println("----------------------------");
    }


    @Test (groups = {"regress"},
            dependsOnMethods = "complianceTaxAccounting",
            alwaysRun = true,
            retryAnalyzer = Rerty.class)
    public void complianceContacts() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance Contacts is starting...");

        try {

            // Select the Contacts tab
            WebElement contactsTab = new WebDriverWait(driver, 15).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathContact.CONTACTS_TAB)));
            contactsTab.click();

            // Disclose data on the Contact - " V "
            WebElement openContact;
            if (contour.equals("8083")) {
                openContact = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathContact.OPEN_CONTACT_8083)));
            } else {
                openContact = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathContact.OPEN_CONTACT_8092)));
            }
            openContact.click();

            // Get data of the Contact type
            WebElement field_CHANNEL_TYPE;
            if (contour.equals("8083")) {
                field_CHANNEL_TYPE = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathContact.FIELD_CHANNEL_TYPE_8083)));
            } else {
                field_CHANNEL_TYPE = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathContact.FIELD_CHANNEL_TYPE_8092)));
            }
            test_CHANNEL_TYPE = field_CHANNEL_TYPE.getAttribute("value");

            WebElement field_CHANNEL_VALUE;
            if (contour.equals("8083")) {
                field_CHANNEL_VALUE = driver.findElement(By.xpath(XpathContact.FIELD_CHANNEL_VALUE_8083));
            } else {
                field_CHANNEL_VALUE = driver.findElement(By.xpath(XpathContact.FIELD_CHANNEL_VALUE_8092));
            }
            test_CHANNEL_VALUE = field_CHANNEL_VALUE.getAttribute("value");

            WebElement field_CHANNEL_SUBTYPE;
            if (contour.equals("8083")) {
                field_CHANNEL_SUBTYPE = driver.findElement(By.xpath(XpathContact.FIELD_CHANNEL_SUBTYPE_8083));
            } else {
                field_CHANNEL_SUBTYPE = driver.findElement(By.xpath(XpathContact.FIELD_CHANNEL_SUBTYPE_8092));
            }
            test_CHANNEL_SUBTYPE = field_CHANNEL_SUBTYPE.getAttribute("value");

            WebElement field_ISACTIVE;
            if (contour.equals("8083")) {
                field_ISACTIVE = driver.findElement(By.xpath(XpathContact.FIELD_ISACTIVE_8083));
            } else {
                field_ISACTIVE = driver.findElement(By.xpath(XpathContact.FIELD_ISACTIVE_8092));
            }
            test_ISACTIVE = field_ISACTIVE.getAttribute("value");

            WebElement field_ISPRIMARY;
            if (contour.equals("8083")) {
                field_ISPRIMARY = driver.findElement(By.xpath(XpathContact.FIELD_ISPRIMARY_8083));
            } else {
                field_ISPRIMARY = driver.findElement(By.xpath(XpathContact.FIELD_ISPRIMARY_8092));
            }
            test_ISPRIMARY = field_ISPRIMARY.getAttribute("value");

            WebElement field_NOTE;
            if (contour.equals("8083")) {
                field_NOTE = driver.findElement(By.xpath(XpathContact.FIELD_NOTE_8083));
            } else {
                field_NOTE = driver.findElement(By.xpath(XpathContact.FIELD_NOTE_8092));
            }
            test_NOTE = field_NOTE.getAttribute("value");
            Thread.sleep(1000);

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
            Connection connection = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");

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
                isActiveContact_type_1 = DataConversion.testSF_booleanConversion(rs_1.getString("ISACTIVE"));
                isPrimaryContact_type_1 = DataConversion.testSF_booleanConversion(rs_1.getString("ISPRIMARY"));
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
                codeChannelType_type_2 = rs_2.getString("CHANNEL_TYPE");
                channelValue_type_2 = rs_2.getString("CHANNEL_VALUE");
                codeChannelSubtype_type_2 = rs_2.getInt("CHANNEL_SUBTYPE");
                isActiveContact_type_2 = DataConversion.testSF_booleanConversion(rs_2.getString("ISACTIVE"));
                isPrimaryContact_type_2 = DataConversion.testSF_booleanConversion(rs_2.getString("ISPRIMARY"));
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
                codeChannelType_type_3 = rs_3.getString("CHANNEL_TYPE");
                channelValue_type_3 = rs_3.getString("CHANNEL_VALUE");
                codeChannelSubtype_type_3 = rs_3.getInt("CHANNEL_SUBTYPE");
                isActiveContact_type_3 = DataConversion.testSF_booleanConversion(rs_3.getString("ISACTIVE"));
                isPrimaryContact_type_3 = DataConversion.testSF_booleanConversion(rs_3.getString("ISPRIMARY"));
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
            alwaysRun = true,
            retryAnalyzer = Rerty.class)
    public void complianceGoverningBodies() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance Governing Bodies is starting...");

        try {

            // Select the Governing Bodies tab
            WebElement governingBodiesTab = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathGoverningBodies.GOVERNING_BODIES_TAB)));
            governingBodiesTab.click();

            // Get data of the Governing Bodies type
            WebElement field_MANAGE_PERSON;
            if (contour.equals("8083")) {
                field_MANAGE_PERSON = driver.findElement(By.xpath(XpathGoverningBodies.FIELD_MANAGE_PERSON_8083));
            } else {
                field_MANAGE_PERSON = driver.findElement(By.xpath(XpathGoverningBodies.FIELD_MANAGE_PERSON_8092));
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
            Thread.sleep(1000);

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
            alwaysRun = true,
            retryAnalyzer = Rerty.class)
    public void complianceOtherChangesInDoc() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance Other Changes In Doc is starting...");

        try{

            // Select the Other Changes in Doc tab
            WebElement otherChangesInDocTab = new WebDriverWait(driver, 15).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathOtherChangesInDoc.OTHER_CHANGES_IN_DOC_TAB)));
            otherChangesInDocTab.click();

            // Get data of the Other changes type
            WebElement field_OKFS;
            if (contour.equals("8083")) {
                field_OKFS = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathOtherChangesInDoc.FIELD_OKFS_8083)));
            } else {
                field_OKFS = new WebDriverWait(driver, 10).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathOtherChangesInDoc.FIELD_OKFS_8092)));
            }
            test_OKFS = field_OKFS.getAttribute("value");

            WebElement field_COMPANYTYPE;
            if (contour.equals("8083")) {
                field_COMPANYTYPE = driver.findElement(By.xpath(XpathOtherChangesInDoc.FIELD_COMPANYTYPE_8083));
            } else {
                field_COMPANYTYPE = driver.findElement(By.xpath(XpathOtherChangesInDoc.FIELD_COMPANYTYPE_8092));
            }
            test_COMPANYTYPE = field_COMPANYTYPE.getAttribute("value");

            WebElement field_OKOPF;
            if (contour.equals("8083")) {
                field_OKOPF = driver.findElement(By.xpath(XpathOtherChangesInDoc.FIELD_OKOPF_8083));
            } else {
                field_OKOPF = driver.findElement(By.xpath(XpathOtherChangesInDoc.FIELD_OKOPF_8092));
            }
            test_OKOPF = field_OKOPF.getAttribute("value");

            WebElement field_CAPITALANNOUNCEDSUM;
            if (contour.equals("8083")) {
                field_CAPITALANNOUNCEDSUM = driver.findElement(By.xpath(XpathOtherChangesInDoc.FIELD_CAPITALANNOUNCEDSUM_8083));
            } else {
                field_CAPITALANNOUNCEDSUM = driver.findElement(By.xpath(XpathOtherChangesInDoc.FIELD_CAPITALANNOUNCEDSUM_8092));
            }
            test_CAPITALANNOUNCEDSUM = field_CAPITALANNOUNCEDSUM.getAttribute("value");

            WebElement field_CAPITALCURRENCY;
            if (contour.equals("8083")) {
                field_CAPITALCURRENCY = driver.findElement(By.xpath(XpathOtherChangesInDoc.FIELD_CAPITALCURRENCY_8083));
            } else {
                field_CAPITALCURRENCY = driver.findElement(By.xpath(XpathOtherChangesInDoc.FIELD_CAPITALCURRENCY_8092));
            }
            test_CAPITALCURRENCY = field_CAPITALCURRENCY.getAttribute("value");
            Thread.sleep(1000);

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


    @Test (groups = {"regress"},
            dependsOnMethods = "complianceOtherChangesInDoc",
            alwaysRun = true,
            retryAnalyzer = Rerty.class)
    public void complianceOKVED() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance OKVED is starting...");

        try {

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
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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


    @Test (groups = {"regress"},
            dependsOnMethods = "complianceOKVED",
            alwaysRun = true,
            retryAnalyzer = Rerty.class)
    public void complianceUpdatingOtherInformation() {

        System.out.println();
        System.out.println();
        System.out.println("Test compliance Updating Other Information is starting...");

        try {

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
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
