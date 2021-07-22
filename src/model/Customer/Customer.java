package model.Customer;

import controller.Customer.Account;
import model.User;

public class Customer extends User {
    private String firstName, lastName, mail, password, userName;

    public Customer(String firstName, String lastName, String  mail, String userName, String password) {
        super(mail, password);
        this.mail = mail ;
        this.firstName = firstName;
        this.password = password;
        this.lastName = lastName;
        this.userName = userName;
    }


    public String getUserName(){return userName;}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getMail() {
        return mail;
    }




}