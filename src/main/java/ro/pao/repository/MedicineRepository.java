package ro.pao.repository;

import ro.pao.model.cure.Medicine;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicineRepository {

    Optional<Medicine> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Medicine newObject);

    void addNewObject(Medicine Medicine);

    List<Medicine> getAll();

    void addAllFromGivenList(List<Medicine> MedicineList);
}
