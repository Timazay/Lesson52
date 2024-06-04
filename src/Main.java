import com.mysql.jdbc.Driver;

import java.sql.*;

public class Main {
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // public static final String URL = "jdbc:mysql://127.0.0.1:3306/academy";
    public static final String URL = "jdbc:mysql://localhost:3306/academy";
    public static final String USER = "root";
    public static final String PASSWORD = "123qwe";

    public static final String SELECT_ALL_CLASSES = "SELECT * FROM classes";


    public static void main(String[] args) {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException exception) {
            System.err.println(exception);
        }


   //   try {
   //       DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
   //   } catch (SQLException throwables) {
   //       System.err.println(throwables);
   //   }

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            System.out.println(statement.getClass());

           ResultSet set = statement.executeQuery(SELECT_ALL_CLASSES);
            System.out.println(set.getClass());

           while (set.next()){
               System.out.println(
                       set.getInt(1)
                       + ") " + set.getString("name")
                       + " " + set.getString("code")
               );
           }


        } catch (SQLException exception){
            System.err.println(exception);
        } finally {
            if (connection != null){
                try {
                   connection.close();
                } catch (SQLException exception){
                    System.err.println(exception);
                }
            }
        }

    }
}
