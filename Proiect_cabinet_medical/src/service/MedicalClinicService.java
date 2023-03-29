package service;


import models.management.MedicalClinic;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MedicalClinicService {

    Optional<MedicalClinic> getById(UUID id);

    Optional<MedicalClinic> getBySomeFieldOfClass(Object someFieldFromMedicalClinic);

    List<MedicalClinic> getAllFromList();

    void addAllFromGivenList(List<MedicalClinic> MedicalClinics);

    void addOnlyOne(MedicalClinic MedicalClinic);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, MedicalClinic newMedicalClinic);
}