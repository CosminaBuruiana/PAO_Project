package ro.pao.mapper;


import ro.pao.model.administration.Appointment;
import ro.pao.model.enums.EnumExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AppointmentMapper {

    private static final AppointmentMapper INSTANCE = new AppointmentMapper();

    private AppointmentMapper() {
    }

    public static AppointmentMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Appointment> mapToAppointment(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Appointment.builder()
                            .idAppointment(UUID.fromString(resultSet.getString(1)))
                            .data(resultSet.getDate(2))
                            .price(resultSet.getDouble(3))
                            .id_doctor(UUID.fromString(resultSet.getString(4)))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Appointment> mapToAppointmentList(ResultSet resultSet) throws SQLException {
        List<Appointment> AppointmentList = new ArrayList<>();
        while (resultSet.next()) {
            AppointmentList.add(
                    Appointment.builder()
                            .idAppointment(UUID.fromString(resultSet.getString(1)))
                            .data(resultSet.getDate(2))
                            .price(resultSet.getDouble(3))
                            .id_doctor(UUID.fromString(resultSet.getString(4)))
                            .build()
            );
        }

        return AppointmentList;
    }
}
