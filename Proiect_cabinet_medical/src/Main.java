import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import application.Menu;
import models.entity.*;
import models.management.MedicalClinic;

public class Main {

    public static void main(String[] args) throws ParseException {
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