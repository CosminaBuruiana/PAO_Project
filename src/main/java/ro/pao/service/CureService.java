package ro.pao.service;

import ro.pao.model.cure.Cure;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'Cure' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'Cure'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface CureService {

    Optional<Cure> getById(UUID id);

    Optional<Cure> getBySomeFieldOfClass(Object someFieldFromCure);

    List<Cure> getAllFromList();

    List<Cure> getAllWithCondition();

    void addAllFromGivenList(List<Cure> CureList);

    void addOnlyOne(Cure Cure);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Cure newElement);
}
