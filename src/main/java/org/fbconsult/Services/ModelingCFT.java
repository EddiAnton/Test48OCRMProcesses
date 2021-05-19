package org.fbconsult.Services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class ModelingCFT {

    final static String separator = " \n";

    public static void successfullyUpdated(String fb_productOrderID, Connection connection_NM_CRM, Connection connection_SYSDBA) {

        try {

            Statement statement_SYSDBA = connection_SYSDBA.createStatement();

            // Получаем ID всех записей с 3 типом в заявке
            String selectForAll_FB_PRODUCTORDMEMB_DATAID = "SELECT fbpomd.FB_PRODUCTORDMEMB_DATAID " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.FB_PRODUCTORDERID = '" + fb_productOrderID + "' " +
                    "AND fbpomd.MEMBERDATATYPE = 3";

            List<String> DATAID_list = new ArrayList<>();
            ResultSet rs_allData = statement_SYSDBA.executeQuery(selectForAll_FB_PRODUCTORDMEMB_DATAID);
            while (rs_allData.next()) {
                DATAID_list.add(rs_allData.getString("FB_PRODUCTORDMEMB_DATAID"));
            }


            // Read the script into a variable
            File cft_response_file = new File("Response_From_CFT_UPD_Receiving.sql");
            BufferedReader reader_cft_response = new BufferedReader(new InputStreamReader(new FileInputStream(cft_response_file), "windows-1251"));
            String line_cft_response;
            StringBuilder sb_cft_response = new StringBuilder();
            while ((line_cft_response = reader_cft_response.readLine()) != null) {
                sb_cft_response.append(line_cft_response);
                sb_cft_response.append(separator);
            }
            String SQL_CFT_Response = sb_cft_response.toString();
            reader_cft_response.close();


            // Read the xml-file into a variable
            File cft_file = new File("CFT_response.xml");
            BufferedReader cft_reader = new BufferedReader(new InputStreamReader(new FileInputStream(cft_file), StandardCharsets.UTF_8));
            String line_cft;
            StringBuilder sb_cft = new StringBuilder();
            while ((line_cft = cft_reader.readLine()) != null) {
                sb_cft.append(line_cft);
                sb_cft.append(separator);
            }
            cft_reader.close();
            Thread.sleep(23000);

            // For each entry in the application
            for (String data : DATAID_list) {
                // Insert fb_productOrderID to script
                String CFT_response = sb_cft.toString();
                CFT_response = CFT_response.replace("Infor_ID", data);

                //Update IN_MSG field into NM_CRM.EVENT_TABLE
                PreparedStatement ps_CFT = connection_NM_CRM.prepareStatement(
                        "UPDATE NM_CRM.EVENT_TABLE " +
                                "SET " +
                                "IN_MSG = '" + CFT_response + "' " +
                                "WHERE ID = '5'"
                );
                ps_CFT.execute();


                // Insert response to DB
                PreparedStatement ps_CFT_response = connection_NM_CRM.prepareStatement(SQL_CFT_Response);
                ps_CFT_response.execute();
                Thread.sleep(3000);

                System.out.println();
                System.out.println("-> Получен ответ от ЦФТ о успешном обновлении данных " + data + " ->");
                System.out.println();

            }

        } catch (InterruptedException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void getCustomerData(String fb_productOrderID, Connection connection_NM_CRM, Connection connection_SYSDBA) {

        final String CFTID_RelatedLegalEntity = "208502545440";
        final String CFTID_RelatedPrivatEntity_1 = "24366923725";
        final String CFTID_RelatedPrivatEntity_2 = "24367483988";


        try {

            Statement statement_SYSDBA = connection_SYSDBA.createStatement();

            // КЛАДЕМ В ОЧЕРЕДЬ ОСНОВНОЕ ЛИЦО
            // Read the CFT_MainClient_part1.xml into a variable
            File mainClient_file_1 = new File("CFT_MainClient_part1.xml");
            BufferedReader mainClient_reader_1 = new BufferedReader(new InputStreamReader(new FileInputStream(mainClient_file_1), StandardCharsets.UTF_8));
            String line_mainClient_file_1;
            StringBuilder sb_mainClient_1 = new StringBuilder();
            while ((line_mainClient_file_1 = mainClient_reader_1.readLine()) != null) {
                sb_mainClient_1.append(line_mainClient_file_1);
                sb_mainClient_1.append(separator);
            }
            // Insert fb_productOrderIDr to xml
            String MainClient_response_1 = sb_mainClient_1.toString();
            MainClient_response_1 = MainClient_response_1.replace("Infor_ID", fb_productOrderID);
            mainClient_reader_1.close();


            // Read the CFT_MainClient_part2.xml into a variable
            File mainClient_file_2 = new File("CFT_MainClient_part2.xml");
            BufferedReader mainClient_reader_2 = new BufferedReader(new InputStreamReader(new FileInputStream(mainClient_file_2), StandardCharsets.UTF_8));
            String line_mainClient_file_2;
            StringBuilder sb_mainClient_2 = new StringBuilder();
            while ((line_mainClient_file_2 = mainClient_reader_2.readLine()) != null) {
                sb_mainClient_2.append(line_mainClient_file_2);
                sb_mainClient_2.append(separator);
            }
            String MainClient_response_2 = sb_mainClient_2.toString();
            mainClient_reader_2.close();


            //Update IN_MSG field into NM_CRM.EVENT_TABLE
            // Read the sql-file into a variable
            File script_file = new File("Script_to_CLOB_2.sql");
            BufferedReader script_reader = new BufferedReader(new InputStreamReader(new FileInputStream(script_file), "windows-1251"));
            String line_script;
            StringBuilder sb_script = new StringBuilder();
            while ((line_script = script_reader.readLine()) != null) {
                sb_script.append(line_script);
                sb_script.append(separator);
            }

            String Script_to_CLOB_2 = sb_script.toString().replace("Very_long_string_value_1", MainClient_response_1);
            Script_to_CLOB_2 = Script_to_CLOB_2.replace("Very_long_string_value_2", MainClient_response_2);
            PreparedStatement ps_script = connection_NM_CRM.prepareStatement(Script_to_CLOB_2);
            ps_script.execute();
            script_reader.close();


            // Read the script into a variable
            File mainClient_response_file = new File("Response_From_CFT_REQ_Receiving.sql");
            BufferedReader reader_mainClient_response = new BufferedReader(new InputStreamReader(new FileInputStream(mainClient_response_file), "windows-1251"));
            String line_mainClient_response;
            StringBuilder stringBuilder_3 = new StringBuilder();
            while ((line_mainClient_response = reader_mainClient_response.readLine()) != null) {
                stringBuilder_3.append(line_mainClient_response);
                stringBuilder_3.append(separator);
            }
            String SQL_MainClient_Response = stringBuilder_3.toString();
            reader_mainClient_response.close();
            // Insert response to DB
            PreparedStatement ps_mainClient_Response = connection_NM_CRM.prepareStatement(SQL_MainClient_Response);
            ps_mainClient_Response.execute();
            Thread.sleep(10000);

            System.out.println();
            System.out.println("-> Получены данные из ЦФТ по основному клиенту ->");
            System.out.println();


            // КЛАДЕМ В ОЧЕРЕДЬ СВЯЗАННОЕ ЮРИДИЧЕСКОЕ ЛИЦО
            // Получаем ID связанного юридического лица в заявке
            String selectForAll_FB_PRODUCTORDMEMB_DATAID = "SELECT fbpomd.FB_PRODUCTORDMEMB_DATAID " +
                    "FROM SYSDBA.FB_PRODUCTORDMEMB_DATA fbpomd " +
                    "JOIN SYSDBA.FB_PRODUCTORDERMEMBER fbpom " +
                    "ON fbpomd.FB_PRODUCTORDERMEMBERID = fbpom.FB_PRODUCTORDERMEMBERID " +
                    "JOIN SYSDBA.FB_PRODUCTORDER fbpo " +
                    "ON fbpom.FB_PRODUCTORDERID = fbpo.FB_PRODUCTORDERID " +
                    "WHERE fbpo.FB_PRODUCTORDERID = '" + fb_productOrderID + "' " +
                    "AND fbpomd.IDCFT = '" + CFTID_RelatedLegalEntity + "'";

            String DATA_RelatedLegalEntity_ID = null;
            ResultSet rs_DataID = statement_SYSDBA.executeQuery(selectForAll_FB_PRODUCTORDMEMB_DATAID);
            while (rs_DataID.next()) {
                DATA_RelatedLegalEntity_ID = rs_DataID.getString("FB_PRODUCTORDMEMB_DATAID");
            }


            // Read the CFT_RelatedLegalEntity_part1.xml into a variable
            File relatedLegalEntity_file_1 = new File("CFT_RelatedLegalEntity_part1.xml");
            BufferedReader relatedLegalEntity_reader_1 = new BufferedReader(new InputStreamReader(new FileInputStream(relatedLegalEntity_file_1), StandardCharsets.UTF_8));
            String line_relatedLegalEntity_file_1;
            StringBuilder sb_relatedLegalEntity_1 = new StringBuilder();
            while ((line_relatedLegalEntity_file_1 = relatedLegalEntity_reader_1.readLine()) != null) {
                sb_relatedLegalEntity_1.append(line_relatedLegalEntity_file_1);
                sb_relatedLegalEntity_1.append(separator);
            }
            // Insert fb_productOrderIDr to xml
            String RelatedLegalEntity_response_1 = sb_relatedLegalEntity_1.toString();
            assert DATA_RelatedLegalEntity_ID != null;
            RelatedLegalEntity_response_1 = RelatedLegalEntity_response_1.replace("Infor_ID", DATA_RelatedLegalEntity_ID);
            relatedLegalEntity_reader_1.close();


            // Read the CFT_RelatedLegalEntity_part2.xml into a variable
            File relatedLegalEntity_file_2 = new File("CFT_RelatedLegalEntity_part2.xml");
            BufferedReader relatedLegalEntity_reader_2 = new BufferedReader(new InputStreamReader(new FileInputStream(relatedLegalEntity_file_2), StandardCharsets.UTF_8));
            String line_relatedLegalEntity_file_2;
            StringBuilder sb_relatedLegalEntity_2 = new StringBuilder();
            while ((line_relatedLegalEntity_file_2 = relatedLegalEntity_reader_2.readLine()) != null) {
                sb_relatedLegalEntity_2.append(line_relatedLegalEntity_file_2);
                sb_relatedLegalEntity_2.append(separator);
            }
            String RelatedLegalEntity_response_2 = sb_relatedLegalEntity_2.toString();
            relatedLegalEntity_reader_2.close();


            //Update IN_MSG field into NM_CRM.EVENT_TABLE
            // Read the sql-file into a variable
            File script_file_rle = new File("Script_to_CLOB_2.sql");
            BufferedReader script_reader_rle = new BufferedReader(new InputStreamReader(new FileInputStream(script_file_rle), "windows-1251"));
            String line_script_rle;
            StringBuilder sb_script_rle = new StringBuilder();
            while ((line_script_rle = script_reader_rle.readLine()) != null) {
                sb_script_rle.append(line_script_rle);
                sb_script_rle.append(separator);
            }

            String Script_to_CLOB_2_rle = sb_script_rle.toString().replace("Very_long_string_value_1", RelatedLegalEntity_response_1);
            Script_to_CLOB_2_rle = Script_to_CLOB_2_rle.replace("Very_long_string_value_2", RelatedLegalEntity_response_2);
            PreparedStatement ps_script_rle = connection_NM_CRM.prepareStatement(Script_to_CLOB_2_rle);
            ps_script_rle.execute();
            script_reader_rle.close();


            // Read the script into a variable
            File relatedLegalEntity_response_file = new File("Response_From_CFT_REQ_Receiving.sql");
            BufferedReader reader_relatedLegalEntity_response = new BufferedReader(new InputStreamReader(new FileInputStream(relatedLegalEntity_response_file), "windows-1251"));
            String line_relatedLegalEntity_response;
            StringBuilder stringBuilder_relatedLegalEntity = new StringBuilder();
            while ((line_relatedLegalEntity_response = reader_relatedLegalEntity_response.readLine()) != null) {
                stringBuilder_relatedLegalEntity.append(line_relatedLegalEntity_response);
                stringBuilder_relatedLegalEntity.append(separator);
            }
            String SQL_RelatedLegalEntity_Response = stringBuilder_relatedLegalEntity.toString();
            reader_relatedLegalEntity_response.close();
            // Insert response to DB
            PreparedStatement ps_relatedLegalEntity_Response = connection_NM_CRM.prepareStatement(SQL_RelatedLegalEntity_Response);
            ps_relatedLegalEntity_Response.execute();
            Thread.sleep(10000);

            System.out.println();
            System.out.println("-> Получены данные из ЦФТ по связанному юридическому лицу ->");
            System.out.println();

        } catch (InterruptedException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
