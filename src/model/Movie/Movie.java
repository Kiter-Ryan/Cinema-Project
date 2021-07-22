package model.Movie;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;

public class Movie {
    private static ArrayList<Movie> movies = new ArrayList<>();
    private String title;
    private String genre;
    private Date releaseDate;
    private int runningTime;
    private double rating; 
    private Image imageMovie;

    public Movie(String title, String genre, Date releaseDate, int runningTime, double rating){
        this.title = title;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.runningTime = runningTime;
        this.rating = rating;
    }

    public static javafx.scene.image.Image checkUrl(String s) {
        try {
            BufferedImage image = ImageIO.read(new URL(s));
            return image != null ? javafx.scene.image.Image.impl_fromPlatformImage(image) : null;
        } catch (MalformedURLException var2) {
            return null;
        } catch (IOException var3) {
            return null;
        }
    }
    public static  ArrayList<Movie> getMovies(){
        return movies;
    }




}
