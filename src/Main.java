import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        LoginMenu user = new LoginMenu();
        SearchFunction search = new SearchFunction();



        user.signMethod();

        search.searchByName();

    }
}