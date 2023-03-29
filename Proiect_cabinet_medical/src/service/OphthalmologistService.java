package service;


import models.entity.Ophthalmologist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OphthalmologistService {

    Optional<Ophthalmologist> getById(UUID id);

    Optional<Ophthalmologist> getBySomeFieldOfClass(Object someFieldFromOphtalmologist);

    List<Ophthalmologist> getAllFromList();

    void addAllFromGivenList(List<Ophthalmologist> ophtalmologists);

    void addOnlyOne(Ophthalmologist Ophtalmologist);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Ophthalmologist newOphtalmologist);
}