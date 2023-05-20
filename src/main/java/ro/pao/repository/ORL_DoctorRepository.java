package ro.pao.repository;

import ro.pao.model.entity.ORL_Doctor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ORL_DoctorRepository {

    Optional<ORL_Doctor> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, ORL_Doctor newObject);

    void addNewObject(ORL_Doctor ORL_Doctor);

    List<ORL_Doctor> getAll();

    void addAllFromGivenList(List<ORL_Doctor> ORL_DoctorList);
}
