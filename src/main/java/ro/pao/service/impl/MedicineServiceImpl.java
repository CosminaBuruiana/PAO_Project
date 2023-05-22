package ro.pao.service.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ro.pao.application.csv.CsvReader;
import ro.pao.application.csv.CsvWriter;
import ro.pao.model.cure.Medicine;
import ro.pao.repository.MedicineRepository;
import ro.pao.service.MedicineService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Aici implementam metodele din interfata serviciului definit.
 */
@RequiredArgsConstructor
@Getter
public class MedicineServiceImpl implements MedicineService {

    private final MedicineRepository medicineRepository;

    @Override
    public Optional<Medicine> getById(UUID id) {
        return medicineRepository.getObjectById(id);
    }

    @Override
    public Optional<Medicine> getBySomeFieldOfClass(Object someFieldFromMedicine) {
        return Optional.empty();
    }

    @Override
    public List<Medicine> getAllFromList() {
        return medicineRepository.getAll();
    }

    @Override
    public List<Medicine> getAllWithCondition() {
        return null;
    }

    @Override
    public void addAllFromGivenList(List<Medicine> MedicineList) {
        medicineRepository.addAllFromGivenList(MedicineList);
    }

    @Override
    public void addOnlyOne(Medicine Medicine) {
        medicineRepository.addNewObject(Medicine);
    }

    @Override
    public void removeElementById(UUID id) {
        medicineRepository.deleteObjectById(id);
    }

    @Override
    public void modificaElementById(UUID id, Medicine newElement) {
        medicineRepository.updateObjectById(id, newElement);
    }

    /** Method Medicine that reads employees from csv */
    /*
    This code will print the contents of the CSV file to the console in two different formats:
    allLines: a list of arrays, where each array represents a row in the CSV file.
    lineByLine: a list of arrays, where each array represents a single line in the CSV file.

    The output will look something like this:

    [id, first_name, last_name, email, gender, age]
    [1, John, Doe, john.doe@Medicine.com, Male, 35]
    [2, Jane, Doe, jane.doe@Medicine.com, Female, 30]
    [3, Bob, Smith, bob.smith@Medicine.com, Male, 45]

    [1, John, Doe, john.doe@Medicine.com, Male, 35]
    [2, Jane, Doe, jane.doe@Medicine.com, Female, 30]
    [3, Bob, Smith, bob.smith@Medicine.com, Male, 45]
    This is just a simple Medicine, but I hope it helps you understand how you can use this CsvReader implementation in your own projects.
     */
    private void readFromCsv(List<Medicine> MedicineList) throws Exception {
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

    /** Method Medicine that writes employees to csv */
    private void writeToCsv(List<Medicine> MedicineList) throws Exception {
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
