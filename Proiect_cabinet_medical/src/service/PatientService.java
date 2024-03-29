package service;

import models.entity.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientService {

    Optional<Patient> getById(UUID id);


    List<Patient> getAllFromList();

    void addAllFromGivenList(List<Patient> patients);

    void addOnlyOne(Patient patient);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Patient newPatient);

    Optional <List<Patient>> getByName(String name);
}