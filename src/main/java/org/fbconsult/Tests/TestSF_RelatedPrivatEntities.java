package org.fbconsult.Tests;

import org.fbconsult.Services.DataComparison;
import org.fbconsult.Services.DataConversion;
import org.fbconsult.Services.DateReplace;
import org.fbconsult.Services.TestEnvironment;
import org.fbconsult.Services.XpathAuthorization;
import org.fbconsult.Services.XpathRelatedPrivatEntities;

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

public class TestSF_RelatedPrivatEntities {

    final String requestMask = "UC-TSP";
    String productOrderNumber = null;

    String test_LASTNAME = null;
    String test_FIRSTNAME = null;
    String test_MIDDLENAME = null;
    String test_BIRTHPLACE = null;
    String test_BIRTHDATE = null;
    String test_GENDER = null;
    String test_INN = null;
    String test_CITIZENSHIP = null;
    String test_FOUNDER = null;
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
    String gender_type_1 = null;
    String inn_type_1 = null;
    String citizenship_type_1 = null;
    String founder_type_1 = null;
    String iseio_type_1 = null;
    String allBoss_type_1 = null;
    String capitalPercent_type_1 = null;
    String title_type_1 = null;
    String isNoCOPOP_type_1 = null;
    String isConnectedBP_type_1 = null;
    String signatureTypeBP_type_1 = null;
    String roleBP_type_1 = null;
    String phoneBP_type_1 = null;
    String mailBP_type_1 = null;

    String lastName_type_2 = null;
    String firstName_type_2 = null;
    String middleName_type_2 = null;
    String birthPlace_type_2 = null;
    String birthDate_type_2 = null;
    String gender_type_2 = null;
    String inn_type_2 = null;
    String citizenship_type_2 = null;
    String founder_type_2 = null;
    String iseio_type_2 = null;
    String allBoss_type_2 = null;
    String capitalPercent_type_2 = null;
    String title_type_2 = null;
    String isNoCOPOP_type_2 = null;
    String isConnectedBP_type_2 = null;
    String signatureTypeBP_type_2 = null;
    String roleBP_type_2 = null;
    String phoneBP_type_2 = null;
    String mailBP_type_2 = null;

    String lastName_type_3 = null;
    String firstName_type_3 = null;
    String middleName_type_3 = null;
    String birthPlace_type_3 = null;
    String birthDate_type_3 = null;
    String gender_type_3 = null;
    String inn_type_3 = null;
    String citizenship_type_3 = null;
    String founder_type_3 = null;
    String iseio_type_3 = null;
    String allBoss_type_3 = null;
    String capitalPercent_type_3 = null;
    String title_type_3 = null;
    String isNoCOPOP_type_3 = null;
    String isConnectedBP_type_3 = null;
    String signatureTypeBP_type_3 = null;
    String roleBP_type_3 = null;
    String phoneBP_type_3 = null;
    String mailBP_type_3 = null;

    @Parameters({"contour"})
    @Test
    public void testRelatedPrivatEntities(String contour) {

        TestEnvironment testEnvironment = new TestEnvironment(contour);

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_90\\chromedriver.exe");

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

            /*WebElement field_FOUNDER;
            if (contour.equals("8083")) {
                field_FOUNDER = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_FOUNDER_8083));
            } else {
                field_FOUNDER = driver.findElement(By.xpath(XpathRelatedPrivatEntities.FIELD_FOUNDER_8092));
            }
            test_FOUNDER = field_FOUNDER.getAttribute("value");*/

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

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
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
                gender_type_1 = rs_1.getString("GENDER");
                inn_type_1 = rs_1.getString("INN");
                citizenship_type_1 = rs_1.getString("COUNTRY");
                isConnectedBP_type_1 = DataConversion.testSF_booleanConversion(rs_1.getString("IS_CONNECTED_BP"));
                signatureTypeBP_type_1 = rs_1.getString("SIGNATURETYPEBP");
                roleBP_type_1 = rs_1.getString("ROLEBP");
                phoneBP_type_1 = rs_1.getString("PHONEBP");
                mailBP_type_1 = rs_1.getString("MAILBP");
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
                isConnectedBP_type_2 = DataConversion.testSF_booleanConversion(rs_2.getString("IS_CONNECTED_BP"));
                signatureTypeBP_type_2 = rs_2.getString("SIGNATURETYPEBP");
                roleBP_type_2 = rs_2.getString("ROLEBP");
                phoneBP_type_2 = rs_2.getString("PHONEBP");
                mailBP_type_2 = rs_2.getString("MAILBP");
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
                isConnectedBP_type_3 = DataConversion.testSF_booleanConversion(rs_3.getString("IS_CONNECTED_BP"));
                signatureTypeBP_type_3 = rs_3.getString("SIGNATURETYPEBP");
                roleBP_type_3 = rs_3.getString("ROLEBP");
                phoneBP_type_3 = rs_3.getString("PHONEBP");
                mailBP_type_3 = rs_3.getString("MAILBP");
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
}
