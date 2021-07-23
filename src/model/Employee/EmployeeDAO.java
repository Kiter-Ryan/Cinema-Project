package model.Employee;

import model.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {
    private Connection connection;
    private Employee employee;


    public EmployeeDAO(){
        this.connection = DataBaseConnection.getConnection();
    }

    public boolean addEmployee(){
        PreparedStatement preparedStatement = null;
        boolean success = false;
        try{
            preparedStatement = connection.prepareStatement("INSERT INTO Employee(firstName, lastName, mail, password");
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getMail());
            preparedStatement.setString(4, employee.getPassword());
            success = true;
        }catch(SQLException e){
            e.printStackTrace();
            success = false;
        }
        return success;
    }


    public ArrayList<Employee> getEmployees(){
        ResultSet resultSet = null ;
        ArrayList<Employee> employees = new ArrayList<>();
        try{
            resultSet = connection.createStatement().executeQuery("SELECT * FROM Employee");
            while(resultSet.next()){
                employees.add(new Employee(
                        resultSet.getString("First name"),
                        resultSet.getString("Last name"),
                        resultSet.getString("Mail"),
                        resultSet.getString("Password")
                        ));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return employees;
    }






}
