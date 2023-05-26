package ro.pao.mapper;


import ro.pao.model.administration.Appointment;
import ro.pao.model.entity.Doctor;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class DoctorMapper {

    private static final DoctorMapper INSTANCE = new DoctorMapper();

    private DoctorMapper() {
    }

    public static DoctorMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Doctor> mapToDoctor(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Doctor.builder()
                            //.idPerson(UUID.fromString(resultSet.getString(1)))
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
                           // .appointmentList((List<Appointment>) resultSet.getArray(11))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Doctor> mapToDoctorList(ResultSet resultSet) throws SQLException {
        List<Doctor> DoctorList = new ArrayList<>();
        while (resultSet.next()) {
            DoctorList.add(
                    Doctor.builder()
                            //.idPerson(UUID.fromString(resultSet.getString(1)))
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
                           // .appointmentList((List<Appointment>) resultSet.getArray(11))
                            .build()
            );
        }

        return DoctorList;
    }
}
