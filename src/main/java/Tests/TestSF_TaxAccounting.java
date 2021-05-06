package Tests;

import Services.DataComparison;
import Services.DataConversion;
import Services.DateReplace;
import Services.TestEnvironment;
import Services.XpathAuthorization;
import Services.XpathTaxAccounting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TestSF_TaxAccounting {

    final String requestMask = "UC-TSP";
    String productOrderNumber = null;

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

    @Parameters({"contour"})
    @Test
    public void testTaxAccounting(String contour) {

        TestEnvironment testEnvironment = new TestEnvironment(contour);

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            driver.get(testEnvironment.getUrl());
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

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

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

        System.out.println(productOrderNumber);
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
}
