package ro.pao.repository.impl;
import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.DoctorMapper;
import ro.pao.model.entity.Doctor;
import ro.pao.repository.DoctorRepository;
import ro.pao.threads.AsyncLogger;
import ro.pao.threads.ThreadExecuter;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Level;


public class DoctorRepositoryImpl implements DoctorRepository {

    private static final DoctorMapper doctorMapper = DoctorMapper.getInstance();

    @Override
    public Optional<Doctor> getDoctorById(String id) {
        String selectSql = "SELECT * FROM doctor WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return doctorMapper.mapToDoctor(resultSet);
        } catch (SQLException e) {
            AsyncLogger.getInstance().log(Level.SEVERE,
                    "Getting doctor by id failed\n" + e.getMessage());
        }

        return Optional.empty();
    }
    @Override
    public Optional<List<Doctor>> getObjectByName(String name) {
        String selectSql = "SELECT * FROM doctor WHERE name = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, name.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(doctorMapper.mapToDoctorList(resultSet));
        } catch (SQLException e) {
            AsyncLogger.getInstance().log(Level.SEVERE,
                    "Getting doctor by name failed\n" + e.getMessage());
        }

        return Optional.empty();

    }

    @Override
    public void deleteDoctorById(String id) {
        String updateNameSql = "DELETE FROM doctor WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)){
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            ThreadExecuter.getInstance().add(() -> {
                AsyncLogger.getInstance().log(Level.SEVERE,
                        "Deleting doctor failed\n" + e.getMessage());
            });
        }
    }



    @Override
    public void updateDoctorById(String id, Doctor newDoctor) {
        String updateNameSql = "UPDATE doctor SET salary=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
           preparedStatement.setDouble(1, newDoctor.getSalary().doubleValue());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            AsyncLogger.getInstance().log(Level.SEVERE,
                    "Updating doctor failed\n" + e.getMessage());
        }
    }

    @Override
    public void addNewDoctor(Doctor Doctor) {
        String insertSql = "INSERT INTO doctor (id, name,last_name, email, cnp, address,phone_number, hire_date,experience, salary) VALUES (?, ?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
             preparedStatement.setString(1, Doctor.getIdPerson().toString());
             preparedStatement.setString(2, Doctor.getName().toString());
            preparedStatement.setString(3, Doctor.getLast_name().toString());
            preparedStatement.setString(4, Doctor.getEmail().toString());
            preparedStatement.setString(5, Doctor.getCNP().toString());
            preparedStatement.setString(6, Doctor.getAdress().toString());
            preparedStatement.setString(7, Doctor.getPhone_number().toString());
            preparedStatement.setString(8, Doctor.getHire_date().toString());
            preparedStatement.setInt(9, Doctor.getExperience().intValue());
            preparedStatement.setDouble(10, Doctor.getSalary().doubleValue());



            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            AsyncLogger.getInstance().log(Level.SEVERE,
                    "Inserting doctor failed\n" + e.getMessage());
        }
    }

    @Override
    public List<Doctor> getAll() {
        String selectSql = "SELECT * FROM doctor";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return doctorMapper.mapToDoctorList(resultSet);
        } catch (SQLException e) {
            AsyncLogger.getInstance().log(Level.SEVERE,
                    "Get all doctors failed\n" + e.getMessage());
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Doctor> DoctorList) {
        DoctorList.forEach(this::addNewDoctor);
    }
}
