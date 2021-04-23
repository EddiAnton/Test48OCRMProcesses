package Tests;

import Services.Application;
import Services.DataConversion;
import Services.ModelingCFT;
import Services.ModelingTESSA;
import Services.Rerty;
import Services.TestEnvironment;
import Services.XpathAuthorization;
import Services.XpathCreateApplicate;
import Services.XpathTestProcessStage;

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

public class TestProcess_E2E {

    String productOrderNumber = null;
    String fb_productOrderID = null;

    String applicationStage = null;
    String applicationStatus = null;

    @Parameters({"contour"})
    @Test(retryAnalyzer = Rerty.class)
    public void goProcessE2E(String contour) {

        TestEnvironment testEnvironment = new TestEnvironment(contour);

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection_SYSDBA = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");
            Connection connection_NM_CRM = DriverManager.getConnection(testEnvironment.getDB_data(), "NM_CRM", "masterkey");
            Statement statement_SYSDBA = connection_SYSDBA.createStatement();

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

            /** Create application */

            Application.createApplication(testEnvironment, driver);

            /*// Enter INN in the field to search for a client and confirm your choice
            WebElement inputINN = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathCreateApplicate.FIELD_INN_OR_ACCOUNTNAME)));
            inputINN.sendKeys(testEnvironment.getInn());

            WebElement confirmSelected = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathCreateApplicate.CONFIRM_SELECTED_CUSTOMER)));
            confirmSelected.click();

            new WebDriverWait(driver, 15).until(
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

            new WebDriverWait(driver, 50).until(
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


            // Database connection
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection_SYSDBA = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");
            Connection connection_NM_CRM = DriverManager.getConnection(testEnvironment.getDB_data(), "NM_CRM", "masterkey");
            Statement statement_SYSDBA = connection_SYSDBA.createStatement();


            // Insert new data to the application in DB
            // Read the script into a variable
            String SQL_Create_Applicate;
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
            SQL_Create_Applicate = stringBuilder.toString();
            reader.close();
            SQL_Create_Applicate = SQL_Create_Applicate.replace("Infor_ID", fb_productOrderID);

            PreparedStatement ps_SYSDBA = connection_SYSDBA.prepareStatement(SQL_Create_Applicate);
            ps_SYSDBA.execute();
            System.out.println("Data was inserted to Application!");


            // Get the current data on the application
            Thread.sleep(15000);
            driver.navigate().refresh();*/

            // Get data of the PRODUCTORDERNUMBER
            WebElement field_PRODUCTORDERNUMBER = new WebDriverWait(driver, 30).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.FIELD_PRODUCTORDERNUMBER)));
            productOrderNumber = DataConversion.getProductOrderNumber(field_PRODUCTORDERNUMBER.getText());

            // Get data of the FB_PRODUCTORDERID
            WebElement field_PRODUCTORDER = driver.findElement(By
                    .xpath(XpathAuthorization.FIELD_PRODUCTORDER));
            fb_productOrderID = DataConversion.getFB_ProductOrderID(field_PRODUCTORDER.getAttribute("baseURI"));

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
            if (contour.equals("8083")) {
                new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathTestProcessStage.STATUS_SUBMITTING_FOR_VERIFICATION_8083))).click();
            } else {
                new WebDriverWait(driver, 10).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathTestProcessStage.STATUS_SUBMITTING_FOR_VERIFICATION_8092))).click();
            }

            WebElement nextStage = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathTestProcessStage.BUTTON_NEXT_STAGE)));
            nextStage.click();
            System.out.println();
            System.out.println("-> Выполняется переход на следующую стадию! ->");
            System.out.println();
            Thread.sleep(10000);

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


            /** Modeling a response from Tessa about receiving a verification request. **/

            Thread.sleep(13000);
            ModelingTESSA.deliveryForVerification(fb_productOrderID, connection_NM_CRM);


            /** Modeling the response from Tessa about the verification of the application. **/

            ModelingTESSA.successfullyVerified(productOrderNumber, connection_NM_CRM);

            Thread.sleep(10000);
            System.out.println("-> Отправляется запрос на обновление данных в ЦФТ ->");
            System.out.println();

            // Get the current data on the application
            driver.navigate().refresh();

            // Get the current data on the application
            // Get data of the application Stage
            ResultSet rs_stageName_4 = statement_SYSDBA.executeQuery(selectTableSQLForStageName);
            while (rs_stageName_4.next()) {
                applicationStage = rs_stageName_4.getString("STAGENAME");
            }
            // Get data of the application Status
            WebElement field_applicationStatus_new2 = new WebDriverWait(driver, 20).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathTestProcessStage.FIELD_APPLICATION_STATUS)));
            applicationStatus = field_applicationStatus_new2.getText();

            System.out.println("---------------");
            System.out.println("Стадия заявки: " + applicationStage);
            System.out.println("Статус заявки: " + applicationStatus);


            /** Modeling a response from CFT about a successful update. **/

            ModelingCFT.successfullyUpdated(fb_productOrderID, connection_NM_CRM, connection_SYSDBA);
            Thread.sleep(10000);
            driver.navigate().refresh();


            // Get the current data on the application
            // Get data of the application Stage
            ResultSet rs_stageName_5 = statement_SYSDBA.executeQuery(selectTableSQLForStageName);
            while (rs_stageName_5.next()) {
                applicationStage = rs_stageName_5.getString("STAGENAME");
            }
            // Get data of the application Status
            WebElement field_applicationStatus_cft = new WebDriverWait(driver, 20).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathTestProcessStage.FIELD_APPLICATION_STATUS)));
            applicationStatus = field_applicationStatus_cft.getText();

            System.out.println("---------------");
            System.out.println("Стадия заявки: " + applicationStage);
            System.out.println("Статус заявки: " + applicationStatus);

        } catch (InterruptedException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
