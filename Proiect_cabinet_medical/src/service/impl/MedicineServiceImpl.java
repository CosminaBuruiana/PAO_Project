package service.impl;

import models.cure.Medicine;
import lombok.Getter;
import lombok.NoArgsConstructor;
import service.MedicineService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class MedicineServiceImpl implements MedicineService {

    private static List<Medicine> MedicineList = new ArrayList<>();

    @Override
    public Optional<Medicine> getById(UUID id) {

        return MedicineList.stream()
                .filter(Medicine -> Medicine.getID().equals(id))
                .findAny();
    }

    @Override
    public Optional<Medicine> getBySomeFieldOfClass(Object someFieldFromMedicine) {
        return Optional.empty();
    }

    @Override
    public List<Medicine> getAllFromList() {
        return MedicineList;
    }

    @Override
    public void addAllFromGivenList(List<Medicine> Medicines) {
        MedicineList.addAll(Medicines);
    }

    @Override
    public void addOnlyOne(Medicine Medicine) {
        MedicineList.add(Medicine);
    }

    @Override
    public void removeElementById(UUID id) {
        MedicineList = MedicineList.stream()
                .filter(element -> !id.equals(element.getID()))
                .collect(Collectors.toList());
    }

    @Override
    public void modificaElementById(UUID id, Medicine newMedicine) {
        removeElementById(id);
        addOnlyOne(newMedicine);
    }
}