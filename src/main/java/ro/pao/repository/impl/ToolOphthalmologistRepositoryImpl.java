package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.ToolOphthalmologistMapper;
import ro.pao.model.tool.ToolOphthalmologist;
import ro.pao.repository.ExampleRepository;
import ro.pao.repository.ToolOphthalmologistRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ToolOphthalmologistRepositoryImpl implements ToolOphthalmologistRepository {

    private static final ToolOphthalmologistMapper toolOphthalmologistMapper = ToolOphthalmologistMapper.getInstance();

    @Override
    public Optional<ToolOphthalmologist> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM toolOphthalmologist WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return toolOphthalmologistMapper.mapToToolOphthalmologist(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM toolOphthalmologist WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, ToolOphthalmologist newObject) {
        String updateNameSql = "UPDATE toolOphthalmologist SET name=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, newObject.getName());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewObject(ToolOphthalmologist ToolOphthalmologist) {
        String insertSql = "INSERT INTO toolOphthalmologist (id, name) VALUES (?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, ToolOphthalmologist.getId().toString());
            preparedStatement.setString(2, ToolOphthalmologist.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ToolOphthalmologist> getAll() {
        String selectSql = "SELECT * FROM toolOphthalmologist";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return toolOphthalmologistMapper.mapToToolOphthalmologistList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<ToolOphthalmologist> ToolOphthalmologistList) {
        ToolOphthalmologistList.forEach(this::addNewObject);
    }
}
