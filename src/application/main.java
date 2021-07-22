package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent connectionView = FXMLLoader.load(getClass().getClassLoader().getResource("view/Connection/StatusChoice.fxml"));
            primaryStage.setScene(new Scene(connectionView));
            primaryStage.show();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
