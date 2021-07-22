package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DataBaseConnection {

  public static Connection connection;

  static {
      new DataBaseConnection();
  }


  public DataBaseConnection(){
      String dataBaseName = "database cinema";
      String userName = "root";
      String password = "root";

      try{
          System.out.println("Connecting to Data Base...");
          connection = DriverManager.getConnection("jdbc:mysql://@localhost:3306/"+dataBaseName, userName, password);
      }catch(SQLException e){
          e.printStackTrace();
      }
  }

  public final static Connection getConnection(){
      return connection;
  }
}
