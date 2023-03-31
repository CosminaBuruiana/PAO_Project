package service;


import models.entity.ORL_Doctor;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ORL_DoctorService {

    Optional<ORL_Doctor> getById(UUID id);

    Optional <List<ORL_Doctor>> getByName(String name);

    List<ORL_Doctor> getAllFromList();

    void addAllFromGivenList(List<ORL_Doctor> ORL_Doctors);

    void addOnlyOne(ORL_Doctor ORL_Doctor);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, ORL_Doctor newORL_Doctor);
}