package service.impl;

import entity.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import service.PatientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class PatientServiceImpl implements PatientService {

    private static List<Patient> eggList = new ArrayList<>();

    @Override
    public Optional<Patient> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Patient> getBySomeFieldOfClass(Object someFieldFromPatient) {
        return Optional.empty();
    }

    @Override
    public List<Patient> getAllFromList() {
        return eggList;
    }

    @Override
    public void addAllFromGivenList(List<Patient> patients) {
        eggList.addAll(patients);
    }

    @Override
    public void addOnlyOne(Patient patient) {
        eggList.add(patient);
    }

    @Override
    public void removeElementById(UUID id) {
        eggList = eggList.stream()
                .filter(element -> !id.equals(element.getIdPerson()))
                .collect(Collectors.toList());
    }

    @Override
    public void modificaElementById(UUID id, Patient newPatient) {
        removeElementById(id);
        addOnlyOne(newPatient);
    }
}