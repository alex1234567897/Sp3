import Util.TextUI;

import java.util.ArrayList;

public class MainMenu {

    TextUI Ui = new TextUI();
    SearchFunction searchFunction = new SearchFunction();
    User user;
    LoadMedia loader = new LoadMedia();
    ArrayList<Media> allMedia = loader.allMedia("Data/Film.csv", "Data/Serier.csv");
    private Media theChosenMedia;

    public void displayMenu() {

        int choice = Ui.promptNumeric(
                "What would you like to do?" +
                        "\n1) Search" +
                        "\n2) View all content" +
                        "\n3) View watchlist (Work in progress) " +
                        "\n4) view watched content (Work in progress) " +
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
/* Hvis vi ikke vil have et input fra brugeren skal vi sørge for at searchfunction returnerer et medie
playMedia() går igennem all medie og tjekker om titlen passer til brugererns input, og derefter kan den play
eller gemme i watchlist.
 */

        String input = Ui.promptText("Which movie do you want to watch/add to watchList?");
        if (input.isEmpty()) {
            Ui.displayMsg("Empty input! Try again.");
            return;
        }

        ArrayList<Media> matches = new ArrayList<>();
        for (Media m : allMedia) {
            String title = m.getTitle();
            if (title != null && title.toLowerCase().contains(input.toLowerCase())) {
                matches.add(m);
            }
        }

        if (matches.isEmpty()) {
            Ui.displayMsg("No media found!" + input);
            return;
        }

        Media selected;
        if (matches.size() == 1) {
            selected = matches.get(0);
        } else {
            StringBuilder sb = new StringBuilder("Multible matches \n");
            for (int i = 0; i < matches.size(); i++) {
                sb.append(i + 1).append(") ").append(matches.get(i).getTitle()).append("\n");
            }
            int pick = Ui.promptNumeric(sb + "Choose number (0 0 cancel):");
            if (pick <= 0 || pick > matches.size()) {
                Ui.displayMsg("Cancelled...");
                return;
            }
            selected = matches.get(pick - 1);
        }

        switch (choice) {
            case 1:
                Ui.displayMsg(selected.getTitle() + " now playing...");
                //user.markedAsWatched(selected);//
                break;
            case 2:
                Ui.displayMsg(selected.getTitle() + " added to your watchlist.");
                //user.addToWatchList(selected);//
                break;
            default:
                Ui.displayMsg("Invalid choice!");
                break;
        }

        /*Media    theChosenMedia = null;
        for (Media m : allMedia) {
            if (m.title.contains(input)) {
                theChosenMedia = m;
                break;
            } else {
                System.out.println("Dette medie findes ikke, prøv igen");
                playMedia();
            }
        }
            switch (choice) {
                case 1:
                    Ui.displayMsg(theChosenMedia.title + " now playing...");
                    user.markedAsWatched(theChosenMedia);
                    break;
                case 2:
                    user.addToWatchList(theChosenMedia);
                    break;
                case 0:
                    searchMenu();
                    break;
            }*/
    }
}
