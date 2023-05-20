package ro.pao.repository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import ro.pao.model.entity.Doctor;
import java.util.List;
import java.util.Optional; 
import java.util.UUID;

public interface DoctorRepository {

    Optional<Doctor> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, Doctor newObject);

    void addNewObject(Doctor Doctor);

    List<Doctor> getAll();

    void addAllFromGivenList(List<Doctor> DoctorList);
}
