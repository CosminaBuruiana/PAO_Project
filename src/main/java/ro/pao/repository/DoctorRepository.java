package ro.pao.repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import ro.pao.model.administration.Appointment;
import ro.pao.model.entity.Doctor;
import java.util.List;
import java.util.Optional; 
import java.util.UUID;

public interface DoctorRepository {

    Optional<Doctor> getDoctorById(UUID id);
    Optional<List<Doctor>> getObjectByName(String name);

    void deleteDoctorById(UUID id);

    void updateDoctorById(UUID id, Doctor newDoctor);

    void addNewDoctor(Doctor Doctor);

    List<Doctor> getAll();

    void addAllFromGivenList(List<Doctor> DoctorList);
}
