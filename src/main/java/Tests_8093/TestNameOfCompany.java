package Tests_8093;

import Services.DataComparison;
import Services.Rerty;
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

public class TestNameOfCompany {
    final String DB_Data = "jdbc:oracle:thin:@server:1521:slx1";

    String userName = "Admin";
    String password = "4YFDtyiaPpvIbYkehzkG";
    String requestMask = "UC-TSP";

    String productOrderNumber = null;

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

    @Test(retryAnalyzer = Rerty.class)
    public void testNameOfCompany() {

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

            Thread.sleep(5000);

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

            // Select the Organization Name tab
            WebElement organizationNameTab = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[1]/div/div[1]/a"));
            organizationNameTab.click();
            Thread.sleep(2000);

            // Get data of the Name type
            WebElement field_ACCOUNTNAME = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[1]/div[1]/div/div/textarea"));
            test_ACCOUNTNAME = field_ACCOUNTNAME.getAttribute("value");

            WebElement field_AKA = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[2]/div[1]/div/div/textarea"));
            test_AKA = field_AKA.getAttribute("value");

            WebElement field_ENGNAME = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[3]/div[1]/div/div/textarea"));
            test_ENGNAME = field_ENGNAME.getAttribute("value");

            WebElement field_ENGNAMESHORT = driver.findElement(By
                    .xpath("//*[@id='DetailProductOrderChangeComponent']/div[2]/section/div/div/div[4]/div[1]/div/div/textarea"));
            test_ENGNAMESHORT = field_ENGNAMESHORT.getAttribute("value");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

        System.out.println(productOrderNumber);
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
            ex.printStackTrace();
        }

        //Comparison of data from a Web service with data from a database.
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
}
