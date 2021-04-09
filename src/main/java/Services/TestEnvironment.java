package Services;

public class TestEnvironment {

    private String url;
    private String DB_data;
    private String userName;
    private String password;
    private String inn;

    public TestEnvironment(String contour) {

        if (contour.equals("8083")) {
            url = "http://192.168.1.140:8083/SlxClient/logoff.aspx";
            DB_data = "jdbc:oracle:thin:@server:1521:slx0";
            userName = "Admin";
            password = "";
            inn = "123455432100";
        } else if (contour.equals("8093")) {
            url = "http://192.168.1.140:8093/SlxClient/logoff.aspx";
            DB_data = "jdbc:oracle:thin:@server:1521:slx1";
            userName = "Admin";
            password = "4YFDtyiaPpvIbYkehzkG";
            inn = "2543127028";
        } else if (contour.equals("8092")) {
            url = "http://192.168.1.140:8092/SlxClient/logoff.aspx";
            DB_data = "jdbc:oracle:thin:@server:1521:slx10";
            userName = "Admin";
            password = "";
            inn = "7708544480";
        } else if (contour.equals("Dima")) {
            url = "http://192.168.1.47:4444/SlxClient/logoff.aspx";
            DB_data = "jdbc:oracle:thin:@server:1521:slx0";
            userName = "Admin";
            password = "";
            inn = "123455432100";
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

    public String getInn() {
        return inn;
    }
}
