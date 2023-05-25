package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.ORL_DoctorMapper;
import ro.pao.model.entity.ORL_Doctor;
import ro.pao.repository.ORL_DoctorRepository;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ORL_DoctorRepositoryImpl implements ORL_DoctorRepository {

    private static final ORL_DoctorMapper orlDoctorMapper = ORL_DoctorMapper.getInstance();

    @Override
    public Optional<ORL_Doctor> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM ORL_Doctor WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return orlDoctorMapper.mapToORL_Doctor(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM ORL_Doctor WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, ORL_Doctor newObject) {
        String updateNameSql = "UPDATE ORL_Doctor SET salary=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setDouble(1, newObject.getSalary().doubleValue());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(ORL_Doctor ORL_Doctor) {
        String insertSql = "INSERT INTO ORL_Doctor (id, name,last_name, email,cnp,address,phone_number,hire_date,experience,salary) VALUES (?, ?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, ORL_Doctor.getIdPerson().toString());
            preparedStatement.setString(2, ORL_Doctor.getName().toString());
            preparedStatement.setString(3,ORL_Doctor.getLast_name().toString());
            preparedStatement.setString(4, ORL_Doctor.getEmail().toString());
            preparedStatement.setString(5, ORL_Doctor.getCNP().toString());
            preparedStatement.setString(6, ORL_Doctor.getAdress().toString());
            preparedStatement.setString(7, ORL_Doctor.getPhone_number().toString());
            preparedStatement.setDate(8, Date.valueOf(ORL_Doctor.getHire_date().toString()));
            preparedStatement.setInt(9, ORL_Doctor.getExperience().intValue());
            preparedStatement.setDouble(10, ORL_Doctor.getSalary().doubleValue());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ORL_Doctor> getAll() {
        String selectSql = "SELECT * FROM ORL_Doctor";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return orlDoctorMapper.mapToORL_DoctorList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<ORL_Doctor> ORL_DoctorList) {
        ORL_DoctorList.forEach(this::addNewObject);
    }
}
