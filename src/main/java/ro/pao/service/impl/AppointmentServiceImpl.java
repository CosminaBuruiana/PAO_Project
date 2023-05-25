package ro.pao.service.impl;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.application.csv.CsvReader;
import ro.pao.application.csv.CsvWriter;
import ro.pao.model.administration.Appointment;
import ro.pao.model.entity.Doctor;
import ro.pao.repository.AppointmentRepository;
import ro.pao.repository.DoctorRepository;
import ro.pao.service.AppointmentService;

import javax.xml.crypto.Data;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;


/**
 * Aici implementam metodele din interfata serviciului definit.
 */

@Getter
public class AppointmentServiceImpl implements AppointmentService {

    //private final AppointmentRepository appointmentRepository;
    private static final Logger logger = Logger.getGlobal();

    private final AppointmentRepository appointmentRepository;
    private static List<Appointment> appointmentList = new ArrayList<>();

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public Optional<Appointment> getById(UUID id) throws SQLException {

    //    Optional<Appointment> appointment = Optional.empty();
      //  appointment = appointmentRepository.getAppointmentById(id);


//        try {
//
//            appointment = appointmentRepository.getAppointmentById(id);
//
//        } catch (CustomFileNotFoundException e) {
//
//            logger.log(Level.WARNING, e.getMessage());
//
//        } catch (Exception e) {
//
//            logger.log(Level.SEVERE, e.getMessage());
//
//        }

        return appointmentRepository.getAppointmentById(id);


        // return appointment;
    }

    @Override
    public Optional<List<Appointment>> getByData(Data date) {

        //return Optional.empty();
        return appointmentRepository.getObjectByData(date);

    }

    @Override
    public Optional<List<Appointment>> getByDoctor(UUID id) {

        //return Optional.empty();
        return appointmentRepository.getObjectByDoctor(id);

    }

    @Override
    public List<Appointment> getAllFromList() {
        return appointmentRepository.getAll();
    }

    @Override
    public List<Appointment> getAllWithCondition() {
        return null;
    }

    @Override
    public void addAllFromGivenList(List<Appointment> AppointmentList) {
        appointmentRepository.addAllFromGivenList(AppointmentList);
    }

    @Override
    public void addOnlyOne(Appointment Appointment) {
        appointmentRepository.addNewAppointment(Appointment);
    }

    @Override
    public void removeElementById(UUID id) {
        appointmentRepository.deleteAppointmentById(id);
    }

    @Override
    public void modificaElementById(UUID id, Appointment newElement) {
        appointmentRepository.updateAppointmentById(id, newElement);
    }

    /** Method appointment that reads employees from csv */
    /*
    This code will print the contents of the CSV file to the console in two different formats:
    allLines: a list of arrays, where each array represents a row in the CSV file.
    lineByLine: a list of arrays, where each array represents a single line in the CSV file.

    The output will look something like this:

    [id, first_name, last_name, email, gender, age]
    [1, John, Doe, john.doe@appointment.com, Male, 35]
    [2, Jane, Doe, jane.doe@appointment.com, Female, 30]
    [3, Bob, Smith, bob.smith@appointment.com, Male, 45]

    [1, John, Doe, john.doe@appointment.com, Male, 35]
    [2, Jane, Doe, jane.doe@appointment.com, Female, 30]
    [3, Bob, Smith, bob.smith@appointment.com, Male, 45]
    This is just a simple appointment, but I hope it helps you understand how you can use this CsvReader implementation in your own projects.
     */
    private void readFromCsv(List<Appointment> AppointmentList) throws Exception {
        try {
            CsvReader csvReader = CsvReader.getInstance();

            // Read all lines at once
            List<String[]> allLines = csvReader.executeAllLines();
            for (String[] line : allLines) {
                System.out.println(Arrays.toString(line));
            }

            // Read line by line
            List<String[]> lineByLine = csvReader.executeLineByLine();
            for (String[] line : lineByLine) {
                System.out.println(Arrays.toString(line));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Method appointment that writes employees to csv */
    private void writeToCsv(List<Appointment> AppointmentList) throws Exception {
        // Suppose you have a list of String[] arrays representing rows in a CSV file, like this:
        List<String[]> lines = new ArrayList<>();
        lines.add(new String[] {"id", "name", "age"});
        lines.add(new String[] {"1", "John Doe", "35"});
        lines.add(new String[] {"2", "Jane Doe", "30"});
        lines.add(new String[] {"3", "Bob Smith", "45"});

        // To write this data to a CSV file using CsvWriter, you can write the following code:

        try {
            CsvWriter csvWriter = CsvWriter.getInstance();

            // Write line by line
            Path lineByLinePath = Paths.get("line_by_line.csv");

            //String lineByLineContentsPathDefined = csvWriter.executeLineByLine(lines);
            String lineByLineContents = csvWriter.writeLineByLine(lines, lineByLinePath);
            System.out.println("Contents of line_by_line.csv:");
            System.out.println(lineByLineContents);



            // Write all lines at once
            Path allLinesPath = Paths.get("all_lines.csv");
            //String allLinesContents = csvWriter.executeAllLines(lines);
            String allLinesContents = csvWriter.writeAllLines(lines, allLinesPath);
            System.out.println("Contents of all_lines.csv:");
            System.out.println(allLinesContents);

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        This code will write the contents of the lines list to two different CSV files: "line_by_line.csv" and "all_lines.csv". It will then read the contents of both files and print them to the console.
        The output will look something like this:

        Contents of line_by_line.csv:
    id,name,age
    1,John Doe,35
    2,Jane Doe,30
    3,Bob Smith,45

    Contents of all_lines.csv:
    id,name,age
    1,John Doe,35
    2,Jane Doe,30
    3,Bob Smith,45
         */
    }
}
