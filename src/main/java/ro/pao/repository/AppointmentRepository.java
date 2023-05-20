package ro.pao.repository;

import ro.pao.model.administration.Appointment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentRepository {

    Optional<Appointment> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Appointment newObject);

    void addNewObject(Appointment Appointment);

    List<Appointment> getAll();

    void addAllFromGivenList(List<Appointment> AppointmentList);
}
