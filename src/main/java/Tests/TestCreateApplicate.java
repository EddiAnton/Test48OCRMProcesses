package Tests;

import Services.DataConversion;
import Services.Rerty;
import Services.TestEnvironment;
import Services.XpathAuthorization;
import Services.XpathCreateApplicate;
import Services.XpathTestProcessStage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCreateApplicate {

    String productOrderNumber = null;
    String fb_productOrderID = null;

    @Parameters({"contour"})
    @Test(retryAnalyzer = Rerty.class)
    public void createApplicate(String contour) {

        TestEnvironment testEnvironment = new TestEnvironment(contour);

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            driver.get(testEnvironment.getUrl());
            driver.manage().window().maximize();

            WebElement logoffHref = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(By.linkText(XpathAuthorization.LOG_OFF_HREF)));
            logoffHref.click();

            // Authorization in system
            WebElement inputUserName = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.INPUT_USERNAME)));
            inputUserName.sendKeys(testEnvironment.getUserName());

            WebElement inputPassword = driver.findElement(By.xpath(XpathAuthorization.INPUT_PASSWORD));
            inputPassword.sendKeys(testEnvironment.getPassword());

            WebElement submitButton = driver.findElement(By.xpath(XpathAuthorization.SUBMIT_BUTTON));
            submitButton.click();

            // Enter to "Clients"
            WebElement clientsTab = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathCreateApplicate.CLIENTS_TAB)));
            clientsTab.click();


            // Enter INN in the field to search for a client and confirm your choice
            WebElement inputINN = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathCreateApplicate.FIELD_INN_OR_ACCOUNTNAME)));
            inputINN.sendKeys(testEnvironment.getInn());

            WebElement confirmSelected = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathCreateApplicate.CONFIRM_SELECTED_CUSTOMER)));
            confirmSelected.click();

            WebElement clientLoaded = new WebDriverWait(driver, 15).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathCreateApplicate.CLIENT_LOADED)));

            WebElement createApplication = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathCreateApplicate.CREATE)));
            createApplication.click();

            WebElement createNewApplication = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathCreateApplicate.CREATE_NEW_APPLICATION)));
            createNewApplication.click();

            WebElement applicationForChangeOfData = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathCreateApplicate.APPLICATION_FOR_CHANGE_OF_DATA)));
            applicationForChangeOfData.click();

            WebElement clientCreated = new WebDriverWait(driver, 60).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathTestProcessStage.FIELD_APPLICATION_STATUS)));
            Thread.sleep(2000);

            // Get data of the PRODUCTORDERNUMBER
            WebElement field_PRODUCTORDERNUMBER = new WebDriverWait(driver, 60).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.FIELD_PRODUCTORDERNUMBER)));
            productOrderNumber = DataConversion.getProductOrderNumber(field_PRODUCTORDERNUMBER.getText());
            // Get data of the FB_PRODUCTORDERID
            WebElement field_PRODUCTORDER = driver.findElement(By
                    .xpath(XpathAuthorization.FIELD_PRODUCTORDER));
            fb_productOrderID = DataConversion.getFB_ProductOrderID(field_PRODUCTORDER.getAttribute("baseURI"));


            System.out.println("---- " + fb_productOrderID + " ----");

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

            // Read the script into a variable
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
            String SQLQuery = stringBuilder.toString();
            reader.close();
            SQLQuery = SQLQuery.replace("Infor_ID", fb_productOrderID);

            PreparedStatement ps = connection.prepareStatement(SQLQuery);
            ps.execute();
            System.out.println("Data was inserted to Application!");

            connection.close();

        } catch (SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
            driver.navigate().refresh();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.close();
    }
}
