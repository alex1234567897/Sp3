import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
//1-8, 2-22;

class SeriesTest {

    @Test
    void makeSeasonsInSeries() {
        ArrayList <String> genre = new  ArrayList<String>();
        genre.add("Crime");
        genre.add("Drama");
        genre.add("Mystery");
        ArrayList <Integer> episodes = new ArrayList<>();
        episodes.add(8);
        episodes.add(22);
        episodes.add(1);
        episodes.add(4);
        Series serier = new Series("Twin Peaks", genre,8.8,false,episodes,4);
        serier.makeSeasonsInSeries();



    }

    @Test
    void testToString() {
        ArrayList <String> genre = new  ArrayList<String>();
        genre.add("Crime");
        genre.add("Drama");
        genre.add("Mystery");
        ArrayList <Integer> episodes = new ArrayList<>();
        episodes.add(8);
        episodes.add(22);
        episodes.add(1);
        episodes.add(4);
        Series serier = new Series("Twin Peaks", genre,8.8,false,episodes,4);
        System.out.println(serier.toString());
    }
}