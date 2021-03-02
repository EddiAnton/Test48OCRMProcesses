package Tests_8092;

import Services.DataComparison;
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

public class TestOtherChangesInDoc {
    final String DB_Data = "jdbc:oracle:thin:@server:1521:slx10";

    String userName = "Admin";
    String requestMask = "UC-TSP";

    String productOrderNumber = null;

    String test_OKFS = null;
    String test_COMPANYTYPE = null;
    String test_OKOPF = null;
    String test_CAPITALANNOUNCEDSUM = null;
    String test_CAPITALCURRENCY = null;

    String okfs_type_1 = null;
    String companyType_type_1 = null;
    String okopf_type_1 = null;
    String capitalAnnouncedSum_type_1 = null;
    String capitalCurrency_type_1 = null;

    String okfs_type_2 = null;
    String companyType_type_2 = null;
    String okopf_type_2 = null;
    String capitalAnnouncedSum_type_2 = null;
    String capitalCurrency_type_2 = null;

    String okfs_type_3 = null;
    String companyType_type_3 = null;
    String okopf_type_3 = null;
    String capitalAnnouncedSum_type_3 = null;
    String capitalCurrency_type_3 = null;

    @Test
    public void testOtherChangesInDoc() {

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8092/SlxClient/logoff.aspx");

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
            Thread.sleep(2000);

            // Get data of the PRODUCTORDERNUMBER
            WebElement field_PRODUCTORDERNUMBER = driver.findElement(By
                    .xpath("//*[@id='PageTitle']"));
            String productOrderNumberFull = field_PRODUCTORDERNUMBER.getText();
            // Отрезать "Заявка - "
            String [] splitString = productOrderNumberFull.split(" ");
            productOrderNumber = splitString[2];
            Thread.sleep(3000);

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
            e.printStackTrace();
        } finally {
            driver.close();
        }

        System.out.println(productOrderNumber);
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
                okfs_type_1 = rs_1.getString("OKFS");
                companyType_type_1 = rs_1.getString("COMPANYTYPE");
                okopf_type_1 = rs_1.getString("OKOPF");
                capitalAnnouncedSum_type_1 = rs_1.getString("CAPITALANNOUNCEDSUM");
                capitalCurrency_type_1 = rs_1.getString("CAPITALCURRENCY");
            }

            // Get data for type 2 from the database
            ResultSet rs_2 = statement.executeQuery(selectTableSQLForType_1);

            // if something was received then the while loop will work
            while (rs_2.next()) {
                okfs_type_2 = rs_2.getString("OKFS");
                companyType_type_2 = rs_2.getString("COMPANYTYPE");
                okopf_type_2 = rs_2.getString("OKOPF");
                capitalAnnouncedSum_type_2 = rs_2.getString("CAPITALANNOUNCEDSUM");
                capitalCurrency_type_2 = rs_2.getString("CAPITALCURRENCY");
            }

            // Get data for type 3 from the database
            ResultSet rs_3 = statement.executeQuery(selectTableSQLForType_1);

            // if something was received then the while loop will work
            while (rs_3.next()) {
                okfs_type_3 = rs_3.getString("OKFS");
                companyType_type_3 = rs_3.getString("COMPANYTYPE");
                okopf_type_3 = rs_3.getString("OKOPF");
                capitalAnnouncedSum_type_3 = rs_3.getString("CAPITALANNOUNCEDSUM");
                capitalCurrency_type_3 = rs_3.getString("CAPITALCURRENCY");
            }

            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

git pull        if(Objects.equals(test_OKFS, DataComparison.compareData(okfs_type_1, okfs_type_2, okfs_type_3))) {
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
