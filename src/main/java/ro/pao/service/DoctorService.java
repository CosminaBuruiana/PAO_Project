package ro.pao.service;

import ro.pao.model.entity.Doctor;
import ro.pao.repository.DoctorRepository;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'Doctor' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'Doctor'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface DoctorService {

    Optional<Doctor> getById(UUID id);

    Optional<List<Doctor>> getByName(String name);

    Optional<Doctor> getBySomeFieldOfClass(Doctor someFieldFromDoctor);

    List<Doctor> getAllFromList();

    List<Doctor> getAllWithCondition();

    void addAllFromGivenList(List<Doctor> DoctorList);

    void addOnlyOne(Doctor Doctor);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Doctor newElement);
}
