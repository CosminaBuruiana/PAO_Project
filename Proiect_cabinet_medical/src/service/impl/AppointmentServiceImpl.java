package service.impl;

import administration.Appointment;
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

    private static List<Appointment> eggList = new ArrayList<>();

    @Override
    public Optional<Appointment> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Appointment> getBySomeFieldOfClass(Object someFieldFromAppointment) {
        return Optional.empty();
    }

    @Override
    public List<Appointment> getAllFromList() {
        return eggList;
    }

    @Override
    public void addAllFromGivenList(List<Appointment> appointments) {
        eggList.addAll(appointments);
    }

    @Override
    public void addOnlyOne(Appointment appointment) {
        eggList.add(appointment);
    }

    @Override
    public void removeElementById(UUID id) {
        eggList = eggList.stream()
                .filter(element -> !id.equals(element.getIdAppointment()))
                .collect(Collectors.toList());
    }

    @Override
    public void modificaElementById(UUID id, Appointment newAppointment) {
        removeElementById(id);
        addOnlyOne(newAppointment);
    }
}