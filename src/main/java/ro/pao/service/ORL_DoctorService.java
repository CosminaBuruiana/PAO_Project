package ro.pao.service;

import ro.pao.model.entity.ORL_Doctor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'ORL_Doctor' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'ORL_Doctor'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface ORL_DoctorService {

    Optional<ORL_Doctor> getById(UUID id);

    Optional<ORL_Doctor> getBySomeFieldOfClass(Object someFieldFromORL_Doctor);

    List<ORL_Doctor> getAllFromList();

    List<ORL_Doctor> getAllWithCondition();

    void addAllFromGivenList(List<ORL_Doctor> ORL_DoctorList);

    void addOnlyOne(ORL_Doctor ORL_Doctor);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, ORL_Doctor newElement);
}
