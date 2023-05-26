package ro.pao.mapper;


import ro.pao.model.administration.Appointment;
import ro.pao.model.entity.Cardiologist;
import ro.pao.model.enums.EnumExample;
import ro.pao.model.tool.ToolCardiologist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class CardiologistMapper {

    private static final CardiologistMapper INSTANCE = new CardiologistMapper();

    private CardiologistMapper() {
    }

    public static CardiologistMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Cardiologist> mapToCardiologist(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Cardiologist.builder()
                           // .idPerson(UUID.fromString(resultSet.getString(1)))
                            .idPerson(resultSet.getString(1))
                            .name(resultSet.getString(2))
                            .last_name(resultSet.getString(3))
                            .email(resultSet.getString(4))
                            .CNP(resultSet.getString(5))
                            .adress(resultSet.getString(6))
                            .phone_number(resultSet.getString(7))
                            .hire_date(resultSet.getString(8))
                            .experience(resultSet.getInt(9))
                            .salary(resultSet.getDouble(10))
                            //.appointmentList((List<Appointment>) resultSet.getArray(11))
                            //.tool((ToolCardiologist) resultSet.getObject(12))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Cardiologist> mapToCardiologistList(ResultSet resultSet) throws SQLException {
        List<Cardiologist> CardiologistList = new ArrayList<>();
        while (resultSet.next()) {
            CardiologistList.add(
                    Cardiologist.builder()
                            .idPerson(resultSet.getString(1))
                            .name(resultSet.getString(2))
                            .last_name(resultSet.getString(3))
                            .email(resultSet.getString(4))
                            .CNP(resultSet.getString(5))
                            .adress(resultSet.getString(6))
                            .phone_number(resultSet.getString(7))
                            .hire_date(resultSet.getString(8))
                            .experience(resultSet.getInt(9))
                            .salary(resultSet.getDouble(10))
                            .appointmentList((List<Appointment>) resultSet.getArray(11))
                            .tool((ToolCardiologist) resultSet.getObject(12))
                            .build()
            );
        }

        return CardiologistList;
    }
}
