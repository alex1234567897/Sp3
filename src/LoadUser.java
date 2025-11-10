import Util.FileIO;
import Util.TextUI;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class LoadUser {
    private FileIO Io = new FileIO();
    private TextUI Ui = new TextUI();
    // -- initialiser Hashmappet --
    private HashMap<String, String> accounts = new HashMap<>();
    private final String FILE_NAME = "Data/Accounts.csv";

//readFromFile bruges til at logge eksisterende brugere ind i programmet, som henter data fra filen Accounts
    public HashMap<String, String> readFromFile() {
        HashMap<String, String> accounts = Io.readData(FILE_NAME);

        return accounts;
    }


    //Der benyttes en hashmap til at gemme data i filen, accounts, når der bliver oprettet en ny bruger.

    public void writeToFile(HashMap<String, String> addedAccount) {
        this.accounts = addedAccount;
    try (FileWriter writer = new FileWriter("Data/Accounts.csv" , false)) {
            for (String username : accounts.keySet()) {
                writer.write(username + ";" + accounts.get(username) + "\n");
            }
            writer.close();
        } catch (IOException e){
            Ui.displayMsg("fejl");
        }


    }


}
