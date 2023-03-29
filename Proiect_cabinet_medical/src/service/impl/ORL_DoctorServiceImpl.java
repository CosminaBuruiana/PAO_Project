package service.impl;

import models.entity.ORL_Doctor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import service.ORL_DoctorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class ORL_DoctorServiceImpl implements ORL_DoctorService {

    private static List<ORL_Doctor> ORL_DoctorList = new ArrayList<>();

    @Override
    public Optional<ORL_Doctor> getById(UUID id) {

        return ORL_DoctorList.stream()
                .filter(ORL_Doctor -> ORL_Doctor.getIdPerson().equals(id))
                .findAny();
    }

    @Override
    public Optional<ORL_Doctor> getBySomeFieldOfClass(Object someFieldFromORL_Doctor) {
        return Optional.empty();
    }

    @Override
    public List<ORL_Doctor> getAllFromList() {
        return ORL_DoctorList;
    }

    @Override
    public void addAllFromGivenList(List<ORL_Doctor> ORL_Doctors) {
        ORL_DoctorList.addAll(ORL_Doctors);
    }

    @Override
    public void addOnlyOne(ORL_Doctor ORL_Doctor) {
        ORL_DoctorList.add(ORL_Doctor);
    }

    @Override
    public void removeElementById(UUID id) {
        ORL_DoctorList = ORL_DoctorList.stream()
                .filter(element -> !id.equals(element.getIdPerson()))
                .collect(Collectors.toList());
    }

    @Override
    public void modificaElementById(UUID id, ORL_Doctor newORL_Doctor) {
        removeElementById(id);
        addOnlyOne(newORL_Doctor);
    }
}