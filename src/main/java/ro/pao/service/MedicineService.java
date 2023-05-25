package ro.pao.service;

import ro.pao.model.administration.Appointment;
import ro.pao.model.cure.Medicine;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'Medicine' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'Medicine'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface MedicineService {

    Optional<Medicine> getById(UUID id);

    Optional<Medicine> getByName(Medicine someFieldFromMedicine);

    Optional<List<Medicine>> getByPrice(Double price);

    List<Medicine> getAllFromList();

    List<Medicine> getAllWithCondition();

    void addAllFromGivenList(List<Medicine> MedicineList);

    void addOnlyOne(Medicine Medicine);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Medicine newElement);
}
