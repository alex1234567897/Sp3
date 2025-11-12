import Util.FileIO;
import Util.TextUI;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LoadUser {
    private FileIO Io = new FileIO();
    private TextUI Ui = new TextUI();
    // -- initialiser Hashmappet --
    private ArrayList<String[]> accounts = new ArrayList<>();
    private final String FILE_NAME = "Data/Accounts.csv";

//readFromFile bruges til at logge eksisterende brugere ind i programmet, som henter data fra filen Accounts
    public ArrayList<String[]> readFromFile() {
        ArrayList<String[]> fileAccounts = Io.readData(FILE_NAME);
        if(fileAccounts == null){
            Ui.displayMsg("Problem arised");
            return new ArrayList<>();
        }
        ArrayList<String[]> cleaned = new ArrayList<>();
        for(String[] parts : fileAccounts){
            if(parts != null && parts.length >= 2){
                cleaned.add(parts);
            }
        }
        this.accounts = cleaned;
        return cleaned;
    }


    //Der benyttes en hashmap til at gemme data i filen, accounts, når der bliver oprettet en ny bruger.

    public void writeToFile(ArrayList<String[]> addedAccount) {
        this.accounts = addedAccount;
    try (FileWriter writer = new FileWriter(FILE_NAME, false)) {
            for (String[] account : accounts) {
                if(account != null && account.length >= 2) {
                    writer.write(account[0] + ";" + account[1] + "\n");
                }
            }
        } catch (IOException e){
            Ui.displayMsg("fejl");
        }


    }


}
