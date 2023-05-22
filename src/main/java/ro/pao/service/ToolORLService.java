package ro.pao.service;

import ro.pao.model.tool.ToolORL;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'ToolORL' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'ToolORL'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface ToolORLService {

    Optional<ToolORL> getById(UUID id);

    Optional<ToolORL> getBySomeFieldOfClass(Object someFieldFromToolORL);

    List<ToolORL> getAllFromList();

    List<ToolORL> getAllWithCondition();

    void addAllFromGivenList(List<ToolORL> ToolORLList);

    void addOnlyOne(ToolORL ToolORL);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, ToolORL newElement);
}
