package Tests;

import Services.DataConversion;
import Services.TestEnvironment;
import Services.XpathAuthorization;
import Services.XpathCreateApplicate;
import Services.XpathTestProcessStage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestProcess_E2E {

    String productOrderNumber = null;
    String fb_productOrderID = null;

    String applicationStage = null;
    String applicationStatus = null;

    @Parameters({"contour"})
    @Test
    public void goProcessE2E(String contour) {

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


            // Create Applicate
            WebElement createApplication = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathCreateApplicate.CREATE)));
            createApplication.click();

            WebElement createNewApplication = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathCreateApplicate.CREATE_NEW_APPLICATION)));
            createNewApplication.click();

            WebElement applicationForChangeOfData = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathCreateApplicate.APPLICATION_FOR_CHANGE_OF_DATA)));
            applicationForChangeOfData.click();

            WebElement clientCreated = new WebDriverWait(driver, 50).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathTestProcessStage.FIELD_APPLICATION_STATUS)));


            // Get data of the PRODUCTORDERNUMBER
            WebElement field_PRODUCTORDERNUMBER = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.FIELD_PRODUCTORDERNUMBER)));
            productOrderNumber = DataConversion.getProductOrderNumber(field_PRODUCTORDERNUMBER.getText());

            // Get data of the FB_PRODUCTORDERID
            WebElement field_PRODUCTORDER = driver.findElement(By
                    .xpath(XpathAuthorization.FIELD_PRODUCTORDER));
            fb_productOrderID = DataConversion.getFB_ProductOrderID(field_PRODUCTORDER.getAttribute("baseURI"));

            System.out.println("---- " + fb_productOrderID + " ----");
            System.out.println("---------------");
            System.out.println(productOrderNumber);
            System.out.println("Application successfully created!");


            // Insert new data to the application in DB
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection_SYSDBA = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");
            Connection connection_NM_CRM = DriverManager.getConnection(testEnvironment.getDB_data(), "NM_CRM", "masterkey");
            Statement statement_SYSDBA = connection_SYSDBA.createStatement();
            Statement statement_NM_CRM = connection_NM_CRM.createStatement();

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

            PreparedStatement ps_SYSDBA = connection_SYSDBA.prepareStatement(SQLQuery);
            ps_SYSDBA.execute();
            System.out.println("Data was inserted to Application!");


            // Get the current data on the application
            driver.navigate().refresh();

            // Get data of the application Status
            WebElement field_applicationStatus = new WebDriverWait(driver, 20).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathTestProcessStage.FIELD_APPLICATION_STATUS)));
            applicationStatus = field_applicationStatus.getText();

            // Get data of the application Stage
            String selectTableSQLForStageName = "SELECT ps1.name AS StageName " +
                    "FROM sysdba.fb_processstageaudit psa1 " +
                    "INNER JOIN sysdba.fb_processaudit pa1 " +
                    "ON (psa1.fb_processauditid = pa1.fb_processauditid) " +
                    "INNER JOIN sysdba.fb_processstage ps1 " +
                    "ON (psa1.currentstageid = ps1.fb_processstageid) " +
                    "WHERE pa1.entityid = '" + fb_productOrderID + "' " +
                    "ORDER BY psa1.createdate " +
                    "DESC " +
                    "FETCH NEXT 1 ROWS ONLY";

            ResultSet rs_stageName = statement_SYSDBA.executeQuery(selectTableSQLForStageName);
            while (rs_stageName.next()) {
                applicationStage = rs_stageName.getString("STAGENAME");
            }

            System.out.println("---------------");
            System.out.println("Стадия заявки: " + applicationStage);
            System.out.println("Статус заявки: " + applicationStatus);


            // Go to next stage
            WebElement continueRegistration = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathTestProcessStage.BUTTON_CONTINUE_REGISTRATION)));
            continueRegistration.click();

            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathTestProcessStage.OPEN_STATUS_LIST))).click();
            new WebDriverWait(driver, 10).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathTestProcessStage.STATUS_SUBMITTING_FOR_VERIFICATION))).click();

            WebElement nextStage = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathTestProcessStage.BUTTON_NEXT_STAGE)));
            nextStage.click();
            System.out.println();
            System.out.println("-> Выполняется переход на следующую стадию! ->");
            System.out.println();
            Thread.sleep(5000);

            // Get the current data on the application
            // Get data of the application Status
            applicationStatus = field_applicationStatus.getText();
            // Get data of the application Stage
            ResultSet rs_stageName_2 = statement_SYSDBA.executeQuery(selectTableSQLForStageName);
            while (rs_stageName_2.next()) {
                applicationStage = rs_stageName_2.getString("STAGENAME");
            }

            System.out.println("---------------");
            System.out.println("Стадия заявки: " + applicationStage);
            System.out.println("Статус заявки: " + applicationStatus);


            // Modeling a response from Tessa about receiving a verification request.
            // Read the script into a variable
            String SQLResponse_From_Tessa_Receiving = "";
            File file_2 = new File("Response_From_Tessa_Receiving.sql");
            BufferedReader reader_2 = new BufferedReader(new InputStreamReader(new FileInputStream(file_2), "windows-1251"));
            String line_2;
            StringBuilder stringBuilder_2 = new StringBuilder();
            while ((line_2 = reader_2.readLine()) != null) {
                stringBuilder_2.append(line_2);
                stringBuilder_2.append(ls);
            }
            SQLResponse_From_Tessa_Receiving = stringBuilder_2.toString();
            reader_2.close();
            // Insert response to DB
            PreparedStatement ps_NM_CRM = connection_NM_CRM.prepareStatement(SQLResponse_From_Tessa_Receiving);
            ps_NM_CRM.execute();
            Thread.sleep(5000);

            System.out.println();
            System.out.println("-> Получен ответ от Тессы о доставке xml с данными для верификации ->");
            System.out.println();

            // Get the current data on the application
            driver.navigate().refresh();
            Thread.sleep(5000);

            // Get the current data on the application
            // Get data of the application Status
            applicationStatus = field_applicationStatus.getText();
            // Get data of the application Stage
            ResultSet rs_stageName_3 = statement_SYSDBA.executeQuery(selectTableSQLForStageName);
            while (rs_stageName_3.next()) {
                applicationStage = rs_stageName_3.getString("STAGENAME");
            }

            System.out.println("---------------");
            System.out.println("Стадия заявки: " + applicationStage);
            System.out.println("Статус заявки: " + applicationStatus);


        } catch (InterruptedException | SQLException | ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}
