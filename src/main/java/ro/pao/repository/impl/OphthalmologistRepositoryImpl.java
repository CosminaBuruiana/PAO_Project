package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.OphthalmologistMapper;
import ro.pao.model.entity.Ophthalmologist;
import ro.pao.repository.OphthalmologistRepository;

import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OphthalmologistRepositoryImpl implements OphthalmologistRepository {

    private static final OphthalmologistMapper ophthalmologistMapper = OphthalmologistMapper.getInstance();

    @Override
    public Optional<Ophthalmologist> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM Ophthalmologist WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return ophthalmologistMapper.mapToOphthalmologist(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM Ophthalmologist WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Ophthalmologist newObject) {
        String updateNameSql = "UPDATE Ophthalmologist SET salary=? WHERE id=?";

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
    public void addNewObject(Ophthalmologist Ophthalmologist) {
        String insertSql = "INSERT INTO Ophthalmologist (id, name,last_name, email,cnp,address,phone_number,hire_date,experience,salary) VALUES (?, ?,?,?,?,?,?,?,?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, Ophthalmologist.getIdPerson().toString());
            preparedStatement.setString(2, Ophthalmologist.getName().toString());
            preparedStatement.setString(3,Ophthalmologist.getLast_name().toString());
            preparedStatement.setString(4, Ophthalmologist.getEmail().toString());
            preparedStatement.setString(5, Ophthalmologist.getCNP().toString());
            preparedStatement.setString(6, Ophthalmologist.getAdress().toString());
            preparedStatement.setString(7, Ophthalmologist.getPhone_number().toString());
            preparedStatement.setDate(8, Date.valueOf(Ophthalmologist.getHire_date().toString()));
            preparedStatement.setInt(9, Ophthalmologist.getExperience().intValue());
            preparedStatement.setDouble(10, Ophthalmologist.getSalary().doubleValue());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ophthalmologist> getAll() {
        String selectSql = "SELECT * FROM Ophthalmologist";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return ophthalmologistMapper.mapToOphthalmologistList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Ophthalmologist> OphthalmologistList) {
        OphthalmologistList.forEach(this::addNewObject);
    }
}
