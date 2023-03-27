package service;


import entity.Doctor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DoctorService {

    Optional<Doctor> getById(UUID id);

    Optional<Doctor> getBySomeFieldOfClass(Object someFieldFromDoctor);

    List<Doctor> getAllFromList();

    void addAllFromGivenList(List<Doctor> doctors);

    void addOnlyOne(Doctor doctor);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Doctor newDoctor);
}