package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.OphthalmologistMapper;
import ro.pao.model.entity.Ophthalmologist;
import ro.pao.repository.OphthalmologistRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class OphthalmologistRepositoryImpl implements OphthalmologistRepository {

    private static final OphthalmologistMapper ophthalmologistMapper = OphthalmologistMapper.getInstance();

    @Override
    public Optional<Ophthalmologist> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM Ophthalmologist_table WHERE id=?";

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
        String updateNameSql = "DELETE FROM Ophthalmologist_table WHERE id=?";

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
        String updateNameSql = "UPDATE Ophthalmologist_table SET name=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
           // preparedStatement.setString(1, newObject.getOphthalmologistStringField());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(Ophthalmologist Ophthalmologist) {
        String insertSql = "INSERT INTO Ophthalmologist_table (id, name) VALUES (?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
           // preparedStatement.setString(1, Ophthalmologist.getId().toString());
           // preparedStatement.setString(2, Ophthalmologist.getOphthalmologistStringField());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ophthalmologist> getAll() {
        String selectSql = "SELECT * FROM Ophthalmologist_table";

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