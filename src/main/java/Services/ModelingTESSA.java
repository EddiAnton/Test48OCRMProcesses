package Services;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public final class ModelingTESSA {

    public static void deliveryForVerification(String fb_productOrderID, Connection connection_NM_CRM) {

        
    }


    public static void successfullyVerified(String productOrderNumber, Connection connection_NM_CRM) {

        try {

            String separator = " \n";

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
