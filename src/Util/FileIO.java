package Util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class FileIO {

    public void saveData(ArrayList<String> list, String path, String header){
        try {

            FileWriter writer = new FileWriter(path);
            writer.write(header+"\n");
            for (String s : list) {
                writer.write(s+"\n");
            }
            writer.close();

        }catch (IOException e) {
            System.out.println("problem: "+ e.getMessage());
        }
    }

    public HashMap<String, String> readData(String path) {
        HashMap<String, String> data = new HashMap<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();

            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.trim().split(";");
                if(parts.length == 2){
                    String username = parts[0].trim();
                    String password = parts[1].trim();
                data.put(username, password);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return data;
    }

    public ArrayList<String> readMedia(String path) {
        ArrayList<String> data = new ArrayList<>();
        File file = new File(path);
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine(); // skip header "Name, Score"

            while (scan.hasNextLine()) {
                String line = scan.nextLine();   //  "Egon, 1000000"
                data.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen findes ikke");
        }
        return data;
    }
}