package ro.pao.application;

import ro.pao.model.ExampleClass;
import ro.pao.model.entity.Doctor;
import ro.pao.model.entity.ORL_Doctor;
import ro.pao.repository.impl.*;
import ro.pao.service.*;
import ro.pao.service.impl.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * In Meniu se fac operatiile care pot lua informatii din toate dintre servicile definite.
 * De exemplu, avem definit mai jos `private final ExampleService exampleService = new ExampleServiceImpl();`
 *
 * In cazul in care aveam definit mai multe servicii, la fel, faceam o initializare a serviciile si astfel apelam metode din serviciu.
 */
public class Menu {

    private static Menu INSTANCE;

    private final ExampleService exampleService = new ExampleServiceImpl(new ExampleRepositoryImpl());
    private final MedicineService medicineService = new MedicineServiceImpl(new MedicineRepositoryImpl());

    private final CureService cureService = new CureServiceImpl(new CureRepositoryImpl());

    private final DoctorService doctorService = new DoctorServiceImpl(new DoctorRepositoryImpl());

    private final PatientService patientService = new PatientServiceImpl(new PatientRepositoryImpl());

    private final ORL_DoctorService doctorORLService = new ORL_DoctorServiceImpl(new ORL_DoctorRepositoryImpl());

    private final OphthalmologistService ophthalmologistService = new OphthalmologistServiceImpl(new OphthalmologistRepositoryImpl());

    private final CardiologistService cardiologistService = new CardiologistServiceImpl(new CardiologistRepositoryImpl());

    private final AppointmentService appointmentService = new AppointmentServiceImpl(new AppointmentRepositoryImpl());

    private static final Logger logger = Logger.getGlobal();

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void intro() {
        String intro = """
                Intro example
                """;

        System.out.println(intro);

        Doctor doctor = Doctor.builder()
                .idPerson(UUID.randomUUID())
                .name(String.valueOf("Ana")) // data de azi
                .last_name(String.valueOf("Popescu"))
                .salary(Double.valueOf(3212))
                .experience(Integer.valueOf(3))
                .build();

        //doctorService.addOnlyOne(doctor);

//        List<Doctor> doctorServiceList = List.of(
//                ExampleClass.builder()
//                        .id(UUID.randomUUID())
//                        .creationDate(LocalDate.of(2023, 03, 22))
//                        .updateDate(LocalDate.now())
//                        .build(),
//                ExampleClass.builder()
//                        .id(UUID.randomUUID())
//                        .creationDate(LocalDate.of(2023, 03, 22))
//                        .updateDate(LocalDate.now())
//                        .build()
//        );

//        exampleService.addAllFromGivenList(exampleServiceList);
//
//        System.out.println("Inainte de stergere: ");
//        exampleService.getAllFromList()
//                .forEach(elementFromList -> System.out.println(elementFromList));


//        System.out.println("Dupa modificare: ");
//        exampleClass.setUpdateDate(LocalDate.of(2, 2, 2));
//        exampleService.modificaElementById(exampleClass.getId(), exampleClass);
//        exampleService.getAllFromList()
//                .forEach(elementFromList -> System.out.println(elementFromList));
//
//        System.out.println("Dupa stergere: ");
//        exampleService.removeElementById(exampleClass.getId());
//        exampleService.getAllFromList()
//                .forEach(elementFromList -> System.out.println(elementFromList));
    }
}
