package ro.pao.repository;

import ro.pao.model.cure.Cure;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CureRepository {

    Optional<Cure> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Cure newObject);

    void addNewObject(Cure Cure);

    List<Cure> getAll();

    void addAllFromGivenList(List<Cure> CureList);
}
