package service;


import models.cure.Medicine;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicineService {

    Optional<Medicine> getById(UUID id);

    Optional<Medicine> getBySomeFieldOfClass(Object someFieldFromMedicine);

    List<Medicine> getAllFromList();

    void addAllFromGivenList(List<Medicine> Medicines);

    void addOnlyOne(Medicine Medicine);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Medicine newMedicine);
}