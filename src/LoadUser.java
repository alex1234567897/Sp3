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


    public HashMap<String, String> readFromFile() {
        HashMap<String, String> accounts = Io.readData(FILE_NAME);

        return accounts;
    }

    public void writeToFile(HashMap<String, String> addedAccount) {
        this.accounts = addedAccount;
    try (FileWriter writer = new FileWriter("Data/Accounts.csv" , true)) {
            for (String username : accounts.keySet()) {
                writer.write(username + ":" + accounts.get(username) + "\n");

            }
            writer.close();
        } catch (IOException e){
            Ui.displayMsg("fejl");
        }


    }


}
