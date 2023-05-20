package ro.pao.mapper;


import ro.pao.model.administration.Appointment;
import ro.pao.model.entity.Ophthalmologist;
import ro.pao.model.enums.EnumExample;
import ro.pao.model.tool.ToolOphthalmologist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class OphthalmologistMapper {

    private static final OphthalmologistMapper INSTANCE = new OphthalmologistMapper();

    private OphthalmologistMapper() {
    }

    public static OphthalmologistMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Ophthalmologist> mapToOphthalmologist(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Ophthalmologist.builder()
                            .idPerson(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .last_name(resultSet.getString(3))
                            .email(resultSet.getString(4))
                            .CNP(resultSet.getString(5))
                            .adress(resultSet.getString(6))
                            .phone_number(resultSet.getString(7))
                            .hire_date(resultSet.getDate(8))
                            .experience(resultSet.getInt(9))
                            .salary(resultSet.getDouble(10))
                            .appointmentList((List<Appointment>) resultSet.getArray(11))
                            .tool((ToolOphthalmologist) resultSet.getObject(12))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Ophthalmologist> mapToOphthalmologistList(ResultSet resultSet) throws SQLException {
        List<Ophthalmologist> OphthalmologistList = new ArrayList<>();
        while (resultSet.next()) {
            OphthalmologistList.add(
                    Ophthalmologist.builder()
                            .idPerson(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .last_name(resultSet.getString(3))
                            .email(resultSet.getString(4))
                            .CNP(resultSet.getString(5))
                            .adress(resultSet.getString(6))
                            .phone_number(resultSet.getString(7))
                            .hire_date(resultSet.getDate(8))
                            .experience(resultSet.getInt(9))
                            .salary(resultSet.getDouble(10))
                            .appointmentList((List<Appointment>) resultSet.getArray(11))
                            .tool((ToolOphthalmologist) resultSet.getObject(12))
                            .build()
            );
        }

        return OphthalmologistList;
    }
}
