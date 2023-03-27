package service.impl;

import cure.Cure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import service.CureService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class CureServiceImpl implements CureService {

    private static List<Cure> eggList = new ArrayList<>();

    @Override
    public Optional<Cure> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public Optional<Cure> getBySomeFieldOfClass(Object someFieldFromCure) {
        return Optional.empty();
    }

    @Override
    public List<Cure> getAllFromList() {
        return eggList;
    }

    @Override
    public void addAllFromGivenList(List<Cure> cures) {
        eggList.addAll(cures);
    }

    @Override
    public void addOnlyOne(Cure cure) {
        eggList.add(cure);
    }

    @Override
    public void removeElementById(UUID id) {
        eggList = eggList.stream()
                .filter(element -> !id.equals(element.getIdCure()))
                .collect(Collectors.toList());
    }

    @Override
    public void modificaElementById(UUID id, Cure newCure) {
        removeElementById(id);
        addOnlyOne(newCure);
    }
}