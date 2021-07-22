package controller.Cinema;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Movie.Movie;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MovieSelection {
    @FXML
    private GridPane grid = new GridPane();
    ArrayList<Movie> movies ;
    private int columnIndex, rowIndex;
    ImageView imo = new ImageView("view/MovieImage/AvengersEndgame.jpg");


    public int getColumnIndex() {
        return columnIndex;
    }
    public int getRowIndex(){
        return rowIndex;
}



}


















