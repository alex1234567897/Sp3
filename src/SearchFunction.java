import Util.TextUI;

import javax.swing.*;
import java.util.ArrayList;

public class SearchFunction {
    TextUI Ui = new TextUI();
    LoadMedia loader = new LoadMedia();
    ArrayList<Series> series = loader.loadSeries("Data/Serier.csv");
    ArrayList<Movie> movies = loader.loadMovies("Data/Film.csv");
    ArrayList<Media> allMedia = loader.allMedia("Data/Film.csv", "Data/Serier.csv");

    public void searchByGenre() {
        String input = " ";
        int choice = Ui.promptNumeric("=== Choose Genre ===" +
                "\n1) Action || 2) Adventure || 3) Animation || 4) Biography || 5) Comedy || 6) Crime ||, 7) Documentary" +
                "\n8) Drama || 9) Family || 10) Fantasy || 11) History || 12) Horror || 13) Mystery  ||, 14) Music" +
                "\n15) Musical || 16) Romance || 17) Sci_fi || 18) Sport || 19) Thriller || 20) War  ||, 21) Western");

        switch (choice) {
            case 1:
                input = "Action";
                break;
            case 2:
                input = "Adventure";
                break;
            case 3:
                input = "Animation";
                break;
            case 4:
                input = "Biography";
                break;
            case 5:
                input = "Comedy";
                break;
            case 6:
                input = "Crime";
                break;
            case 7:
                input = "Documentary";
                break;
            case 8:
                input = "Drama";
                break;
            case 9:
                input = "Family";
                break;
            case 10:
                input = "Fantasy";
                break;
            case 11:
                input = "History";
                break;
            case 12:
                input = "Horror";
                break;
            case 13:
                input = "Mystery";
                break;
            case 14:
                input = "Music";
                break;
            case 15:
                input = "Musical";
                break;
            case 16:
                input = "Romance";
                break;
            case 17:
                input = "Sci-fi";
                break;
            case 18:
                input = "Sport";
                break;
            case 19:
                input = "Thriller";
                break;
            case 20:
                input = "War";
                break;
            case 21:
                input = "Western";
                break;
            case 22:
                input = "Film-Noir";
            default:
        }


        /* Skal måske ændres */
        boolean found = false;

        for (Movie m : movies) {
            for (String g : m.genres) {
                if (input.equalsIgnoreCase(g)) {
                    System.out.println(m.title);
                    found = true;
                    break;
                }
            }
        }

        Ui.displayMsg("\n Series that is " + input);
        for (Series s : series) {
            for (String g : s.genres) {
                if (input.equalsIgnoreCase(g)) {
                    System.out.println(s.title);
                    found = true;
                    break;

                }
            }
        }

        if (!found) {
            Ui.displayMsg("No movies found with the genre: " + input);
            searchByGenre();
        }

    }

    public void searchByName() {
        String inputName = Ui.promptText("Enter title of movie or series: ");
        boolean found = false;

        for (Movie m : movies) {
            if (m.title.toLowerCase().contains(inputName.toLowerCase())) {
                System.out.println(m.title);
                found = true;

            }
        }
        for (Series s : series) {
            if (s.title.toLowerCase().contains(inputName.toLowerCase())) {
                System.out.println(s.title);
                found = true;
            }
        }


        if (!found) {
            Ui.displayMsg("No movies found with the name: " + inputName);
            inputName = "";
            searchByName();
        }

    }




        /**
         * denne metode spørg om du vil se alle tilgænglige film og serier. hvis ikke så spørg den om du vil se film eller serier.
         * og printer din prefecence ud.
         */
        public void viewAll () {


            if (Ui.promptBinary("Do you want to View all? (Y/N)") == true) {

                Ui.displayMsg("Movies");
                for (Movie m : movies) {
                    System.out.println(m.title);
                }

                Ui.displayMsg("Series");
                for (Series s : series) {
                    System.out.println(s.title);
                }
            } else {
                if (Ui.promptNumeric("Do you want see a: \n1) series \n2) movie?") == 1) {
                    ArrayList<Series> series = loader.loadSeries("Data/Serier.csv");

                    for (Series s : series) {
                        System.out.println(s.title);
                    }
                } else {
                    ArrayList<Movie> movies = loader.loadMovies("Data/Film.csv");

                    for (Movie m : movies) {
                        System.out.println(m.title);
                    }
                }
            }
        }
    }