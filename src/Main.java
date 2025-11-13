import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        MainMenu Menu = new MainMenu();
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.signMethod();
        Menu.displayMenu();

    }
}