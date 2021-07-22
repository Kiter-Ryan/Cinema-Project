package model.Employee;

import model.User;

public class Employee extends User {
    private String firstName, lastName, mail, password;



    public Employee( String firstName, String lastName, String mail, String password) {
        super(mail, password);
        if(mail.indexOf("@") == -1 || mail.indexOf(".") == -1){
            System.out.println("Invalid mail");
        }else{
            this.mail = mail;
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }


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

    public String getType(){
        return "employee";
    }
}