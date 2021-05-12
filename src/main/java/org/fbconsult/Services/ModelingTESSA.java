package org.fbconsult.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class ModelingTESSA {

    final static String separator = " \n";

    public static void deliveryForVerification(String fb_productOrderID, Connection connection_NM_CRM) {

        try {

            // Read the xml-file into a variable
            File tessa_1_file = new File("TESSA_1_response.xml");
            BufferedReader tessa_1_reader = new BufferedReader(new InputStreamReader(new FileInputStream(tessa_1_file), "windows-1251"));
            String line_tessa_1;
            StringBuilder sb_tessa_1 = new StringBuilder();
            while ((line_tessa_1 = tessa_1_reader.readLine()) != null) {
                sb_tessa_1.append(line_tessa_1);
                sb_tessa_1.append(separator);
            }

            // Insert fb_productOrderID to script
            String TESSA_1_response = sb_tessa_1.toString();
            tessa_1_reader.close();
            TESSA_1_response = TESSA_1_response.replace("Infor_ID", fb_productOrderID);

            //Update IN_MSG field into NM_CRM.EVENT_TABLE
            PreparedStatement ps_TESSA_1 = connection_NM_CRM.prepareStatement(
                    "UPDATE NM_CRM.EVENT_TABLE " +
                            "SET " +
                            "IN_MSG = '" + TESSA_1_response + "' " +
                            "WHERE ID = '5'"
            );
            ps_TESSA_1.execute();


            // Read the script into a variable
            File tessa_1_response_file = new File("Response_From_Tessa_Receiving.sql");
            BufferedReader reader_tessa_1_response = new BufferedReader(new InputStreamReader(new FileInputStream(tessa_1_response_file), "windows-1251"));
            String line_tessa_1_response;
            StringBuilder stringBuilder_2 = new StringBuilder();
            while ((line_tessa_1_response = reader_tessa_1_response.readLine()) != null) {
                stringBuilder_2.append(line_tessa_1_response);
                stringBuilder_2.append(separator);
            }
            String SQL_Tessa_1_Response = stringBuilder_2.toString();
            reader_tessa_1_response.close();
            // Insert response to DB
            PreparedStatement ps_NM_CRM = connection_NM_CRM.prepareStatement(SQL_Tessa_1_Response);
            ps_NM_CRM.execute();
            Thread.sleep(5000);

            System.out.println();
            System.out.println("-> Получен ответ от Тессы о доставке xml с данными для верификации ->");

        } catch (InterruptedException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }


    public static void successfullyVerified(String productOrderNumber, Connection connection_NM_CRM) {

        try {

            // Read the xml-file into a variable
            File tessa_3_file = new File("TESSA_3_response.xml");
            BufferedReader tessa_3_reader = new BufferedReader(new InputStreamReader(new FileInputStream(tessa_3_file), StandardCharsets.UTF_8));
            String line_tessa_3;
            StringBuilder sb_tessa_3 = new StringBuilder();
            while ((line_tessa_3 = tessa_3_reader.readLine()) != null) {
                sb_tessa_3.append(line_tessa_3);
                sb_tessa_3.append(separator);
            }

            // Insert ProductOrderNumber to xml
            String TESSA_3_response = sb_tessa_3.toString();
            tessa_3_reader.close();
            TESSA_3_response = TESSA_3_response.replace("Infor_ProductOrderNumber", productOrderNumber);


            //Update IN_MSG field into NM_CRM.EVENT_TABLE
            // Read the sql-file into a variable
            File script_file = new File("Script_to_CLOB.sql");
            BufferedReader script_reader = new BufferedReader(new InputStreamReader(new FileInputStream(script_file), "windows-1251"));
            String line_script;
            StringBuilder sb_script = new StringBuilder();
            while ((line_script = script_reader.readLine()) != null) {
                sb_script.append(line_script);
                sb_script.append(separator);
            }

            // Insert ProductOrderNumber to xml
            String Script_to_CLOB = sb_script.toString();
            script_reader.close();
            Script_to_CLOB = Script_to_CLOB.replace("Very_long_string_value", TESSA_3_response);

            PreparedStatement ps_script = connection_NM_CRM.prepareStatement(Script_to_CLOB);
            ps_script.execute();


            // Read the script into a variable
            File tessa_3_response_file = new File("Response_From_Tessa_Receiving.sql");
            BufferedReader reader_tessa_3_response = new BufferedReader(new InputStreamReader(new FileInputStream(tessa_3_response_file), "windows-1251"));
            String line_tessa_3_response;
            StringBuilder stringBuilder_3 = new StringBuilder();
            while ((line_tessa_3_response = reader_tessa_3_response.readLine()) != null) {
                stringBuilder_3.append(line_tessa_3_response);
                stringBuilder_3.append(separator);
            }
            String SQL_Tessa_3_Response = stringBuilder_3.toString();
            reader_tessa_3_response.close();
            // Insert response to DB
            PreparedStatement ps_Tessa_3_Response = connection_NM_CRM.prepareStatement(SQL_Tessa_3_Response);
            ps_Tessa_3_Response.execute();
            Thread.sleep(13000);

            System.out.println();
            System.out.println("-> Получен ответ от Тессы о успешной верификации ->");
            System.out.println();

        } catch (InterruptedException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }


    public static void returnForRevision(String productOrderNumber, Connection connection_NM_CRM) {

    }
}
