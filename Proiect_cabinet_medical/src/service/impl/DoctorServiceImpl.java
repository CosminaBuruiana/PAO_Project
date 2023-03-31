package service.impl;

import models.entity.Doctor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import models.utils.ErrorMessage;
import service.DoctorService;

import java.util.*;
import java.util.stream.Collectors;


@NoArgsConstructor
@Getter
public class DoctorServiceImpl implements DoctorService, ErrorMessage {

    private static List<Doctor> DoctorList = new ArrayList<>();

    @Override
    public Optional<Doctor> getById(UUID id) {

        return DoctorList.stream()
                .filter(doctor -> doctor.getIdPerson().equals(id))
                .findAny();
    }

    @Override
    public Optional <List<Doctor>> getByName(String name)
    {
        List<Doctor> list = DoctorList.stream().filter(Doctor -> Doctor.getName().equals(name)).collect(Collectors.toList());
        return Optional.of(list);}

    @Override
    public List<Doctor> getAllFromList() {
        return DoctorList;
    }

    @Override
    public void addAllFromGivenList(List<Doctor> doctors) {
        DoctorList.addAll(doctors);
    }

    @Override
    public void addOnlyOne(Doctor doctor) {
        DoctorList.add(doctor);
    }

    @Override
    public void removeElementById(UUID id) {
        DoctorList = DoctorList.stream()
                .filter(element -> !id.equals(element.getIdPerson()))
                .collect(Collectors.toList());
    }

    @Override
    public void modificaElementById(UUID id, Doctor newDoctor) {
        removeElementById(id);
        addOnlyOne(newDoctor);
    }


    @Override
    public String errorMessage(String name) {
        return "There is no doctor with name " + name + " in our database!";
    }

}