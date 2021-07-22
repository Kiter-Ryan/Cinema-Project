package model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public Connection connection;
    private User User;
    public DataBaseConnection DataBaseConnection ;


    public UserDAO(){
        DataBaseConnection = new DataBaseConnection();
        this.connection = DataBaseConnection.getConnection();

    }

    public User getUser(String userName, String password){
        String command = "SELECT UserID, UserMail, UserPassword FROM user WHERE UserMail = ? AND UserPassword = ?";
        PreparedStatement preparedStatement = null;
        boolean success = false;
        User user = null ;
        try{
            preparedStatement = connection.prepareStatement(command);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while ( rs.next() )
            {
                String usrMail = rs.getString("UserMail");
                String usrPassword = rs.getString("UserPassword");
                user = new User(usrMail, usrPassword);
            }
            rs.close();
            preparedStatement.close();
            System.out.println("Checking the database..");
            success = true;
        }catch(SQLException e ){
            e.printStackTrace();
            success = false;
        }
        return user ;
    }

}
