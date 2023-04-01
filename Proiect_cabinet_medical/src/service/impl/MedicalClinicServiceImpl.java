package service.impl;

import models.management.MedicalClinic;
import lombok.Getter;
import lombok.NoArgsConstructor;
import models.utils.ErrorMessage;
import service.MedicalClinicService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class MedicalClinicServiceImpl implements MedicalClinicService, ErrorMessage {

    private static List<MedicalClinic> MedicalClinicList = new ArrayList<>();

    @Override
    public Optional<MedicalClinic> getById(UUID id) {

        return MedicalClinicList.stream()
                .filter(MedicalClinic -> MedicalClinic.getId().equals(id))
                .findAny();
    }

    @Override
    public Optional <List<MedicalClinic>> getByName(String name)
    {
        List<MedicalClinic> list = MedicalClinicList.stream().filter(MedicalClinic -> MedicalClinic.getName().equals(name)).collect(Collectors.toList());
        return Optional.of(list);}

    @Override
    public List<MedicalClinic> getAllFromList() {
        return MedicalClinicList;
    }

    @Override
    public void addAllFromGivenList(List<MedicalClinic> MedicalClinics) {
        MedicalClinicList.addAll(MedicalClinics);
    }

    @Override
    public void addOnlyOne(MedicalClinic MedicalClinic) {
        MedicalClinicList.add(MedicalClinic);
    }

    @Override
    public void removeElementById(UUID id) {
        MedicalClinicList = MedicalClinicList.stream()
                .filter(element -> !id.equals(element.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public void modificaElementById(UUID id, MedicalClinic newMedicalClinic) {
        removeElementById(id);
        addOnlyOne(newMedicalClinic);
    }

    @Override
    public String errorMessage(String name) {
        return "There is no Medical Clinic with name " + name + " in our database!";
    }
}