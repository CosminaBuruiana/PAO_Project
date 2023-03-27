package service.impl;

import entity.Doctor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import service.DoctorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class DoctorServiceImpl implements DoctorService {

    private static List<Doctor> eggList = new ArrayList<>();

    @Override
    public Optional<Doctor> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Doctor> getBySomeFieldOfClass(Object someFieldFromDoctor) {
        return Optional.empty();
    }

    @Override
    public List<Doctor> getAllFromList() {
        return eggList;
    }

    @Override
    public void addAllFromGivenList(List<Doctor> doctors) {
        eggList.addAll(doctors);
    }

    @Override
    public void addOnlyOne(Doctor doctor) {
        eggList.add(doctor);
    }

    @Override
    public void removeElementById(UUID id) {
        eggList = eggList.stream()
                .filter(element -> !id.equals(element.getIdPerson()))
                .collect(Collectors.toList());
    }

    @Override
    public void modificaElementById(UUID id, Doctor newDoctor) {
        removeElementById(id);
        addOnlyOne(newDoctor);
    }
}