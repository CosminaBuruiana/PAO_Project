package ro.pao.repository;

import ro.pao.model.entity.Ophthalmologist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OphthalmologistRepository {

    Optional<Ophthalmologist> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Ophthalmologist newObject);

    void addNewObject(Ophthalmologist Ophthalmologist);

    List<Ophthalmologist> getAll();

    void addAllFromGivenList(List<Ophthalmologist> OphthalmologistList);
}
