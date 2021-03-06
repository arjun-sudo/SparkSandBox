/**
 * @author :arjun
 * Project :SparkDBConnection
 * Date : 2020-12-21
 * Time : 12:17
 */
package database;

import java.sql.*;

public class UserDatabase {
    Connection connection = null;
    Statement statement = null;

    private void getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sparkdb", "root", ""
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Boolean executeUpdate(String query) {
        Boolean result = false;
        try {
            getConnection();
            statement = connection.createStatement();
            int count = statement.executeUpdate(query);
            if (count > 0) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;

        try {
            getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultSet;
    }


}
