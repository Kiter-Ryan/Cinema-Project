package model.Customer;

import model.DataBaseConnection;
import model.User;
import model.UserDAO;

import java.sql.*;

public class CustomerDAO extends UserDAO {
    public Connection connection;
    private Customer customer;
    public DataBaseConnection DataBaseConnection ;


    public CustomerDAO(){

        DataBaseConnection = new DataBaseConnection();
        this.connection = DataBaseConnection.getConnection();

    }


    public boolean addCustomer(Customer customer){
        String sqlQuery = "INSERT INTO Customer (CustomerFirstName, CustomerLastName, CustomerType, CustomerLogin, CustomerPassword, CustomerDiscount, CustomerMail, UserID) VALUES(?,?,?,?,?,?,?, ?)";
        PreparedStatement preparedStatement = null;
        boolean success = false;
        int userID = super.insertUser(new User(customer.getMail(), customer.getPassword()), "Customer");
        try{
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, customer.getFirstName());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, "ok");
            preparedStatement.setString(4, customer.getUserName());
            preparedStatement.setString(5, customer.getPassword());
            preparedStatement.setInt(6, 1);
            preparedStatement.setString(7, customer.getMail());
            preparedStatement.setInt(8, userID);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            System.out.println("Addition of "+customer.getUserName()+" into the database...");
            success = true;
        }catch(SQLException e ){
            e.printStackTrace();
            success = false;
        }
        return success;
    }








}
