import Util.TextUI;

import java.util.ArrayList;

public class SearchFunction {
    TextUI Ui = new TextUI();
    LoadMedia loader = new LoadMedia();
    ArrayList<Series> series = loader.loadSeries("Data/Serier.csv");
    ArrayList<Movie> movies = loader.loadMovies("Data/Film.csv");

    public void searchByGenre() {
        String input = Ui.promptText("Enter genre of movies or serie: ");
        boolean found = false;
        for (Movie m : movies) {
            for(String g: m.genres) {
                if (input.equalsIgnoreCase(g)) {
                    System.out.println(m.title);
                    found = true;
                    break;

                }
            }
        }
        Ui.displayMsg("\n Series that is "+input);
        for (Series s : series) {
            for(String g: s.genres) {
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

    public void searchByName () {
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
                System.out.println(s.title + "| Genre: " + s.genres);
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
                if (Ui.promptText("Do you want a serie or movie?").equals("serie")) {
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

