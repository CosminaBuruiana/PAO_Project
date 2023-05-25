package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.ToolCardiologistMapper;
import ro.pao.model.tool.ToolCardiologist;
import ro.pao.repository.ExampleRepository;
import ro.pao.repository.ToolCardiologistRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ToolCardiologistRepositoryImpl implements ToolCardiologistRepository {

    private static final ToolCardiologistMapper toolCardiologistMapper = ToolCardiologistMapper.getInstance();

    @Override
    public Optional<ToolCardiologist> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM toolcardiologist WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return toolCardiologistMapper.mapToToolCardiologist(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM toolcardiologist WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, ToolCardiologist newObject) {
        String updateNameSql = "UPDATE toolcardiologist SET name=? WHERE id=?";

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
    public void addNewObject(ToolCardiologist ToolCardiologist) {
        String insertSql = "INSERT INTO toolcardiologist (id, name) VALUES (?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, ToolCardiologist.getId().toString());
            preparedStatement.setString(2, ToolCardiologist.getName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<ToolCardiologist> getAll() {
        String selectSql = "SELECT * FROM toolcardiologist";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return toolCardiologistMapper.mapToToolCardiologistList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<ToolCardiologist> ToolCardiologistList) {
        ToolCardiologistList.forEach(this::addNewObject);
    }
}
