package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.CardiologistMapper;
import ro.pao.model.entity.Cardiologist;
import ro.pao.repository.CardiologistRepository;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CardiologistRepositoryImpl implements CardiologistRepository {

    private static final CardiologistMapper cardiologistMapper = CardiologistMapper.getInstance();

    @Override
    public Optional<Cardiologist> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM cardiologist WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return cardiologistMapper.mapToCardiologist(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM cardiologist WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Cardiologist newObject) {
        String updateNameSql = "UPDATE cardiologist SET salary=? WHERE id=?";

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
    public void addNewObject(Cardiologist Cardiologist) {
        String insertSql = "INSERT INTO cardiologist (id, name,last_name, email,cnp,address,phone_number,hire_date,experience,salary) VALUES (?, ?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
                preparedStatement.setString(1, Cardiologist.getIdPerson().toString());
                preparedStatement.setString(2, Cardiologist.getName().toString());
                preparedStatement.setString(3,Cardiologist.getLast_name().toString());
                preparedStatement.setString(4, Cardiologist.getEmail().toString());
                preparedStatement.setString(5, Cardiologist.getCNP().toString());
                preparedStatement.setString(6, Cardiologist.getAdress().toString());
                preparedStatement.setString(7, Cardiologist.getPhone_number().toString());
                preparedStatement.setDate(8, Date.valueOf(Cardiologist.getHire_date().toString()));
                preparedStatement.setInt(9, Cardiologist.getExperience().intValue());
                preparedStatement.setDouble(10, Cardiologist.getSalary().doubleValue());

                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Cardiologist> getAll() {
        String selectSql = "SELECT * FROM cardiologist";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return cardiologistMapper.mapToCardiologistList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Cardiologist> CardiologistList) {
        CardiologistList.forEach(this::addNewObject);
    }
}
