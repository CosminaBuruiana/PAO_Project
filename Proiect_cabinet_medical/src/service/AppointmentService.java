package service;
import models.administration.Appointment;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentService {

    Optional<Appointment> getById(UUID id);

    Optional <List<Appointment>> getByData(String data);

    List<Appointment> getAllFromList();

    void addAllFromGivenList(List<Appointment> appointments);

    void addOnlyOne(Appointment appointment);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Appointment newAppointment);
}