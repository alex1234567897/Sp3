import Util.FileIO;

import java.util.ArrayList;

public class LoadMedia {

    FileIO fileIO = new FileIO();

    /**
     * This method is used to convert a list of movies in a .csv-file into movie-objects.
     * @param path
     * @return
     */
    public ArrayList<Movie> loadMovies(String path) {
        ArrayList<String> lines = fileIO.readMedia(path);
        ArrayList<Movie> movies = new ArrayList<>();

        for (String line : lines) {
            if (line.endsWith(";")) {
                line = line.substring(0, line.length() - 1);
            }

            String[] parts = line.split(";");
            if (parts.length < 4) {
                System.out.println("ignore line. not enough fields:" + line);
                continue;
            }

            String title = parts[0].trim();
            int releaseYear = parseInt(parts[1].trim());
            ArrayList<String> genres = parseGenres(parts[2]);
            double rating = parseDoubleComma(parts[3].trim());

            Movie movie = new Movie(title, releaseYear, genres, rating);
            movies.add(movie);
        }
        return movies;
    }
    public ArrayList<Series> loadSeries(String path) {
        ArrayList<String> lines = fileIO.readMedia(path);
        ArrayList<Series> series = new ArrayList<>();

        boolean onGoing;

        for (String line : lines) {
            if (line.endsWith(";")) {
                line = line.substring(0, line.length() - 1);
            }

            String[] parts = line.split(";");
            if (parts.length < 4) {
                System.out.println("ignore line. not enough fields:" + line);
                continue;
            }

            String title = parts[0].trim();
            String releaseYear = parts[1].trim();
            ArrayList<String> genres = parseGenres(parts[2]);
            double rating = parseDoubleComma(parts[3].trim());
            String seasons = parts[4].trim();

            Series serie = new Series(title, releaseYear, genres, rating, seasons);
            series.add(serie);
        }

        return series;
    }

    /**
     * This method converts a String to an integer. If not possible, the method returns -1 (to avoid crash)
     * @param s
     * @return Returns an integer
     */
    private static int parseInt(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * This method converts a "," to a ".". If not possible, the method will return -1.0 <p>
     * The method is primarily used to convert double variables from .csv-file written 1,0 to 1.0. (Used for converting rating doubles)
     * @param s
     * @return double
     */
    private static double parseDoubleComma(String s) {
        try {
            return Double.parseDouble(s.replace(",", "."));
        } catch (Exception e) {
            return -1.0;
        }
    }

    /**
     * This method creates a StringArray from a .csv-file. <p>
     * This method is primarily used to convert: Drama, history into: ["Drama", "History"].
     * @param pGenre
     * @return arraylist<String> of genres.
     */
    private static ArrayList<String> parseGenres(String pGenre) {
        ArrayList<String> result = new ArrayList<>();
        if (pGenre == null || pGenre.isBlank()) {
            return result;
        }

        String[] pGen = pGenre.split(",");
        for (String pG : pGen) {
            String g = pG.trim();
            if (!result.contains(g)) {
                result.add(g);
            }
        }
        return result;
    }
}
