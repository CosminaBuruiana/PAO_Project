package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.PatientMapper;
import ro.pao.model.entity.Patient;
import ro.pao.repository.PatientRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PatientRepositoryImpl implements PatientRepository {

    private static final PatientMapper patientMapper = PatientMapper.getInstance();

    @Override
    public Optional<Patient> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM patient WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return patientMapper.mapToPatient(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM patient WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Patient newObject) {
        String updateNameSql = "UPDATE patient SET disease=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newObject.getDisease());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Patient Patient) {
        String insertSql = "INSERT INTO person (id, name,last_name, email, cnp, address,phone_number, status, disease,blood_type,medical_insurance) VALUES (?, ?,?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
                preparedStatement.setString(1, Patient.getIdPerson().toString());
                preparedStatement.setString(2, Patient.getName().toString());
                preparedStatement.setString(3, Patient.getLast_name().toString());
                preparedStatement.setString(4, Patient.getEmail().toString());
                preparedStatement.setString(5, Patient.getCNP().toString());
                preparedStatement.setString(6, Patient.getAdress().toString());
                preparedStatement.setString(7, Patient.getPhone_number().toString());
            preparedStatement.setString(8, Patient.getStatus().toString());
            preparedStatement.setString(9, Patient.getDisease().toString());
            preparedStatement.setString(10, Patient.getBloodType());
            preparedStatement.setString(11, Patient.getMedical_insurance());


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Patient> getAll() {
        String selectSql = "SELECT * FROM patient p,person pr where p.id = pr.id";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return patientMapper.mapToPatientList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Patient> PatientList) {
        PatientList.forEach(this::addNewObject);
    }
}
