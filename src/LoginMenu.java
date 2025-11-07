import Util.TextUI;

import java.util.HashMap;

public class LoginMenu {

    TextUI Ui = new TextUI();
    LoadUser loadUser = new LoadUser();

    private String username;
    private String password;


    /**
     * Metoden spørg om username og password.
     * som der efter kigger inde i vores hashmap for se om user'en eksister vis den gøre prøver man igen.
     * efter den har fået et gyldigt username indsætter den det i hashmappet som så bliver overført til en fil med "writeToFile".
     */
    public void signUp(){
        username = Ui.promptText("Enter a username: ");
        password = Ui.promptText("Enter a password: ");

        HashMap<String, String> accounts = loadUser.readFromFile();

        if(accounts.containsKey(username)){
            Ui.displayMsg("Username already in use! Please try agian.");
            return;
        }

        accounts.put(username, password);
        loadUser.writeToFile(accounts);

    }

    /**
     *Metoden starter ud med at be om username og password.
     * den vil så kigge ind i hashmap'et for at se om user'en eksister.
     * hvis den gøre fortsætter den til password og kigger om passworded matcher, hvis det gøre bliver du logget ind.
     * @return
     */
    public User login(){
        username = Ui.promptText("Enter a username: ");
        password = Ui.promptText("Enter a password: ");

        HashMap<String, String> accounts = loadUser.readFromFile();

        if(!accounts.containsKey(username)){
            Ui.displayMsg("No account with "+username+" found, try again.");
            return null;
        }

        String savedPassword = accounts.get(username);
        if(!savedPassword.equals(password)){
            Ui.displayMsg("Incorrect password");
            return null;
        }

        Ui.displayMsg("login successfull, Welcome "+ username+".");
        return new User(username, password);

    }

}
