package ro.pao.repository;

import ro.pao.model.entity.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PatientRepository {

    Optional<Patient> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Patient newObject);

    void addNewObject(Patient Patient);

    List<Patient> getAll();

    void addAllFromGivenList(List<Patient> PatientList);
}
