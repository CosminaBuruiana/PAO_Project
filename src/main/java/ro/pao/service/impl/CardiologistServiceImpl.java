package ro.pao.service.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.application.csv.CsvReader;
import ro.pao.application.csv.CsvWriter;
import ro.pao.model.entity.Cardiologist;
import ro.pao.model.entity.Doctor;
import ro.pao.repository.CardiologistRepository;
import ro.pao.repository.DoctorRepository;
import ro.pao.service.CardiologistService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Aici implementam metodele din interfata serviciului definit.
 */
@RequiredArgsConstructor
@Getter
public class CardiologistServiceImpl implements CardiologistService {
    private final CardiologistRepository cardiologistRepository;
    private static List<Cardiologist> cardiologistList = new ArrayList<>();

    @Override
    public Optional<Cardiologist> getById(UUID id) {
        return cardiologistRepository.getObjectById(id);
    }

    @Override
    public Optional<Cardiologist> getBySomeFieldOfClass(Object someFieldFromCardiologist) {
        return Optional.empty();
    }

    @Override
    public List<Cardiologist> getAllFromList() {
        return cardiologistRepository.getAll();
    }

    @Override
    public List<Cardiologist> getAllWithCondition() {
        return null;
    }

    @Override
    public void addAllFromGivenList(List<Cardiologist> CardiologistList) {
        cardiologistRepository.addAllFromGivenList(CardiologistList);
    }

    @Override
    public void addOnlyOne(Cardiologist Cardiologist) {
        cardiologistRepository.addNewObject(Cardiologist);
    }

    @Override
    public void removeElementById(UUID id) {
        cardiologistRepository.deleteObjectById(id);
    }

    @Override
    public void modificaElementById(UUID id, Cardiologist newElement) {
        cardiologistRepository.updateObjectById(id, newElement);
    }

    /** Method cardiologist that reads employees from csv */
    /*
    This code will print the contents of the CSV file to the console in two different formats:
    allLines: a list of arrays, where each array represents a row in the CSV file.
    lineByLine: a list of arrays, where each array represents a single line in the CSV file.

    The output will look something like this:

    [id, first_name, last_name, email, gender, age]
    [1, John, Doe, john.doe@cardiologist.com, Male, 35]
    [2, Jane, Doe, jane.doe@cardiologist.com, Female, 30]
    [3, Bob, Smith, bob.smith@cardiologist.com, Male, 45]

    [1, John, Doe, john.doe@cardiologist.com, Male, 35]
    [2, Jane, Doe, jane.doe@cardiologist.com, Female, 30]
    [3, Bob, Smith, bob.smith@cardiologist.com, Male, 45]
    This is just a simple cardiologist, but I hope it helps you understand how you can use this CsvReader implementation in your own projects.
     */
    private void readFromCsv(List<Cardiologist> CardiologistList) throws Exception {
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

    /** Method cardiologist that writes employees to csv */
    private void writeToCsv(List<Cardiologist> CardiologistList) throws Exception {
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
