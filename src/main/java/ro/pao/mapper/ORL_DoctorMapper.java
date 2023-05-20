package ro.pao.mapper;


import ro.pao.model.administration.Appointment;
import ro.pao.model.entity.ORL_Doctor;
import ro.pao.model.enums.EnumExample;
import ro.pao.model.tool.ToolORL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class ORL_DoctorMapper {

    private static final ORL_DoctorMapper INSTANCE = new ORL_DoctorMapper();

    private ORL_DoctorMapper() {
    }

    public static ORL_DoctorMapper getInstance() {
        return INSTANCE;
    }


    public Optional<ORL_Doctor> mapToORL_Doctor(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    ORL_Doctor.builder()
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
                            .tool((ToolORL) resultSet.getObject(12))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<ORL_Doctor> mapToORL_DoctorList(ResultSet resultSet) throws SQLException {
        List<ORL_Doctor> ORL_DoctorList = new ArrayList<>();
        while (resultSet.next()) {
            ORL_DoctorList.add(
                    ORL_Doctor.builder()
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
                            .tool((ToolORL) resultSet.getObject(12))
                            .build()
            );
        }

        return ORL_DoctorList;
    }
}
