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
            String separator = " \n";

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
            File cft_response_file = new File("Response_From_CFT_Receiving.sql");
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

    public static void getCustomerData(Connection connection_NM_CRM) {

        try {

            // Read the xml-file into a variable
            File bp_file = new File("BP_response.xml");
            BufferedReader bp_reader = new BufferedReader(new InputStreamReader(new FileInputStream(bp_file), StandardCharsets.UTF_8));
            String line_bp;
            StringBuilder sb_bp = new StringBuilder();
            while ((line_bp = bp_reader.readLine()) != null) {
                sb_bp.append(line_bp);
                sb_bp.append(separator);
            }

            // Insert ProductOrderNumber to xml
            String BP_response = sb_bp.toString();
            bp_reader.close();


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

            String Script_to_CLOB = sb_script.toString().replace("Very_long_string_value", BP_response);
            //Script_to_CLOB = Script_to_CLOB.replace("Very_long_string_value", BP_response);
            PreparedStatement ps_script = connection_NM_CRM.prepareStatement(Script_to_CLOB);
            ps_script.execute();
            script_reader.close();


            // Read the script into a variable
            File BP_response_file = new File("Response_From_BP_Receiving.sql");
            BufferedReader reader_bp_response = new BufferedReader(new InputStreamReader(new FileInputStream(BP_response_file), "windows-1251"));
            String line_bp_response;
            StringBuilder stringBuilder_3 = new StringBuilder();
            while ((line_bp_response = reader_bp_response.readLine()) != null) {
                stringBuilder_3.append(line_bp_response);
                stringBuilder_3.append(separator);
            }
            String SQL_BP_Response = stringBuilder_3.toString();
            reader_bp_response.close();
            // Insert response to DB
            PreparedStatement ps_BP_Response = connection_NM_CRM.prepareStatement(SQL_BP_Response);
            ps_BP_Response.execute();
            Thread.sleep(20000);

            System.out.println();
            System.out.println("-> Получена заявка из Бизнес портала ->");
            System.out.println();

        } catch (InterruptedException | SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
