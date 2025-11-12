import java.util.ArrayList;

public class Movie extends Media {

    int releaseYear;

    /**
     * Movie object
     * @param title title of the movie
     * @param releaseYear The year the movie was released
     * @param genres The genres the movie can be categorized in
     * @param rating The rating the movie recieved
     */
    public Movie(String title, int releaseYear, ArrayList<String> genres, double rating) {
        super(title, genres, rating);
        this.releaseYear = releaseYear;
    }

    /**
     * Retrieves a given movies release year.
     * @return releaseYear
     */
    public int getReleaseYear() {
        return releaseYear;
    }
    public String getTitle() {
        return title;
    }
     public String toString() {
        return "Title: " + getTitle() + ", releaseYear: " + releaseYear + ", rating: " + getRating() + ", genre: " + genres;
    }
}
