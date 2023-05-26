package ro.pao;
import ro.pao.application.Menu;
import ro.pao.threads.AsyncLogger;
import ro.pao.threads.ThreadExecuter;

import java.util.Scanner;
import java.util.logging.Level;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ThreadExecuter.getInstance().start();

        while (true) {
            Menu menu = Menu.getInstance();
            if (menu.intro()) {
                AsyncLogger.getInstance().log(Level.INFO, "Try exiting ...");
                ThreadExecuter.getInstance().stop();
                break;
            }
        }

        ThreadExecuter.getInstance().join();
    }
}
