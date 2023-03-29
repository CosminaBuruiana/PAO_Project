package service;

import models.entity.Cardiologist;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CardiologistService {

    Optional<Cardiologist> getById(UUID id);

    Optional<Cardiologist> getBySomeFieldOfClass(Object someFieldFromCardiologist);

    List<Cardiologist> getAllFromList();

    void addAllFromGivenList(List<Cardiologist> cardiologists);

    void addOnlyOne(Cardiologist cardiologist);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Cardiologist newCardiologist);
}