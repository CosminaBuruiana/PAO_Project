package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.MedicineMapper;
import ro.pao.model.cure.Medicine;
import ro.pao.model.entity.Doctor;
import ro.pao.repository.MedicineRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MedicineRepositoryImpl implements MedicineRepository {

    private static final MedicineMapper medicineMapper = MedicineMapper.getInstance();

    @Override
    public Optional<Medicine> getObjectById(UUID id) {
        String selectSql = "SELECT * FROM medicine WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return medicineMapper.mapToMedicine(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void deleteObjectById(UUID id) {
        String updateNameSql = "DELETE FROM medicine WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateObjectById(UUID id, Medicine newObject) {
        String updateNameSql = "UPDATE medicine SET price=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setDouble(1, newObject.getPrice());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<List<Medicine>> getObjectByPrice(Double price) {
        String selectSql = "SELECT * FROM medicine WHERE price = ?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setDouble(1, Double.parseDouble(price.toString()));

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(medicineMapper.mapToMedicineList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }
    @Override
    public void addNewObject(Medicine Medicine) {
        String insertSql = "INSERT INTO medicine (id, name, price,medicine_type) VALUES (?, ?,?,?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, Medicine.getID().toString());
            preparedStatement.setString(2, Medicine.getName().toString());
            preparedStatement.setDouble(3, Medicine.getPrice().doubleValue());
            preparedStatement.setString(4, Medicine.getMedicineType().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Medicine> getAll() {
        String selectSql = "SELECT * FROM medicine";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return medicineMapper.mapToMedicineList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Medicine> MedicineList) {
        MedicineList.forEach(this::addNewObject);
    }
}
