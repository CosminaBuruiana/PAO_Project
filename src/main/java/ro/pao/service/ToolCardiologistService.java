package ro.pao.service;

import ro.pao.model.tool.ToolCardiologist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'ToolCardiologist' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'ToolCardiologist'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface ToolCardiologistService {

    Optional<ToolCardiologist> getById(UUID id);

    Optional<ToolCardiologist> getBySomeFieldOfClass(Object someFieldFromToolCardiologist);

    List<ToolCardiologist> getAllFromList();

    List<ToolCardiologist> getAllWithCondition();

    void addAllFromGivenList(List<ToolCardiologist> ToolCardiologistList);

    void addOnlyOne(ToolCardiologist ToolCardiologist);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, ToolCardiologist newElement);
}
