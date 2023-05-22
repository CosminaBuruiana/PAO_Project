package ro.pao.service;

import ro.pao.model.entity.Patient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'Patient' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'Patient'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface PatientService {

    Optional<Patient> getById(UUID id);

    Optional<Patient> getBySomeFieldOfClass(Object someFieldFromPatient);

    List<Patient> getAllFromList();

    List<Patient> getAllWithCondition();

    void addAllFromGivenList(List<Patient> PatientList);

    void addOnlyOne(Patient Patient);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Patient newElement);
}
