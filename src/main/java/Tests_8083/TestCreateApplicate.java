package Tests_8083;

import Services.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCreateApplicate {

    String contour = "8083";

    String INN = "1234567890";
    String productOrderNumber = null;
    String fb_productOrderID = null;

    @Test
    public void createApplicate() {

        TestEnvironment testEnvironment = new TestEnvironment(contour);

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

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

            Thread.sleep(2000);

            // Enter to "Clients"
            WebElement clientsTab = driver.findElement(By.xpath(XpathCreateApplicate.CLIENTS_TAB));
            clientsTab.click();
            Thread.sleep(5000);

            // Enter INN in the field to search for a client and confirm your choice
            WebElement inputINN = driver.findElement(By.xpath(XpathCreateApplicate.FIELD_INN_OR_ACCOUNTNAME));
            inputINN.sendKeys(INN);
            Thread.sleep(2000);

            WebElement confirmSelected = driver.findElement(By.xpath(XpathCreateApplicate.CONFIRM_SELECTED_CUSTOMER));
            confirmSelected.click();
            Thread.sleep(3000);

            WebElement createApplication = driver.findElement(By.xpath(XpathCreateApplicate.CREATE));
            createApplication.click();
            Thread.sleep(1000);
            WebElement createNewApplication = driver.findElement(By.xpath(XpathCreateApplicate.CREATE_NEW_APPLICATION));
            createNewApplication.click();
            Thread.sleep(1000);
            WebElement applicationForChangeOfData = driver.findElement(By.xpath(XpathCreateApplicate.APPLICATION_FOR_CHANGE_OF_DATA));
            applicationForChangeOfData.click();
            Thread.sleep(35000);

            // Get data of the PRODUCTORDERNUMBER
            WebElement field_PRODUCTORDERNUMBER = driver.findElement(By
                    .xpath(XpathAuthorization.FIELD_PRODUCTORDERNUMBER));
            productOrderNumber = DataConversion.getProductOrderNumber(field_PRODUCTORDERNUMBER.getText());
            // Get data of the FB_PRODUCTORDERID
            WebElement field_PRODUCTORDER = driver.findElement(By
                    .xpath(XpathAuthorization.FIELD_PRODUCTORDER));
            fb_productOrderID = DataConversion.getFB_ProductOrderID(field_PRODUCTORDER.getAttribute("action"));
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---------------");
        System.out.println(productOrderNumber);
        System.out.println("Application successfully created!");

        try {

            // Insert new data to the application in DB
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");
            Statement statement = connection.createStatement();

            // Read the script into a variable
            String SQLQuery = "";
            File file = new File("Auto_create_2.sql");
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "windows-1251"));
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            String ls = " \n";
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            // Insert fb_productOrderID to script
            SQLQuery = stringBuilder.toString();
            reader.close();
            SQLQuery = SQLQuery.replace("Infor_ID", fb_productOrderID);

            PreparedStatement ps = connection.prepareStatement(SQLQuery);
            ps.execute();
            System.out.println("Data was inserted to Application!");

            connection.close();

        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        driver.navigate().refresh();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
