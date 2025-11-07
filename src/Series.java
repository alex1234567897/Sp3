import java.util.ArrayList;
import java.util.HashMap;


public class Series extends Media {

    private ArrayList<Integer> episodes;
    private int seasons;
    private boolean onGoing;

    public Series(String title, ArrayList<String> genres, double rating, boolean onGoing,
                  ArrayList<Integer> episodes, int seasons) {
        super(title, genres, rating);
        this.episodes = episodes;
        this.seasons = seasons;
        this.onGoing = onGoing;
    }

    public HashMap<Integer,Integer> makeSeasonsInSeries() {

        // man kunne f.eks bruge hashmaps til få (SeasonNumber, EpisodeNumber
        HashMap<Integer, Integer> seasonAndEpisodes = new HashMap<Integer, Integer>();
        // putter antal episoder ind fra episode arraylisten til de korrekte sæsonner
        for (int i = 0; i < seasons; i++) {
            seasonAndEpisodes.put(i + 1, episodes.get(i));
            System.out.println(seasonAndEpisodes.get(i+1));
        }
        return seasonAndEpisodes;
    }

    public String toString() {
        makeSeasonsInSeries();
        return "Title: " + getTitle() + ", onGoing: " + onGoing + ", rating: " +
                getRating() + ", genre: " + genres + makeSeasonsInSeries();
    }
}