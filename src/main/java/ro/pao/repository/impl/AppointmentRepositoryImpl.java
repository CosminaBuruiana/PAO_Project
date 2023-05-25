package ro.pao.repository.impl;

import ro.pao.config.DatabaseConfiguration;
import ro.pao.mapper.AppointmentMapper;
import ro.pao.model.administration.Appointment;
import ro.pao.repository.AppointmentRepository;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AppointmentRepositoryImpl implements AppointmentRepository {

    private static final AppointmentMapper appointmentMapper = AppointmentMapper.getInstance();

    @Override
    public Optional<Appointment> getAppointmentById(UUID id) {
        String id_app = "SELECT * FROM appointment WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(id_app)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return appointmentMapper.mapToAppointment(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
    @Override
    public Optional<List<Appointment>> getObjectByData(Data date) {
        String selectSql = "SELECT * FROM appointment WHERE data=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, date.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(appointmentMapper.mapToAppointmentList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }

    @Override
    public Optional<List<Appointment>> getObjectByDoctor(UUID id) {
        String selectSql = "SELECT * FROM appointment WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
            preparedStatement.setString(1, id.toString());

            ResultSet resultSet = preparedStatement.executeQuery();
            return Optional.ofNullable(appointmentMapper.mapToAppointmentList(resultSet));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Optional.empty();

    }
    @Override
    public void deleteAppointmentById(UUID id) {
        String updateNameSql = "DELETE FROM appointment WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setString(1, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAppointmentById(UUID id, Appointment newAppointment) {
        String updateNameSql = "UPDATE appointment SET price=? WHERE id=?";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(updateNameSql)) {
            preparedStatement.setDouble(1, newAppointment.getPrice());
            preparedStatement.setString(2, id.toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addNewAppointment(Appointment Appointment) {
        String insertSql = "INSERT INTO appointment (id, data, price, id_doctor) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
            preparedStatement.setString(1, Appointment.getIdAppointment().toString());
            preparedStatement.setDate(2, Date.valueOf(Appointment.getData().toString()));
            preparedStatement.setDouble(3, Appointment.getPrice().doubleValue());
            preparedStatement.setString(4,Appointment.getId_doctor().toString());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Appointment> getAll() {
        String selectSql = "SELECT * FROM appointment";

        try (Connection connection = DatabaseConfiguration.getDatabaseConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            return appointmentMapper.mapToAppointmentList(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List.of();
    }

    @Override
    public void addAllFromGivenList(List<Appointment> AppointmentList) {
        AppointmentList.forEach(this::addNewAppointment);
    }
}
