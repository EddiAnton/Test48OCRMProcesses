package Services;

public class TestEnvironment {

    private String url;
    private String DB_data;
    private String userName;
    private String password;

    public TestEnvironment(String contour) {

        if (contour.equals("8083")) {
            url = "http://192.168.1.140:8083/SlxClient/logoff.aspx";
            DB_data = "jdbc:oracle:thin:@server:1521:slx0";
            userName = "Admin";
            password = "";
        } else if (contour.equals("8093")) {
            url = "http://192.168.1.140:8093/SlxClient/logoff.aspx";
            DB_data = "jdbc:oracle:thin:@server:1521:slx1";
            userName = "Admin";
            password = "4YFDtyiaPpvIbYkehzkG";
        } else if (contour.equals("8092")) {
            url = "http://192.168.1.140:8092/SlxClient/logoff.aspx";
            DB_data = "jdbc:oracle:thin:@server:1521:slx1";
            userName = "Admin";
            password = "";
        }
    }

    public String getUrl() {
        return url;
    }

    public String getDB_data() {
        return DB_data;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
