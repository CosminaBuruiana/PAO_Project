package service;


import administration.Appointment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentService {

    Optional<Appointment> getById(UUID id);

    Optional<Appointment> getBySomeFieldOfClass(Object someFieldFromAppointment);

    List<Appointment> getAllFromList();

    void addAllFromGivenList(List<Appointment> appointments);

    void addOnlyOne(Appointment appointment);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Appointment newAppointment);
}