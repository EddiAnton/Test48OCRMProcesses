package org.fbconsult.Services;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModelingBP {

    final static String separator = " \n";

    public static void createApplicationFromBP(Connection connection_NM_CRM) {

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
