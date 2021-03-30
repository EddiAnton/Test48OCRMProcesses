package Tests_8093;

import Services.CheckData;
import Services.DataComparison;
import Services.DataConversion;
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

public class TestSF_Contacts {
    final String DB_Data = "jdbc:oracle:thin:@server:1521:slx1";

    String userName = "Admin";
    String password = "4YFDtyiaPpvIbYkehzkG";
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

    @Test
    public void testContacts() {

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8093/SlxClient/logoff.aspx");
            driver.manage().window().maximize();

            WebElement logoffHref = driver.findElement(By
                    .linkText("Вернуться на страницу входа"));
            logoffHref.click();

            Thread.sleep(2000);

            // Authorization in system
            WebElement inputUserName = driver.findElement(By
                    .xpath("//input[@name='ctl00$ContentPlaceHolderArea$slxLogin$UserName']"));
            inputUserName.sendKeys(userName);

            WebElement inputPassword = driver.findElement(By
                    .xpath("//input[@name='ctl00$ContentPlaceHolderArea$slxLogin$Password']"));
            inputPassword.sendKeys(password);

            WebElement submitButton = driver.findElement(By
                    .xpath("//input[@name='ctl00$ContentPlaceHolderArea$slxLogin$btnLogin']"));
            submitButton.click();

            Thread.sleep(2000);

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
            Thread.sleep(2000);

            // Get data of the PRODUCTORDERNUMBER
            WebElement field_PRODUCTORDERNUMBER = driver.findElement(By
                    .xpath("//*[@id='PageTitle']"));
            productOrderNumber = DataConversion.getProductOrderNumber(field_PRODUCTORDERNUMBER.getText());
            Thread.sleep(3000);

            // Select the Contacts tab
            WebElement contactsTab = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[1]/div/div[7]/a"));
            contactsTab.click();
            Thread.sleep(2000);

            // Disclose data on the Contact - " V "
            WebElement openContact = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div[1]/div[1]/div/div/i"));
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
}
