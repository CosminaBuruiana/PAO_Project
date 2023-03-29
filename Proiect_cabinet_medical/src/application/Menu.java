package application;


import models.administration.Appointment;
import models.cure.Cure;
import models.entity.Person;
import models.cure.Medicine;
import models.cure.enums.MedicineType;
import models.entity.Doctor;
import service.DoctorService;
import service.impl.DoctorServiceImpl;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;



public class Menu {

    private final DoctorService DoctorService = new DoctorServiceImpl();

    private static Menu INSTANCE;

    private final DoctorService exampleService = new DoctorServiceImpl();

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void intro() {
        String intro = """
                Intro example:
                """;

        System.out.println(intro);

        Medicine medicine = Medicine.builder()
                .ID(UUID.randomUUID())
                .MedicineType(MedicineType.NONE)
                .price(Double.valueOf(123))
                .build();


        Doctor doctor = Doctor.builder()
                .idPerson(UUID.randomUUID())
                .experience(Integer.valueOf(3))
                .hire_date(LocalDate.of(2021,03,12))
                .salary(Double.valueOf(21000))
                //.appointmentList(List.of(new Appointment(), new Appointment()))
                .build();
        
        DoctorService.addOnlyOne(doctor);

        System.out.println("Inainte de stergere: ");
        DoctorService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));


        System.out.println("Dupa modificare: ");
              doctor.setExperience(6);
        DoctorService.modificaElementById(doctor.getIdPerson(), doctor);
        DoctorService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));

        System.out.println("Dupa stergere: ");
        DoctorService.removeElementById(doctor.getIdPerson());
        DoctorService.getAllFromList()
                .forEach(elementFromList -> System.out.println(elementFromList));


    }
}
