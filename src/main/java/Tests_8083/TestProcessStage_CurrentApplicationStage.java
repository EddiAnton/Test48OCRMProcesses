package Tests_8083;

import Services.DataConversion;
import Services.XpathAuthorization;
import Services.XpathTestProcessStage;
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

public class TestProcessStage_CurrentApplicationStage {

    final String DB_Data = "jdbc:oracle:thin:@server:1521:slx0";

    String userName = "Admin";
    String requestMask = "UC-TSP";

    String productOrderNumber = null;
    String fb_productOrderID = null;

    String applicationStage = null;
    String applicationStatus = null;
    String typeOfApplicationNumber = null;
    String urlTessa = null;
    String isVerificationNeed = null;
    int resultVerification;

    @Test
    public void checkApplicationStage() {

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            System.out.println();
            System.out.println("Test Current Application Stage is starting...");
            System.out.println();

            Thread.sleep(2000);
            driver.get("http://192.168.1.140:8083/SlxClient/logoff.aspx");
            driver.manage().window().maximize();

            WebElement logoffHref = driver.findElement(By.linkText(XpathAuthorization.LOG_OFF_HREF));
            logoffHref.click();

            Thread.sleep(2000);

            // Authorization in system
            WebElement inputUserName = driver.findElement(By.xpath(XpathAuthorization.INPUT_USERNAME));
            inputUserName.sendKeys(userName);

            WebElement submitButton = driver.findElement(By.xpath(XpathAuthorization.SUBMIT_BUTTON));
            submitButton.click();

            Thread.sleep(2000);

            // Enter to "Data change requests"
            WebElement requestsHref = driver.findElement(By.xpath(XpathAuthorization.REQUESTS_HREF));
            requestsHref.click();

            Thread.sleep(5000);

            // Select UC requests
            WebElement filterUC = driver.findElement(By.xpath(XpathAuthorization.FILTER_UC_TSP));
            filterUC.click();

            Thread.sleep(2000);

            WebElement inputNumberOfRequest = driver.findElement(By.xpath(XpathAuthorization.INPUT_UC_TSP));
            inputNumberOfRequest.sendKeys(requestMask);

            WebElement submitSelect = driver.findElement(By.xpath(XpathAuthorization.SUBMIT_SELECT));
            submitSelect.click();
            Thread.sleep(2000);

            // Sort search result
            WebElement sortByModifiedDate = driver.findElement(By.xpath(XpathAuthorization.SORT_BY_MODIFIED_DATE_83));
            sortByModifiedDate.click();
            Thread.sleep(1000);
            sortByModifiedDate.click();
            Thread.sleep(5000);

            // Open the last application
            WebElement lastApplication = driver.findElement(By.xpath(XpathAuthorization.LAST_APPLICATION));
            lastApplication.click();
            Thread.sleep(2000);

            // Get data of the PRODUCTORDERNUMBER
            WebElement field_PRODUCTORDERNUMBER = driver.findElement(By
                    .xpath(XpathAuthorization.FIELD_PRODUCTORDERNUMBER));
            productOrderNumber = DataConversion.getProductOrderNumber(field_PRODUCTORDERNUMBER.getText());
            // Get data of the FB_PRODUCTORDERID
            WebElement field_PRODUCTORDER = driver.findElement(By
                    .xpath(XpathAuthorization.FIELD_PRODUCTORDER));
            fb_productOrderID = DataConversion.getFB_ProductOrderID(field_PRODUCTORDER.getAttribute("action"));
            Thread.sleep(3000);


            // Get data of the application Stage from DB
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(DB_Data, "SYSDBA", "masterkey");

            Statement statement = connection.createStatement();

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

            ResultSet rs_stageName = statement.executeQuery(selectTableSQLForStageName);
            while (rs_stageName.next()) {
                applicationStage = rs_stageName.getString("STAGENAME");
            }


            // Get data on the conditions of current Application Stage from the DB
            String selectTableSQLForConditions = "SELECT fbpo.CREATESOURCE, fbpo.URLTESSA, " +
                    "fbpo.ISVERIFICATIONNEED " +
                    "fbpo.RESULTVERIFICATION " +
                    "FROM SYSDBA.FB_PRODUCTORDER fbpo " +
                    "WHERE fbpo.FB_PRODUCTORDERID = '" + fb_productOrderID + "'";

            ResultSet rs_conditions = statement.executeQuery(selectTableSQLForConditions);
            while (rs_conditions.next()) {
                typeOfApplicationNumber = rs_conditions.getString("CREATESOURCE");
                urlTessa = rs_conditions.getString("URLTESSA");
                isVerificationNeed = rs_conditions.getString("ISVERIFICATIONNEED");
                resultVerification = Integer.parseInt(rs_conditions.getString("RESULTVERIFICATION"));
            }

            connection.close();


            // Get data of the application Status
            WebElement field_applicationStatus = driver.findElement(By
                    .xpath(XpathTestProcessStage.FIELD_APPLICATION_STATUS));
            applicationStatus = field_applicationStatus.getText();


        } catch (InterruptedException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

        System.out.println("---------------");
        System.out.println(productOrderNumber);
        System.out.println("---------------");
        System.out.println("Стадия заявки: " + applicationStage);
        System.out.println("Статус заявки: " + applicationStatus);

        if (applicationStage.equals("01 Создание заявки в Тесса и запрос в ЦФТ/Прайм – Авто")) {

            if (typeOfApplicationNumber.equals("TSP") && applicationStatus.equals("В работе")) {

                System.out.println("Stage is correct.");
                System.out.println("Test Current Application Stage  passed!");

            } else {

                System.out.println("Test Current Application Stage failed! - X");
                System.out.println("Проверьте условия перехода на текущую стадию");
                System.out.println("Номер заявки имеет вид: TSP  ||  " + typeOfApplicationNumber);
                System.out.println("Возможные статусы: В работе  ||  " + applicationStatus);

            }

            System.out.println("---------------");
        }

        else if (applicationStage.equals("02 Формирование заявки")) {

            if (typeOfApplicationNumber.equals("TSP") && urlTessa != null &&
               (applicationStatus.equals("В работе") || applicationStatus.equals("Отложена") ||
                applicationStatus.equals("Ожидание информации от клиента"))) {

                System.out.println("Stage is correct.");
                System.out.println("Test Current Application Stage  passed!");

            } else {

                System.out.println("Test Current Application Stage failed! - X");
                System.out.println("Проверьте условия перехода на текущую стадию");
                System.out.println("URLTESSA is not null  ||  " + urlTessa);
                System.out.println("Номер заявки имеет вид: TSP  ||  " + typeOfApplicationNumber);
                System.out.println("Возможные статусы: В работе, Отложена, Ожидание информации от клиента  ||  " + applicationStatus);

            }

            System.out.println("---------------");

        }

        else if (applicationStage.equals("02 Назначение встречи и выезд (КВМ ВМ)")) {

            if (typeOfApplicationNumber.equals("TSP") && (applicationStatus.equals("Подписание документов") ||
                applicationStatus.equals("Отложена"))) {

                System.out.println("Stage is correct.");
                System.out.println("Test Current Application Stage  passed!");

            } else {

                System.out.println("Test Current Application Stage failed! - X");
                System.out.println("Проверьте условия перехода на текущую стадию");
                System.out.println("Номер заявки имеет вид: TSP  ||  " + typeOfApplicationNumber);
                System.out.println("Возможные статусы: Подписание документов, Отложена  ||  " + applicationStatus);

            }

            System.out.println("---------------");
        }

        else if (applicationStage.equals("06 Верификация в Тесса – Авто")) {

            if (typeOfApplicationNumber.equals("TSP") && (applicationStatus.equals("На верификации") ||
                applicationStatus.equals("Отправка на верификацию")) && isVerificationNeed.equals("T")) {

                System.out.println("Stage is correct.");
                System.out.println("Test Current Application Stage  passed!");

            } else {

                System.out.println("Test Current Application Stage failed! - X");
                System.out.println("Проверьте условия перехода на текущую стадию");
                System.out.println("Номер заявки имеет вид: TSP  ||  " + typeOfApplicationNumber);
                System.out.println("Возможные статусы: На верификации, Отправка на верификацию  ||  " + applicationStatus);
                System.out.println("Признак ISVERIFICATIONNEED = 'T'  ||  " + isVerificationNeed);

            }

            System.out.println("---------------");
        }

        else if (applicationStage.equals("07 Доработка заявки")) {

            if (typeOfApplicationNumber.equals("TSP") && (applicationStatus.equals("Возврат на доработку") ||
                applicationStatus.equals("Доработка") || applicationStatus.equals("Ожидание информации от клиента") ||
                applicationStatus.equals("Отложена")) && resultVerification != 1) {

                System.out.println("Stage is correct.");
                System.out.println("Test Current Application Stage  passed!");

            } else {

                System.out.println("Test Current Application Stage failed! - X");
                System.out.println("Проверьте условия перехода на текущую стадию");
                System.out.println("Номер заявки имеет вид: TSP  ||  " + typeOfApplicationNumber);
                System.out.println("Возможные статусы: Возврат на доработку, Доработка, Ожидание информации от клиента, Отложена  ||  " + applicationStatus);
                System.out.println("Признак RESULTVERIFICATION != 1  ||  " + resultVerification);

            }

            System.out.println("---------------");
        }

        else if (applicationStage.equals("08 Передача данных в ЦФТ – Авто")) {

        }

        else if (applicationStage.equals("09 Закрытие заявки – Авто")) {

        }
    }

}
