package service.impl;

import models.administration.Appointment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import service.AppointmentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class AppointmentServiceImpl implements AppointmentService {

    private static List<Appointment> AppointmentList = new ArrayList<>();

    @Override
    public Optional<Appointment> getById(UUID id) {

        return AppointmentList.stream()
                .filter(appointment -> appointment.getIdAppointment().equals(id))
                .findAny();
    }

    @Override
    public Optional<Appointment> getBySomeFieldOfClass(Object someFieldFromAppointment) {
        return Optional.empty();
    }

    @Override
    public List<Appointment> getAllFromList() {
        return AppointmentList;
    }

    @Override
    public void addAllFromGivenList(List<Appointment> appointments) {
        AppointmentList.addAll(appointments);
    }

    @Override
    public void addOnlyOne(Appointment appointment) {
        AppointmentList.add(appointment);
    }

    @Override
    public void removeElementById(UUID id) {
        AppointmentList = AppointmentList.stream()
                .filter(element -> !id.equals(element.getIdAppointment()))
                .collect(Collectors.toList());
    }

    @Override
    public void modificaElementById(UUID id, Appointment newAppointment) {
        removeElementById(id);
        addOnlyOne(newAppointment);
    }
}