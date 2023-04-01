package service.impl;

import models.entity.Patient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import service.PatientService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import models.utils.ErrorMessage;

@NoArgsConstructor
@Getter
public class PatientServiceImpl implements PatientService, ErrorMessage {

    private static List<Patient> PatientList = new ArrayList<>();

    @Override
    public Optional<Patient> getById(UUID id) {
        return PatientList.stream()
                .filter(patient -> patient.getIdPerson().equals(id))
                .findAny();
    }

    @Override
    public List<Patient> getAllFromList() {
        return PatientList;
    }

    @Override
    public void addAllFromGivenList(List<Patient> patients) {
        PatientList.addAll(patients);
    }

    @Override
    public void addOnlyOne(Patient patient) {
        PatientList.add(patient);
    }

    @Override
    public void removeElementById(UUID id) {
        PatientList = PatientList.stream()
                .filter(element -> !id.equals(element.getIdPerson()))
                .collect(Collectors.toList());
    }

    @Override
    public void modificaElementById(UUID id, Patient newPatient) {
        removeElementById(id);
        addOnlyOne(newPatient);
    }
    @Override
    public Optional <List<Patient>> getByName(String name)
    {
        List<Patient> list = PatientList.stream().filter(patient -> patient.getName().equals(name)).collect(Collectors.toList());
        return Optional.of(list);}


    @Override
    public String errorMessage(String name) {
        return "This patient doesn't exist in our database!";
    }
}