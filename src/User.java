import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private ArrayList<String> watchlist;
    private ArrayList<Media> watched;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.watchlist = new ArrayList<String>();
        this.watched = new ArrayList<>();
    }

    public void addToWatchList(String media){
        if(!watchlist.contains(media)){
            watchlist.add(media);
            return;
        }
        System.out.println(media+" is already in your watchlist.");
    }

    public void removeFromWatchList(String media){
        watchlist.remove(media);
    }

   public void markedAsWatched(Media media){
        if(watchlist.contains(media)) watchlist.remove(media);
        watched.add(media);
    }

    // --- getter ---
    public ArrayList<String> getWatchlist(){
        return watchlist;
    }
    public ArrayList<Media> getWatched(){
        return watched;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }

}
