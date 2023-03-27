package service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import cure.Cure;

public interface CureService {

    Optional<Cure> getById(UUID id);

    Optional<Cure> getBySomeFieldOfClass(Object someFieldFromCure);

    List<Cure> getAllFromList();

    void addAllFromGivenList(List<Cure> cures);

    void addOnlyOne(Cure cure);

    void removeElementById(UUID id);

    void modificaElementById(UUID id, Cure newCure);
}