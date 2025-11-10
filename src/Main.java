import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        LoadMedia loader = new LoadMedia();
        ArrayList<Movie> movies = loader.loadMovies("Data/Film.csv");


        for (Movie m : movies) {
            System.out.println(m);
        }

        ArrayList<Series> series = loader.loadSeries("Data/Serier.csv");


        for (Series m : series) {
            System.out.println(m);
        }


        LoginMenu user = new LoginMenu();
        user.signMethod();

    }
}