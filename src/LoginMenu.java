import Util.TextUI;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginMenu {

    TextUI Ui = new TextUI();
    LoadUser loadUser = new LoadUser();

    private String username;
    private String password;

    /**
     * Metoden spørg om du ville login eller signUp.
     * hvis du svar Y så vil du login, hvis N så laver du en account.
     */

    public void signMethod(){
        String choice = Ui.promptText("Do you want to: \n1: Login\n2: Signup\n0: Exit");
        if(choice.equals("1")){
            login();
        } else if(choice.equals("2")) {
            signUp();
        }else if (choice.equals("0")){
            int c = 1;
            c = 0;
            Ui.displayMsg("closing service.");
            System.exit(c);
        } else {
            Ui.displayMsg("Invalid input, Try again.");
            signMethod();
        }
    }

    /**
     * Metoden spørg om username og password.
     * som der efter kigger inde i vores hashmap for se om user'en eksister vis den gøre prøver man igen.
     * efter den har fået et gyldigt username indsætter den det i hashmappet som så bliver overført til en fil med "writeToFile".
     */
    public void signUp(){
        username = Ui.promptText("Enter a username: ");
        password = Ui.promptText("Enter a password: ");

        ArrayList<String[]> accounts = loadUser.readFromFile();

        if(usernameExists(accounts, username)) {
            Ui.displayMsg("Username already in use! Please try agian.");
            signUp();
            return;
        }

        accounts.add(new String[] { username, password });
        loadUser.writeToFile(accounts);
        Ui.displayMsg("You have succesfully created an account.");

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

        ArrayList<String[]> accounts = loadUser.readFromFile();

        int id = findUserIndex(accounts, username);
        if (id == -1) {
            Ui.displayMsg("No account with "+username+" found, try again.");
            signUp();
            return null;
        }

        String[] s = accounts.get(id);
        String savedPassword = s[1];

        if (!savedPassword.equals(password)) {
            Ui.displayMsg("Incorrect password!");
            return null;
        }

        Ui.displayMsg("login successfull, Welcome "+ username+".");
        return new User(username, password);
    }

    private int findUserIndex(ArrayList<String[]> accounts, String user) {
        for (int i = 0; i < accounts.size(); i++) {
            String[] s = accounts.get(i);
            if (s.length >= 2 && s[0].equals(user)) {
                return i;
            }
        }
        return -1;
    }

    private boolean usernameExists(ArrayList<String[]> accounts, String user) {
        return findUserIndex(accounts, user) != -1;
    }
}
