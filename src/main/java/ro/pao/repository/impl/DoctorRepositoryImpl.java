package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.DoctorMapper;
import ro.pao.model.administration.Appointment;
import ro.pao.model.entity.Doctor;
import ro.pao.repository.DoctorRepository;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DoctorRepositoryImpl implements DoctorRepository {

    private static final DoctorMapper doctorMapper = DoctorMapper.getInstance();

    @Override
    public Optional<Doctor> getDoctorById(UUID id) {
        String selectSql = "SELECT * FROM doctor WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return doctorMapper.mapToDoctor(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }

        return Optional.empty();

    }

    @Override
    public void deleteDoctorById(UUID id) {
        String updateNameSql = "DELETE FROM doctor WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void updateDoctorById(UUID id, Doctor newDoctor) {
        String updateNameSql = "UPDATE doctor SET salary=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
           preparedStatement.setDouble(1, newDoctor.getSalary().doubleValue());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
            preparedStatement.setDate(8, Date.valueOf(Doctor.getHire_date().toString()));
            preparedStatement.setInt(9, Doctor.getExperience().intValue());
            preparedStatement.setDouble(10, Doctor.getSalary().doubleValue());



            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Doctor> DoctorList) {
        DoctorList.forEach(this::addNewDoctor);
    }
}
