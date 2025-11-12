import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        MainMenu Menu = new MainMenu();
        LoginMenu user = new LoginMenu();
        user.signMethod();
        Menu.displayMenu();
        Menu.playMedia();

    }
}