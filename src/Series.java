import java.util.ArrayList;
import java.util.HashMap;


public class Series extends Media {

    //private ArrayList<Integer> episodes;
    private String seasons;
    //private boolean onGoing;
    private String releaseYear;


    public Series(String title, String releaseYear, ArrayList<String> genres, double rating,
             String seasons) {
        super(title, genres, rating);
        //this.episodes = episodes;
        this.seasons = seasons;
        //this.onGoing = onGoing;
        this.releaseYear = releaseYear;
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }

    public String toString() {
        return "Title: " + getTitle() + ", runtime: " + releaseYear + ", rating: " +
                getRating() + ", genre: " + genres + "\n Season and episode: (" +seasons+").";
    }
}