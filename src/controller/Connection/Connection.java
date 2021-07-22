package controller.Connection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;


public class Connection implements Initializable {
    private Stage stage = new Stage();
    @FXML
    private Button confirmButton;
    @FXML
    private Hyperlink newUserHyperlink;


    @FXML
    private Button customerButton, employeeButton ;


    @FXML
    public void getCustomerButton(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Connection.class.getResource("/view/Connection/login.fxml"));
            Parent root = loader.load();
            Login login = loader.getController();
            login.setUsrType("Customer");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    public void getEmployeeButton(ActionEvent event){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Connection.class.getResource("/view/Connection/login.fxml"));
            Parent root = loader.load();
            Login login = loader.getController();
            login.setUsrType("Employee");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }













}
