package service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import models.cure.Cure;

public interface CureService {

    Optional<Cure> getById(UUID id);

    Optional <List<Cure>> getByName(String name);

    List<Cure> getAllFromList();

    void addAllFromGivenList(List<Cure> cures);

    void addOnlyOne(Cure cure);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Cure newCure);
}