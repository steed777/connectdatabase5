import java.sql.*;

public class Main {
    //private static final String url =
          //  "jdbc:firebirdsql:local:C:/Users/Senko_KL/Desktop/ФГИС Учет адвокатов/2014 (предположительно)/Адвокаты/Портал.FDB?lc_ctype=WIN1251";
    //private static final String url =
    //          "jdbc:firebirdsql://localhost:3050/lawyers-portal?lc_ctype=WIN1251&user=sysdba&password=masterkey&ssl=true";
    private static final String url =
       "jdbc:firebirdsql://localhost:3050/C:/Users/Senko_KL/Desktop/base/LAWYERS_PORTAL.fdb?lc_ctype=WIN1251&user=SYSDBA&password=masterkey";
    // private static final String url =
    //   "jdbc:firebirdsql://localhost:3050/LAWYERS_PORTAL.fdb?lc_ctype=WIN1251&user=sysdba&password=masterkey";
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from lawyers-portal");
        while (resultSet.next()){
            System.out.println(resultSet);
        }
    }
}
//jdbc:firebirdsql://host[:port]/<database>jdbc:firebirdsql://host[:port]/<database>
//3.0.0-beta-3