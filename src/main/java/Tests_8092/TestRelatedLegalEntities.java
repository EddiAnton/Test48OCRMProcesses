package Tests_8092;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestRelatedLegalEntities {
    final String DB_Data = "jdbc:oracle:thin:@server:1521:slx10";

    @Test
    public void testRelatedLegalEntities() {

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8092/SlxClient/logoff.aspx");
            driver.manage().window().maximize();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_Data, "SYSDBA", "masterkey");

            Statement statement = connection.createStatement();



            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
