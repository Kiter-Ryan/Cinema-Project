package controller.Customer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Customer.Customer;
import model.Customer.CustomerDAO;


import java.util.ArrayList;

public class Account {

    @FXML
    private Button registerButton, backButton;
    @FXML
    private TextField firstName, lastName, userName, mail, password, re_password;
    @FXML
    private CheckBox userTerm;
    private Stage stage = new Stage();
    private Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    private Image iconCustomer ;


    public Image getIconCustomer(){return iconCustomer;}

    public String getFirstName() {
        return firstName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getUserName(){return userName.getText(); }

    public String getMail() {
        return mail.getText();
    }

    public String getPassword() {
        return password.getText();
    }

    public String getRe_password() {
        return re_password.getText();
    }


    @FXML
    public void createAccount(ActionEvent event) {
        if (userTerm.isSelected()) {
            checkRegistration();
            if (checkRegistration() == true) {
                    try {
                        new CustomerDAO().addCustomer(new Customer(getFirstName(), getLastName(),getMail(),  getUserName(), getPassword()));
                        Parent registrationView = FXMLLoader.load(getClass().getClassLoader().getResource("view/Customer/account.fxml"));
                        Stage stage = new Stage();
                        stage.setScene(new Scene(registrationView));
                        stage.show();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            } else {
                errorAlert.setHeaderText("Missing information. All fields must be filled in.");
                errorAlert.showAndWait();
            }
        } else {
            errorAlert.setHeaderText("You should agree the User term. Please read user condition before accept it.");
            errorAlert.showAndWait();
        }
    }

    @FXML
    public void getBackButton(ActionEvent event) {
        try {
            Parent connectionView = FXMLLoader.load(getClass().getClassLoader().getResource("view/Connection/connectionView.fxml"));
            stage.setScene(new Scene(connectionView));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkRegistration() {
        ArrayList<String> informations = new ArrayList<>();
        boolean validInformation = false;
        informations.add(getFirstName());
        informations.add(getLastName());
        informations.add(getUserName());
        informations.add(getMail());
        informations.add(getPassword());
        informations.add(getRe_password());
        for (int i = 0; i < 6; i++) {
            if (informations.get(i).isEmpty()) {
                validInformation = false;
            } else {
                validInformation = true;
            }
        }
        return validInformation;
    }



}

