package model;


import java.sql.*;

public class UserDAO {
    public Connection connection;
    private User User;
    public DataBaseConnection DataBaseConnection ;


    public UserDAO(){
        DataBaseConnection = new DataBaseConnection();
        this.connection = DataBaseConnection.getConnection();
    }

    public int insertUser(User user, String type){
        String insertUserQuery = "INSERT INTO USER(UserMail, UserPassword, UserType) VALUES (?,?,?)";
        PreparedStatement preparedStatement = null;
        boolean success = false;
        int userID = 0;
        try{
            preparedStatement = connection.prepareStatement(insertUserQuery, Statement.RETURN_GENERATED_KEYS); //take the primary key

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, type );
            preparedStatement.executeUpdate();
            ResultSet rs =  preparedStatement.getGeneratedKeys();
            userID = rs.next() ? rs.getInt(1) : 0;
            preparedStatement.close();
            System.out.println("Addition of "+user.getUsername()+" into the database...");
            success = true;
        }catch(SQLException e ){
            e.printStackTrace();
            success = false;
        }
        return userID;

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
