import java.util.Scanner;
import application.Menu;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Menu menu = Menu.getInstance();

            menu.intro();

            if ("exit".equals(scanner.next())) {
                break;
            }
        }
    }
}