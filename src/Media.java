import java.util.ArrayList;

public abstract class Media {
    protected String title;
    protected double rating;
    protected ArrayList<String> genres = new ArrayList<>();

    public Media(String title, ArrayList<String> genres, double rating) {
        this.title = title;
        this.rating = rating;
        this.genres = genres;

    }

    public String getTitle(){
        return title;
    }
    public double getRating() {
        return rating;
    }
    public ArrayList<String> getGenre() {
        return genres;
    }
}