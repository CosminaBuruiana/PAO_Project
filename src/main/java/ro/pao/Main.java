package ro.pao;

import ro.pao.application.Menu;
import ro.pao.config.DatabaseConfiguration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static java.time.chrono.JapaneseEra.values;

public class Main {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            Menu menu = Menu.getInstance();
//
//
//            menu.intro();
//
//            if ("exit".equals(scanner.next())) {
//                break;
//            }
//        }

        DatabaseConfiguration dc = new DatabaseConfiguration();
        dc.getDatabaseConnection();
        System.out.println("Get of connection");

        String selectSql = "SELECT * FROM example_table WHERE id=?";
        //String value = "insert into person(id,name) values (?,?)";
        String value = "insert into person(id,name) values (5,'Ion')";
        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(value)) {
           // preparedStatement.setString(1, "2");
            //preparedStatement.setString(2, "Ion");
            int result = preparedStatement.executeUpdate();
            System.out.println(result);
           // return exampleClassMapper.mapToExampleClass(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        dc.closeDatabaseConnection();
        System.out.println("End of connection");


    }
}
