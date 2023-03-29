package service.impl;

import models.entity.Ophthalmologist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import service.OphthalmologistService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class OphthalmologistServiceImpl implements OphthalmologistService {

    private static List<Ophthalmologist> OphthalmologistList = new ArrayList<>();

    @Override
    public Optional<Ophthalmologist> getById(UUID id) {

        return OphthalmologistList.stream()
                .filter(Ophthalmologist -> Ophthalmologist.getIdPerson().equals(id))
                .findAny();
    }

    @Override
    public Optional<Ophthalmologist> getBySomeFieldOfClass(Object someFieldFromOphthalmologist) {
        return Optional.empty();
    }

    @Override
    public List<Ophthalmologist> getAllFromList() {
        return OphthalmologistList;
    }

    @Override
    public void addAllFromGivenList(List<Ophthalmologist> Ophthalmologists) {
        OphthalmologistList.addAll(Ophthalmologists);
    }

    @Override
    public void addOnlyOne(Ophthalmologist Ophthalmologist) {
        OphthalmologistList.add(Ophthalmologist);
    }

    @Override
    public void removeElementById(UUID id) {
        OphthalmologistList = OphthalmologistList.stream()
                .filter(element -> !id.equals(element.getIdPerson()))
                .collect(Collectors.toList());
    }

    @Override
    public void modificaElementById(UUID id, Ophthalmologist newOphthalmologist) {
        removeElementById(id);
        addOnlyOne(newOphthalmologist);
    }
}