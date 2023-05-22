package ro.pao.service;

import ro.pao.model.tool.ToolOphthalmologist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'ToolOphthalmologist' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'ToolOphthalmologist'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface ToolOphthalmologistService {

    Optional<ToolOphthalmologist> getById(UUID id);

    Optional<ToolOphthalmologist> getBySomeFieldOfClass(Object someFieldFromToolOphthalmologist);

    List<ToolOphthalmologist> getAllFromList();

    List<ToolOphthalmologist> getAllWithCondition();

    void addAllFromGivenList(List<ToolOphthalmologist> ToolOphthalmologistList);

    void addOnlyOne(ToolOphthalmologist ToolOphthalmologist);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, ToolOphthalmologist newElement);
}
