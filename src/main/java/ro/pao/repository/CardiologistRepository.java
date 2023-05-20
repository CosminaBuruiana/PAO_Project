package ro.pao.repository;

import ro.pao.model.entity.Cardiologist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CardiologistRepository {

    Optional<Cardiologist> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Cardiologist newObject);

    void addNewObject(Cardiologist Cardiologist);

    List<Cardiologist> getAll();

    void addAllFromGivenList(List<Cardiologist> CardiologistList);
}
