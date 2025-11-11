import Util.TextUI;

import java.util.ArrayList;

public class MainMenu {

    TextUI Ui = new TextUI();
    SearchFunction searchFunction = new SearchFunction();
    User user;
    LoadMedia loader = new LoadMedia();
    ArrayList<Series> series = loader.loadSeries("Data/Serier.csv");
    ArrayList<Movie> movies = loader.loadMovies("Data/Film.csv");

    public void displayMenu() {

        int choice = Ui.promptNumeric(
                "What would you like to do?" +
                        "\n1) Search" +
                        "\n2) View all content" +
                        "\n3) View watchlist " +
                        "\n4) view watched content " +
                        "\n0) Sign out" +
                        "\n>");

        switch (choice) {
            case 1:
                searchMenu();
                break;
            case 2:
                searchFunction.viewAll();
                break;
            case 3:
                user.getWatchlist();
                break;
            case 4:
                user.getWatched();
                break;
            case 0:
                break;
            default:
                return;
        }



    }

    public void searchMenu() {
        int choice = Ui.promptNumeric("=== Search ===" +
                "\n1) Search by title" +
                "\n2) Search by genre" +
                "\n0) Return <-");
        switch (choice) {
            case 1:
                searchFunction.searchByName();
                break;
            case 2:
                searchFunction.searchByGenre();
                break;
            case 0:
                displayMenu();
                break;
        }

    }

    public void playMedia() {
        int choice = Ui.promptNumeric("=== Media ===" +
                "\n1) Play media" +
                "\n2)Add to watchlist" +
                "\n0) Return <-");

        switch (choice) {
            case 1:
                Ui.displayMsg(m.title + " now playing...");
                user.markedAsWatched();
                break;
            case 2:
                user.addToWatchList(media);
                break;
            case 0:
                return;
                break;
        }
    }
}
