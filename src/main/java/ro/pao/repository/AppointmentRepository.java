package ro.pao.repository;

import ro.pao.model.administration.Appointment;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentRepository {

    Optional<Appointment> getAppointmentById(UUID id);

//    Optional<Appointment> getAppointmentByData(Data date);
//    Optional<Appointment> getAppointmentByDoctor(UUID id);
    Optional<List<Appointment>> getObjectByData(String date);

    Optional<List<Appointment>> getObjectByDoctor(UUID id);

    void deleteAppointmentById(UUID id);

    void updateAppointmentById(UUID id, Appointment newAppointment);

    void addNewAppointment(Appointment Appointment);

    List<Appointment> getAll();

    void addAllFromGivenList(List<Appointment> AppointmentList);
}
