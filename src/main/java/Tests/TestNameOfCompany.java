package Tests;

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

public class TestNameOfCompany {
    String userName = "Admin";
    String password = "4YFDtyiaPpvIbYkehzkG";
    String requestMask = "UC";
    String test_ACCOUNTNAME = null;
    String test_AKA = null;
    String test_ENGNAME = null;
    String test_ENGNAMESHORT = null;
    String accountName = null;
    String aka = null;
    String engName = null;
    String engNameShort = null;

    @Test
    public void testNameOfCompany() {

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        try {
            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8093/SlxClient/logoff.aspx");

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
            Thread.sleep(5000);

            // Sort search result
            WebElement sortByModifiedDate = driver.findElement(By.xpath("//*[@id='dojoUnique22']"));
            sortByModifiedDate.click();
            Thread.sleep(2000);
            sortByModifiedDate.click();

            // Open the last application
            WebElement lastApplication = driver.findElement(By.xpath("//*[@id='listGrid-row-:r6AiXwz1uQM=']/table/tr/td[1]/a"));
            //WebElement lastApplication = driver.findElement(By
            //        .xpath("/html/body/form/div[4]/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div/div/div[2]/div/div[2]/table/tr/td[1]/a"));
            lastApplication.click();
            Thread.sleep(5000);

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

        System.out.println(test_ACCOUNTNAME);
        System.out.println(test_AKA);
        System.out.println(test_ENGNAME);
        System.out.println(test_ENGNAMESHORT);

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:8093:SERVER_NOMOS_TEST",
                                                               "SYSDBA", "masterkey");

            String selectTableSQL = "SELECT ACCOUNTNAME, AKA, ENGNAME, ENGNAMESHORT from FB_PRODUCTORDMEMB_DATA";

            Statement statement = connection.createStatement();

            // Get data from the database
            ResultSet rs = statement.executeQuery(selectTableSQL);

            // if something was received then the while loop will work
            while (rs.next()) {
                accountName = rs.getString("ACCOUNTNAME");
                aka = rs.getString("AKA");
                engName = rs.getString("ENGNAME");
                engNameShort = rs.getString("ENGNAMESHORT");
            }
            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        System.out.println("accountName : " + accountName);
        System.out.println("aka : " + aka);
        System.out.println("engName : " + engName);
        System.out.println("engNameShort : " + engNameShort);

    }
}
