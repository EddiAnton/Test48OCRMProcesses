package Services;

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
}
