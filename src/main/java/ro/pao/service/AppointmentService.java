package ro.pao.service;

import ro.pao.model.administration.Appointment;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * In interfata serviciului se definesc metodele pe care vrem sa le implementam.
 *
 * Metodele trebuie sa fie operatii pe baza tipului de obiect.
 *
 * In cazul de fata, avem clasa 'Appointment' si serviciul 'ExampleService'.
 * Vom avea operatii de baza doar pe obiectul 'Appointment'
 *
 * In cazul in care adaugam un nou obiect, de exemplu 'Animal', vom face un serviciu nou, pe nume 'AnimalService'
 * In acel serviciu se apeleaza doar metode pe obiectul 'Animal'.
 * De exemplu: "getAnimalById", "removeAnimalById" etc.
 */
public interface AppointmentService {

    Optional<Appointment> getById(UUID id) throws SQLException;

    Optional<List<Appointment>> getByData(Data date);
    Optional<List<Appointment>> getByDoctor(UUID id);

    List<Appointment> getAllFromList();

    List<Appointment> getAllWithCondition();

    void addAllFromGivenList(List<Appointment> AppointmentList);

    void addOnlyOne(Appointment Appointment);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Appointment newElement);
}
