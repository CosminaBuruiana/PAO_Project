package service.impl;

import models.cure.Cure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import models.utils.ErrorMessage;
import service.CureService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class CureServiceImpl implements CureService, ErrorMessage {

    private static List<Cure> CureList = new ArrayList<>();

    @Override
    public Optional<Cure> getById(UUID id) {
        return CureList.stream()
                .filter(cure -> cure.getIdCure().equals(id))
                .findAny();
    }

    @Override
    public Optional <List<Cure>> getByName(String name)
    {
        List<Cure> list = CureList.stream().filter(Cure -> Cure.getName().equals(name)).collect(Collectors.toList());
        return Optional.of(list);}

    @Override
    public List<Cure> getAllFromList() {
        return CureList;
    }

    @Override
    public void addAllFromGivenList(List<Cure> cures) {
        CureList.addAll(cures);
    }

    @Override
    public void addOnlyOne(Cure cure) {
        CureList.add(cure);
    }

    @Override
    public void removeElementById(UUID id) {
        CureList = CureList.stream()
                .filter(element -> !id.equals(element.getIdCure()))
                .collect(Collectors.toList());
    }

    @Override
    public void modificaElementById(UUID id, Cure newCure) {
        removeElementById(id);
        addOnlyOne(newCure);
    }

    @Override
    public String errorMessage(String name) {
        return "There is no cure with name " + name + " in our database!";
    }
}