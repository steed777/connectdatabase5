import java.sql.*;

public class Main {

    private static final String url =
       "jdbc:firebirdsql://localhost:3050/C:/db/LAWYERS_PORTAL.FDB?lc_ctype=WIN1251&user=SYSDBA&password=masterkey";
private static final String otherURL =
        "jdbc:firebirdsql://localhost:3050/C:/db/other.fdb?lc_ctype=WIN1251&user=SYSDBA&password=masterkey";
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(url);
        Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM LAWYERS");

        Connection connection1 = DriverManager.getConnection(otherURL);
        Statement statement1 = connection1.createStatement();



   String sql = "CREATE TABLE othertable (ID BIGINT not null, ADDRESS VARCHAR(250), LAW_CHAMBER VARCHAR(255), DISTRICT_CODE VARCHAR(3), " +
        "DISTRICT_NAME VARCHAR(80), EMAIL VARCHAR(255), FIO VARCHAR(255) not null, IDENTITY_CARD VARCHAR(25), ORG_FORM INTEGER, " +
        "ORG_NAME VARCHAR(255), PHONE VARCHAR(255), REG_CAPTION VARCHAR(80), REG_CODE VARCHAR(3), REGISTER_NUMBER VARCHAR(9), " +
        "SERIAL_NUMBER VARCHAR(6), STATUS INTEGER, PRIMARY KEY(ID))";


        PreparedStatement preparedStatement = connection1.prepareStatement(sql);
        //preparedStatement.executeUpdate();

while(resultSet.next()){
preparedStatement = connection1.prepareStatement("INSERT INTO othertable(ID, ADDRESS, LAW_CHAMBER, DISTRICT_CODE, DISTRICT_NAME, " +
        "EMAIL, FIO, IDENTITY_CARD, ORG_FORM, ORG_NAME, PHONE, REG_CAPTION, REG_CODE, REGISTER_NUMBER, SERIAL_NUMBER, STATUS) values (?, ?, " +
        "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
preparedStatement.setInt(1, resultSet.getInt("ID"));
preparedStatement.setString(2, resultSet.getString("ADDRESS"));
preparedStatement.setString(3, resultSet.getString("LAW_CHAMBER"));
preparedStatement.setString(4, resultSet.getString("DISTRICT_CODE"));
preparedStatement.setString(5, resultSet.getString("DISTRICT_NAME"));
preparedStatement.setString(6, resultSet.getString("EMAIL"));
preparedStatement.setString(7, resultSet.getString("FIO"));
preparedStatement.setString(8, resultSet.getString("IDENTITY_CARD"));
preparedStatement.setInt(9, resultSet.getInt("ORG_FORM"));
preparedStatement.setString(10, resultSet.getString("ORG_NAME"));
preparedStatement.setString(11, resultSet.getString("PHONE"));
preparedStatement.setString(12, resultSet.getString("REG_CAPTION"));
preparedStatement.setString(13, resultSet.getString("REG_CODE"));
preparedStatement.setString(14, resultSet.getString("REGISTER_NUMBER"));
preparedStatement.setString(15, resultSet.getString("SERIAL_NUMBER"));
preparedStatement.setInt(16, resultSet.getInt("STATUS"));
preparedStatement.executeUpdate();
}
//вывод названий всех столбцов таблицы
      /*ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
      int colunm = resultSetMetaData.getColumnCount();
        for (int i =  1; i <= colunm; i++) {
            String name = resultSetMetaData.getColumnName(i);
            System.out.print(name + "  ");
        }*/

    }
}

