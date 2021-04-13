package Tests;

import Services.CheckData;
import Services.DataComparison;
import Services.DataConversion;
import Services.TestEnvironment;
import Services.XpathAuthorization;
import Services.XpathContact;

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

public class TestSF_Contacts {

    String requestMask = "UC-TSP";
    String productOrderNumber = null;

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

    @Parameters({"contour"})
    @Test
    public void testContacts(String contour) {

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

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

        System.out.println(productOrderNumber);
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
                channelType_type_2 = rs_2.getString("CHANNEL_TYPE");
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
                channelType_type_3 = rs_3.getString("CHANNEL_TYPE");
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

        if (Objects.equals(test_CHANNEL_TYPE, DataComparison.compareData(channelType_type_1, channelType_type_2, channelType_type_3))) {
            System.out.println("CHANNEL_TYPE test passed!");
        } else {
            System.out.println("CHANNEL_TYPE test failed! - X");
        }

        if (Objects.equals(test_CHANNEL_VALUE, DataComparison.compareData(channelValue_type_1, channelValue_type_2, channelValue_type_3))) {
            System.out.println("CHANNEL_VALUE test passed!");
        } else {
            System.out.println("CHANNEL_VALUE test failed! - X");
        }

        if (Objects.equals(test_CHANNEL_SUBTYPE, DataComparison.compareData(channelSubtype_type_1, channelSubtype_type_2, channelSubtype_type_3))) {
            System.out.println("CHANNEL_SUBTYPE test passed!");
        } else {
            System.out.println("CHANNEL_SUBTYPE test failed! - X");
        }

        if (Objects.equals(test_ISACTIVE, DataComparison.compareData(isActiveContact_type_1, isActiveContact_type_2, isActiveContact_type_3))) {
            System.out.println("ISACTIVE test passed!");
        } else {
            System.out.println("ISACTIVE test failed! - X");
        }

        if (Objects.equals(test_ISPRIMARY, DataComparison.compareData(isPrimaryContact_type_1, isPrimaryContact_type_2, isPrimaryContact_type_3))) {
            System.out.println("ISPRIMARY test passed!");
        } else {
            System.out.println("ISPRIMARY test failed! - X");
        }

        if (Objects.equals(test_NOTE, DataComparison.compareData(noteContact_type_1, noteContact_type_2, noteContact_type_3))) {
            System.out.println("NOTE test passed!");
        } else {
            System.out.println("NOTE test failed! - X");
        }

        System.out.println("----------------------------");
    }
}
