package controller.Connection;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import model.UserDAO;


import java.io.IOException;

public class Login {

    @FXML
    private TextField usrName, usrPwd;
    private String usrType;
    private UserDAO userDAO ;
    private Alert errorAlert = new Alert(Alert.AlertType.ERROR);


    public Login(){
        this.userDAO = new UserDAO();
    }

    public String getUsrName(){
        return usrName.getText();
    }

    public String getUsrPwd() {
        return usrPwd.getText();
    }

    @FXML
    public void handleLogin(ActionEvent event) {
        User user = userDAO.getUser(getUsrName(), getUsrPwd());
        if(user == null){
            errorAlert.setHeaderText("Bad credentials. Please retry.");
            errorAlert.showAndWait();
        }else{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Connection.class.getResource("/view/Connection/login.fxml"));
            Parent root = loader.load();
            Login login = loader.getController();
            login.setUsrType("Customer");
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    public void setUsrType(String usrType){
        this.usrType = usrType;
    }

    @FXML
    public void backToPrevScene(ActionEvent event){
    }

    @FXML
    private void SwitchToAddMember(ActionEvent event) throws IOException {
        ((Stage)(((Hyperlink)event.getSource()).getScene().getWindow())).close();
        Parent registrationView = FXMLLoader.load(getClass().getClassLoader().getResource("view/Connection/userRegistration.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(registrationView));
        stage.show();
    }
}
