package ro.pao.service;

import ro.pao.model.entity.Cardiologist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'Cardiologist' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'Cardiologist'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface CardiologistService {

    Optional<Cardiologist> getById(UUID id);

    Optional<Cardiologist> getBySomeFieldOfClass(Object someFieldFromCardiologist);

    List<Cardiologist> getAllFromList();

    List<Cardiologist> getAllWithCondition();

    void addAllFromGivenList(List<Cardiologist> CardiologistList);

    void addOnlyOne(Cardiologist Cardiologist);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Cardiologist newElement);
}
