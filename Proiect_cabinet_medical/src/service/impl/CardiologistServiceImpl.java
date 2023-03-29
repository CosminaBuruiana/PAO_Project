package service.impl;

import models.administration.Appointment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import models.entity.Cardiologist;
import service.AppointmentService;
import service.CardiologistService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;



@NoArgsConstructor
@Getter
public class CardiologistServiceImpl implements CardiologistService {

    private static List<Cardiologist> CardiologistList = new ArrayList<>();

    @Override
    public Optional<Cardiologist> getById(UUID id) {

        return CardiologistList.stream()
                .filter(cardiologist -> cardiologist.getIdPerson().equals(id))
                .findAny();
    }

    @Override
    public Optional<Cardiologist> getBySomeFieldOfClass(Object someFieldFromAppointment) {
        return Optional.empty();
    }

    @Override
    public List<Cardiologist> getAllFromList() {
        return CardiologistList;
    }

    @Override
    public void addAllFromGivenList(List<Cardiologist> cardiologists) {
        CardiologistList.addAll(cardiologists);
    }

    @Override
    public void addOnlyOne(Cardiologist cardiologist) {
        CardiologistList.add(cardiologist);
    }

    @Override
    public void removeElementById(UUID id) {
        CardiologistList = CardiologistList.stream()
                .filter(element -> !id.equals(element.getIdPerson()))
                .collect(Collectors.toList());
    }

    @Override
    public void modificaElementById(UUID id, Cardiologist newCardiologist) {
        removeElementById(id);
        addOnlyOne(newCardiologist);
    }
}