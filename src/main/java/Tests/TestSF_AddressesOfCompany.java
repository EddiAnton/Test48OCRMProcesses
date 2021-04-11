package Tests;

import Services.DataComparison;
import Services.DataConversion;
import Services.TestEnvironment;
import Services.XpathAddress;
import Services.XpathAuthorization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class TestSF_AddressesOfCompany {

    String requestMask = "UC-TSP";
    String productOrderNumber = null;

    String test_OKATO = null;
    String test_OKTMO = null;
    String test_ADDRESSTYPE = null;
    String test_COUNTRY = null;
    String test_POSTALCODE = null;
    String test_COUNTY = null;
    String test_DISTRICT = null;
    String test_CITY = null;
    String test_STREET = null;
    String test_HOUSE = null;
    String test_CORPUS = null;
    String test_APARTMENT = null;
    String test_FULLADDRESS = null;

    String okato_type_1 = null;
    String oktmo_type_1 = null;
    String addresstype_type_1 = null;
    String country_type_1 = null;
    String postalcode_type_1 = null;
    String county_type_1 = null;
    String district_type_1 = null;
    String city_type_1 = null;
    String street_type_1 = null;
    String house_type_1 = null;
    String corpus_type_1 = null;
    String apartment_type_1 = null;
    String fulladdress_type_1 = null;

    String okato_type_2 = null;
    String oktmo_type_2 = null;
    String addresstype_type_2 = null;
    String country_type_2 = null;
    String postalcode_type_2 = null;
    String county_type_2 = null;
    String district_type_2 = null;
    String city_type_2 = null;
    String street_type_2 = null;
    String house_type_2 = null;
    String corpus_type_2 = null;
    String apartment_type_2 = null;
    String fulladdress_type_2 = null;

    String okato_type_3 = null;
    String oktmo_type_3 = null;
    String addresstype_type_3 = null;
    String country_type_3 = null;
    String postalcode_type_3 = null;
    String county_type_3 = null;
    String district_type_3 = null;
    String city_type_3 = null;
    String street_type_3 = null;
    String house_type_3 = null;
    String corpus_type_3 = null;
    String apartment_type_3 = null;
    String fulladdress_type_3 = null;

    @Parameters({"contour"})
    @Test
    public void testAddressesOfCompany(String contour) {

        TestEnvironment testEnvironment = new TestEnvironment(contour);

        System.setProperty("webdriver.chrome.driver",
                "D:\\selenium\\drivers\\chromedriver_88\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        try {

            driver.get(testEnvironment.getUrl());
            driver.manage().window().maximize();

            WebElement logoffHref = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.elementToBeClickable(By.linkText(XpathAuthorization.LOG_OFF_HREF)));
            logoffHref.click();

            // Authorization in system
            WebElement inputUserName = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.INPUT_USERNAME)));
            inputUserName.sendKeys(testEnvironment.getUserName());

            WebElement inputPassword = driver.findElement(By.xpath(XpathAuthorization.INPUT_PASSWORD));
            inputPassword.sendKeys(testEnvironment.getPassword());

            WebElement submitButton = driver.findElement(By.xpath(XpathAuthorization.SUBMIT_BUTTON));
            submitButton.click();
            Thread.sleep(1000);

            // Enter to "Data change requests"
            WebElement requestsHref = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.REQUESTS_HREF)));
            requestsHref.click();

            // Select UC requests
            WebElement filterUC = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathAuthorization.FILTER_UC_TSP)));
            filterUC.click();

            WebElement inputNumberOfRequest = new WebDriverWait(driver, 10).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.INPUT_UC_TSP)));
            inputNumberOfRequest.sendKeys(requestMask);

            WebElement submitSelect = driver.findElement(By.xpath(XpathAuthorization.SUBMIT_SELECT));
            submitSelect.click();

            // Sort search result
            WebElement sortByModifiedDate;
            if (contour.equals("8083")) {
                sortByModifiedDate = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathAuthorization.SORT_BY_MODIFIED_DATE_83)));
            } else {
                sortByModifiedDate = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.elementToBeClickable(By.xpath(XpathAuthorization.SORT_BY_MODIFIED_DATE)));
            }
            sortByModifiedDate.click();
            Thread.sleep(1000);
            sortByModifiedDate.click();

            // Open the last application
            WebElement lastApplication = new WebDriverWait(driver, 15).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathAuthorization.LAST_APPLICATION)));
            lastApplication.click();

            // Get data of the PRODUCTORDERNUMBER
            WebElement field_PRODUCTORDERNUMBER = new WebDriverWait(driver, 20).until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAuthorization.FIELD_PRODUCTORDERNUMBER)));
            productOrderNumber = DataConversion.getProductOrderNumber(field_PRODUCTORDERNUMBER.getText());

            // Select the Address tab
            WebElement addressTab = new WebDriverWait(driver, 15).until(
                    ExpectedConditions.elementToBeClickable(By.xpath(XpathAddress.ADDRESS_TAB)));
            addressTab.click();

            // Get data OKATO & OKTMO
            WebElement field_OKATO;
            if (contour.equals("8083")) {
                field_OKATO = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAddress.FIELD_OKATO_8083)));
            } else {
                field_OKATO = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAddress.FIELD_OKATO_8092)));
            }
            test_OKATO = field_OKATO.getAttribute("value");

            WebElement field_OKTMO;
            if (contour.equals("8083")) {
                field_OKTMO = driver.findElement(By.xpath(XpathAddress.FIELD_OKTMO_8083));
            } else {
                field_OKTMO = driver.findElement(By.xpath(XpathAddress.FIELD_OKTMO_8092));
            }
            test_OKTMO = field_OKTMO.getAttribute("value");

            // Disclose data on the Address - " V "
            WebElement openAddress;
            if (contour.equals("8083")) {
                openAddress = driver.findElement(By.xpath(XpathAddress.OPEN_ADDRESS_8083));
            } else {
                openAddress = driver.findElement(By.xpath(XpathAddress.OPEN_ADDRESS_8092));
            }
            openAddress.click();

            // Get data of the Address type
            WebElement field_ADDRESSTYPE;
            if (contour.equals("8083")) {
                field_ADDRESSTYPE = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAddress.FIELD_ADDRESSTYPE_8083)));
            } else {
                field_ADDRESSTYPE = new WebDriverWait(driver, 15).until(
                        ExpectedConditions.presenceOfElementLocated(By.xpath(XpathAddress.FIELD_ADDRESSTYPE_8092)));
            }
            test_ADDRESSTYPE = field_ADDRESSTYPE.getAttribute("value");

            WebElement field_COUNTRY;
            if (contour.equals("8083")) {
                field_COUNTRY = driver.findElement(By.xpath(XpathAddress.FIELD_COUNTRY_8083));
            } else {
                field_COUNTRY = driver.findElement(By.xpath(XpathAddress.FIELD_COUNTRY_8092));
            }
            test_COUNTRY = field_COUNTRY.getAttribute("value");

            WebElement field_POSTALCODE;
            if (contour.equals("8083")) {
                field_POSTALCODE = driver.findElement(By.xpath(XpathAddress.FIELD_POSTALCODE_8083));
            } else {
                field_POSTALCODE = driver.findElement(By.xpath(XpathAddress.FIELD_POSTALCODE_8092));
            }
            test_POSTALCODE = field_POSTALCODE.getAttribute("value");

            WebElement field_COUNTY;
            if (contour.equals("8083")) {
                field_COUNTY = driver.findElement(By.xpath(XpathAddress.FIELD_COUNTY_8083));
            } else {
                field_COUNTY = driver.findElement(By.xpath(XpathAddress.FIELD_COUNTY_8092));
            }
            test_COUNTY = field_COUNTY.getAttribute("value");

            WebElement field_DISTRICT;
            if (contour.equals("8083")) {
                field_DISTRICT = driver.findElement(By.xpath(XpathAddress.FIELD_DISTRICT_8083));
            } else {
                field_DISTRICT = driver.findElement(By.xpath(XpathAddress.FIELD_DISTRICT_8092));
            }
            test_DISTRICT = field_DISTRICT.getAttribute("value");

            WebElement field_CITY;
            if (contour.equals("8083")) {
                field_CITY = driver.findElement(By.xpath(XpathAddress.FIELD_CITY_8083));
            } else {
                field_CITY = driver.findElement(By.xpath(XpathAddress.FIELD_CITY_8092));
            }
            test_CITY = field_CITY.getAttribute("value");

            WebElement field_STREET;
            if (contour.equals("8083")) {
                field_STREET = driver.findElement(By.xpath(XpathAddress.FIELD_STREET_8083));
            } else {
                field_STREET = driver.findElement(By.xpath(XpathAddress.FIELD_STREET_8092));
            }
            test_STREET = field_STREET.getAttribute("value");

            WebElement field_HOUSE;
            if (contour.equals("8083")) {
                field_HOUSE = driver.findElement(By.xpath(XpathAddress.FIELD_HOUSE_8083));
            } else {
                field_HOUSE = driver.findElement(By.xpath(XpathAddress.FIELD_HOUSE_8092));
            }
            test_HOUSE = field_HOUSE.getAttribute("value");

            WebElement field_CORPUS;
            if (contour.equals("8083")) {
                field_CORPUS = driver.findElement(By.xpath(XpathAddress.FIELD_CORPUS_8083));
            } else {
                field_CORPUS = driver.findElement(By.xpath(XpathAddress.FIELD_CORPUS_8092));
            }
            test_CORPUS = field_CORPUS.getAttribute("value");

            WebElement field_APARTMENT;
            if (contour.equals("8083")) {
                field_APARTMENT = driver.findElement(By.xpath(XpathAddress.FIELD_APARTMENT_8083));
            } else {
                field_APARTMENT = driver.findElement(By.xpath(XpathAddress.FIELD_APARTMENT_8092));
            }
            test_APARTMENT = field_APARTMENT.getAttribute("value");

            WebElement field_FULLADDRESS;
            if (contour.equals("8083")) {
                field_FULLADDRESS = driver.findElement(By.xpath(XpathAddress.FIELD_FULLADDRESS_8083));
            } else {
                field_FULLADDRESS = driver.findElement(By.xpath(XpathAddress.FIELD_FULLADDRESS_8092));
            }
            test_FULLADDRESS = field_FULLADDRESS.getAttribute("value");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.close();
        }

        System.out.println(productOrderNumber);
        System.out.println("---------------");
        System.out.println(test_OKATO);
        System.out.println(test_OKTMO);
        System.out.println(test_ADDRESSTYPE);
        System.out.println(test_COUNTRY);
        System.out.println(test_POSTALCODE);
        System.out.println(test_COUNTY);
        System.out.println(test_DISTRICT);
        System.out.println(test_CITY);
        System.out.println(test_STREET);
        System.out.println(test_HOUSE);
        System.out.println(test_CORPUS);
        System.out.println(test_APARTMENT);
        System.out.println(test_FULLADDRESS);
        System.out.println("---------------");

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection(testEnvironment.getDB_data(), "SYSDBA", "masterkey");

            Statement statement = connection.createStatement();

            String selectCodeAddressTypeSQL = "select pl.shorttext " +
                    "from picklist pl " +
                    "inner join picklist pln " +
                    "on pln.itemid = pl.picklistid " +
                    "and pln.picklistid = 'PICKLISTLIST' " +
                    "where pln.text = 'Тип адреса' " +
                    "and pl.TEXT = '" + test_ADDRESSTYPE + "'";

            String codeAddressType = null;
            ResultSet rs_cat = statement.executeQuery(selectCodeAddressTypeSQL);
            while (rs_cat.next()) {
                codeAddressType = rs_cat.getString("SHORTTEXT");
            }

            String selectTableSQLForType_1 = "SELECT fbpomd.OKATO, " +
                    "fbpomd.OKTMO, " +
                    "fbpomad.ADDRESSTYPE, " +
                    "fbpomad.COUNTRY, " +
                    "fbpomad.POSTALCODE, " +
                    "fbpomad.COUNTY, " +
                    "fbpomad.DISTRICT, " +
                    "fbpomad.CITY, " +
                    "fbpomad.STREET, " +
                    "fbpomad.HOUSE, " +
                    "fbpomad.CORPUS, " +
                    "fbpomad.APARTMENT, " +
                    "fbpomad.FULLADDRESS " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_ADDR fbpomad " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpomad.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '1'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomad.ADDRESSTYPE = '" + codeAddressType + "'";

            String selectTableSQLForType_2 = "SELECT fbpomd.OKATO, " +
                    "fbpomd.OKTMO, " +
                    "fbpomad.ADDRESSTYPE, " +
                    "fbpomad.COUNTRY, " +
                    "fbpomad.POSTALCODE, " +
                    "fbpomad.COUNTY, " +
                    "fbpomad.DISTRICT, " +
                    "fbpomad.CITY, " +
                    "fbpomad.STREET, " +
                    "fbpomad.HOUSE, " +
                    "fbpomad.CORPUS, " +
                    "fbpomad.APARTMENT, " +
                    "fbpomad.FULLADDRESS " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_ADDR fbpomad " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpomad.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '2'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomad.ADDRESSTYPE = '" + codeAddressType + "'";

            String selectTableSQLForType_3 = "SELECT fbpomd.OKATO, " +
                    "fbpomd.OKTMO, " +
                    "fbpomad.ADDRESSTYPE, " +
                    "fbpomad.COUNTRY, " +
                    "fbpomad.POSTALCODE, " +
                    "fbpomad.COUNTY, " +
                    "fbpomad.DISTRICT, " +
                    "fbpomad.CITY, " +
                    "fbpomad.STREET, " +
                    "fbpomad.HOUSE, " +
                    "fbpomad.CORPUS, " +
                    "fbpomad.APARTMENT, " +
                    "fbpomad.FULLADDRESS " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_ADDR fbpomad " +
                    "INNER JOIN sysdba.fb_productordmemb_data fbpomd " +
                    "ON fbpomad.fb_productordmemb_dataid = fbpomd.fb_productordmemb_dataid " +
                    "INNER JOIN sysdba.fb_productordermember fbpom " +
                    "ON fbpomd.fb_productordermemberid = fbpom.fb_productordermemberid " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.PRODUCTORDERNUMBER = '" + productOrderNumber + "'" +
                    "AND fbpomd.MEMBERDATATYPE = '3'" +
                    "AND fbpomd.ISPRIMARY = 'T'" +
                    "AND fbpomad.ADDRESSTYPE = '" + codeAddressType + "'";


            // Get data for type 1 from the database
            ResultSet rs_1 = statement.executeQuery(selectTableSQLForType_1);

            // if something was received then the while loop will work
            while (rs_1.next()) {
                okato_type_1 = rs_1.getString("OKATO");
                oktmo_type_1 = rs_1.getString("OKTMO");
                addresstype_type_1 = rs_1.getString("ADDRESSTYPE");
                country_type_1 = rs_1.getString("COUNTRY");
                postalcode_type_1 = rs_1.getString("POSTALCODE");
                county_type_1 = rs_1.getString("COUNTY");
                district_type_1 = rs_1.getString("DISTRICT");
                city_type_1 = rs_1.getString("CITY");
                street_type_1 = rs_1.getString("STREET");
                house_type_1 = rs_1.getString("HOUSE");
                corpus_type_1 = rs_1.getString("CORPUS");
                apartment_type_1 = rs_1.getString("APARTMENT");
                fulladdress_type_1 = rs_1.getString("FULLADDRESS");
            }

            // Get data for type 2 from the database
            ResultSet rs_2 = statement.executeQuery(selectTableSQLForType_2);

            // if something was received then the while loop will work
            while (rs_2.next()) {
                okato_type_2 = rs_2.getString("OKATO");
                oktmo_type_2 = rs_2.getString("OKTMO");
                addresstype_type_2 = rs_2.getString("ADDRESSTYPE");
                country_type_2 = rs_2.getString("COUNTRY");
                postalcode_type_2 = rs_2.getString("POSTALCODE");
                county_type_2 = rs_2.getString("COUNTY");
                district_type_2 = rs_2.getString("DISTRICT");
                city_type_2 = rs_2.getString("CITY");
                street_type_2 = rs_2.getString("STREET");
                house_type_2 = rs_2.getString("HOUSE");
                corpus_type_2 = rs_2.getString("CORPUS");
                apartment_type_2 = rs_2.getString("APARTMENT");
                fulladdress_type_2 = rs_2.getString("FULLADDRESS");
            }

            // Get data for type 3 from the database
            ResultSet rs_3 = statement.executeQuery(selectTableSQLForType_3);

            // if something was received then the while loop will work
            while (rs_3.next()) {
                okato_type_3 = rs_3.getString("OKATO");
                oktmo_type_3 = rs_3.getString("OKTMO");
                addresstype_type_3 = rs_3.getString("ADDRESSTYPE");
                country_type_3 = rs_3.getString("COUNTRY");
                postalcode_type_3 = rs_3.getString("POSTALCODE");
                county_type_3 = rs_3.getString("COUNTY");
                district_type_3 = rs_3.getString("DISTRICT");
                city_type_3 = rs_3.getString("CITY");
                street_type_3 = rs_3.getString("STREET");
                house_type_3 = rs_3.getString("HOUSE");
                corpus_type_3 = rs_3.getString("CORPUS");
                apartment_type_3 = rs_3.getString("APARTMENT");
                fulladdress_type_3 = rs_3.getString("FULLADDRESS");
            }

            connection.close();

        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }

        if (Objects.equals(test_OKATO, DataComparison.compareData(okato_type_1, okato_type_2, okato_type_3))) {
            System.out.println("OKATO test passed!");
        } else {
            System.out.println("OKATO test failed! - X");
        }

        if (Objects.equals(test_OKTMO, DataComparison.compareData(oktmo_type_1, oktmo_type_2, oktmo_type_3))) {
            System.out.println("OKTMO test passed!");
        } else {
            System.out.println("OKTMO test failed! - X");
        }

        if (Objects.equals(test_ADDRESSTYPE, DataComparison.compareData(addresstype_type_1, addresstype_type_2, addresstype_type_3))) {
            System.out.println("ADDRESSTYPE test passed!");
        } else {
            System.out.println("ADDRESSTYPE test failed! - X");
        }

        if (Objects.equals(test_COUNTRY, DataComparison.compareData(country_type_1, country_type_2, country_type_3))) {
            System.out.println("COUNTRY test passed!");
        } else {
            System.out.println("COUNTRY test failed! - X");
        }

        if (Objects.equals(test_POSTALCODE, DataComparison.compareData(postalcode_type_1, postalcode_type_2, postalcode_type_3))) {
            System.out.println("POSTALCODE test passed!");
        } else {
            System.out.println("POSTALCODE test failed! - X");
        }

        if (Objects.equals(test_COUNTY, DataComparison.compareData(county_type_1, county_type_2, county_type_3))) {
            System.out.println("COUNTY test passed!");
        } else {
            System.out.println("COUNTY test failed! - X");
        }

        if (Objects.equals(test_DISTRICT, DataComparison.compareData(district_type_1, district_type_2, district_type_3))) {
            System.out.println("DISTRICT test passed!");
        } else {
            System.out.println("DISTRICT test failed! - X");
        }

        if (Objects.equals(test_CITY, DataComparison.compareData(city_type_1, city_type_2, city_type_3))) {
            System.out.println("CITY test passed!");
        } else {
            System.out.println("CITY test failed! - X");
        }

        if (Objects.equals(test_STREET, DataComparison.compareData(street_type_1, street_type_2, street_type_3))) {
            System.out.println("STREET test passed!");
        } else {
            System.out.println("STREET test failed! - X");
        }

        if (Objects.equals(test_HOUSE, DataComparison.compareData(house_type_1, house_type_2, house_type_3))) {
            System.out.println("HOUSE test passed!");
        } else {
            System.out.println("HOUSE test failed! - X");
        }

        if (Objects.equals(test_CORPUS, DataComparison.compareData(corpus_type_1, corpus_type_2, corpus_type_3))) {
            System.out.println("CORPUS test passed!");
        } else {
            System.out.println("CORPUS test failed! - X");
        }

        if (Objects.equals(test_APARTMENT, DataComparison.compareData(apartment_type_1, apartment_type_2, apartment_type_3))) {
            System.out.println("APARTMENT test passed!");
        } else {
            System.out.println("APARTMENT test failed! - X");
        }

        if (Objects.equals(test_FULLADDRESS, DataComparison.compareData(fulladdress_type_1, fulladdress_type_2, fulladdress_type_3))) {
            System.out.println("FULLADDRESS test passed!");
        } else {
            System.out.println("FULLADDRESS test failed! - X");
        }

        System.out.println("----------------------------");
    }
}
