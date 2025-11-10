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

   /* public HashMap<Integer,Integer> makeSeasonsInSeries() {

        // man kunne f.eks bruge hashmaps til få (SeasonNumber, EpisodeNumber
        HashMap<Integer, Integer> seasonAndEpisodes = new HashMap<Integer, Integer>();
        // putter antal episoder ind fra episode arraylisten til de korrekte sæsonner
        for (int i = 0; i < seasons; i++) {
            seasonAndEpisodes.put(i + 1, episodes.get(i));
            System.out.println(seasonAndEpisodes);
        }
        return seasonAndEpisodes;
    }*/

    public String toString() {
        return "Title: " + getTitle() + ", runtime: " + releaseYear + ", rating: " +
                getRating() + ", genre: " + genres + "\n Season and episode: (" +seasons+").";
    }
}