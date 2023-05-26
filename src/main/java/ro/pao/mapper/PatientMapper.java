package ro.pao.mapper;


import ro.pao.model.administration.Appointment;
import ro.pao.model.cure.Cure;
import ro.pao.model.entity.Patient;
import ro.pao.model.enums.EnumExample;
import ro.pao.model.tool.ToolCardiologist;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class PatientMapper {

    private static final PatientMapper INSTANCE = new PatientMapper();

    private PatientMapper() {
    }

    public static PatientMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Patient> mapToPatient(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Patient.builder()
                            //.idPerson(UUID.fromString(resultSet.getString(1)))
                            .idPerson((resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .last_name(resultSet.getString(3))
                            .email(resultSet.getString(4))
                            .CNP(resultSet.getString(5))
                            .adress(resultSet.getString(6))
                            .phone_number(resultSet.getString(7))
                            .status(resultSet.getString(8))
                            .disease(resultSet.getString(9))
                            .bloodType(resultSet.getString(10))
                            .medical_insurance(resultSet.getString(11))
                            .appointment((Appointment) resultSet.getObject(12))
                            .cure((Cure) resultSet.getObject(13))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Patient> mapToPatientList(ResultSet resultSet) throws SQLException {
        List<Patient> PatientList = new ArrayList<>();
        while (resultSet.next()) {
            PatientList.add(
                    Patient.builder()
                            //.idPerson(UUID.fromString(resultSet.getString(1)))
                            .idPerson(resultSet.getString(1))
                            .name(resultSet.getString(2))
                            .last_name(resultSet.getString(3))
                            .email(resultSet.getString(4))
                            .CNP(resultSet.getString(5))
                            .adress(resultSet.getString(6))
                            .phone_number(resultSet.getString(7))
                            .status(resultSet.getString(8))
                            .disease(resultSet.getString(9))
                            .bloodType(resultSet.getString(10))
                            .medical_insurance(resultSet.getString(11))
                            .appointment((Appointment) resultSet.getObject(12))
                            .cure((Cure) resultSet.getObject(13))
                            .build()
            );
        }

        return PatientList;
    }
}
