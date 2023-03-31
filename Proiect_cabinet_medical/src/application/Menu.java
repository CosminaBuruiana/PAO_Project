package application;
import models.entity.*;
import models.cure.Medicine;
import models.cure.enums.MedicineType;
import service.DoctorService;
import service.MedicineService;
import service.impl.DoctorServiceImpl;
import service.impl.MedicineServiceImpl;

import java.time.LocalDate;
import java.util.*;


public class Menu {

    private final DoctorService DoctorService = new DoctorServiceImpl();

    private final MedicineService MedicineService = new MedicineServiceImpl();



    private static Menu INSTANCE;

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }


    public void intro() {


        System.out.println("Choose an option: ");
        System.out.println("1. Add a doctor");
        System.out.println("2. List of patients");
        System.out.println("3. Add a doctor");
        System.out.println("4. Delete doctor");
        System.out.println("5. ");
        System.out.println("6. ");
        System.out.println("7.");
        System.out.println("8. ");
        System.out.println("9. ");
        System.out.println("10. ");


        Scanner keyboard = new Scanner(System.in);

        List<Person> listPerson = new ArrayList<>();
        List<Doctor> listDoctor = new ArrayList<>();
        List<Medicine> medicines = new ArrayList<>();

        listPerson.add(Patient.builder()
                .idPerson(UUID.randomUUID())
                .name("Singh")
                .last_name("Andrew")
                .email("singh.andrew@gmail.com")
                .CNP("6011217392288")
                .adress("Str.Ulmului, nr.6")
                .disease("cancer")
                .status("critical")
                .bloodType("B3")
                .medical_insurance(Boolean.FALSE)
                .phone_number("0786234123")
                .build());

        listPerson.add(Patient.builder()
                .idPerson(UUID.randomUUID())
                .name("Sava")
                .last_name("Maria")
                .email("sava.maria@gmail.com")
                .CNP("6013865392288")
                .adress("Str.Narcisei, nr.9")
                .disease("anorexia")
                .status("critical")
                .bloodType("AB4")
                .medical_insurance(Boolean.FALSE)
                .phone_number("0754234983")
                .build());

        listPerson.add(Patient.builder()
                .idPerson(UUID.randomUUID())
                .name("Ionescu")
                .last_name("Ana")
                .email("ionescu.ana@gmail.com")
                .CNP("6065217392232")
                .adress("Str.Ulmului, nr.11")
                .disease("gastritis")
                .status("mild")
                .bloodType("A2")
                .medical_insurance(Boolean.TRUE)
                .phone_number("0786236523")
                .build());

        listPerson.add(Cardiologist.builder()
                .idPerson(UUID.randomUUID())
                .name("Weed")
                .last_name("Roxanne")
                .email("weed.roxanne@gmail.com")
                .CNP("6011217387435")
                .adress("Str. Pinului, nr.98")
                .experience(12)
                .hire_date(LocalDate.now())
                .salary(Double.valueOf(10000))
                .phone_number("0786234123")
                .build());

        listPerson.add(ORL_Doctor.builder()
                .idPerson(UUID.randomUUID())
                .name("Cernica")
                .last_name("Sergiu")
                .email("cernica.sergiu@gmail.com")
                .CNP("6011217398764")
                .adress("Str. Lalelelor, nr.14")
                .experience(10)
                .hire_date(LocalDate.of(2013,4,23))
                .salary(Double.valueOf(12000))
                .phone_number("0786290875")
                .build());

        listPerson.add(Ophthalmologist.builder()
                .idPerson(UUID.randomUUID())
                .name("Zanfir")
                .last_name("Radu")
                .email("zanfir.radu@gmail.com")
                .CNP("6011217309873")
                .adress("Str. Zambilei, nr.6")
                .experience(4)
                .hire_date(LocalDate.of(2019,2,12))
                .salary(Double.valueOf(12000))
                .phone_number("0798634123")
                .build());

        listPerson.add(Cardiologist.builder()
                .idPerson(UUID.randomUUID())
                .name("Mircescu")
                .last_name("Vlad")
                .email("mircescu.vlad@gmail.com")
                .CNP("6011217987635")
                .adress("Str. Pinului, nr.10")
                .experience(25)
                .hire_date(LocalDate.now())
                .salary(Double.valueOf(109000))
                .phone_number("0799874123")
                .build());

        Collections.sort(medicines, (med1, med2) -> {
            if(med1.getPrice() < med2.getPrice()) {
                return -1;
            }
            else
                return 0;
        });


        MedicineService.getAllFromList();
        MedicineService.getAllFromList().forEach(System.out::println);


        medicines.add(Medicine.builder()
                .ID(UUID.randomUUID())
                .name("Fervex")
                .MedicineType(MedicineType.LIQUID.getTypeString())
                .price(Double.valueOf(45))
                .build());

        medicines.add(Medicine.builder()
                .ID(UUID.randomUUID())
                .name("Forcapil")
                .MedicineType(MedicineType.CAPSULES.getTypeString())
                .price(Double.valueOf(80))
                .build());

        medicines.add(Medicine.builder()
                .ID(UUID.randomUUID())
                .name("Nurofen")
                .MedicineType(MedicineType.DROPS.getTypeString())
                .price(Double.valueOf(25))
                .build());

        medicines.add(Medicine.builder()
                .ID(UUID.randomUUID())
                .name("Antinevralgic")
                .MedicineType(MedicineType.CAPSULES.getTypeString())
                .price(Double.valueOf(12))
                .build());

        medicines.add(Medicine.builder()
                .ID(UUID.randomUUID())
                .name("Paracetamol")
                .MedicineType(MedicineType.DROPS.getTypeString())
                .price(Double.valueOf(15))
                .build());


        Doctor doctor = Doctor.builder()
                .idPerson(UUID.randomUUID())
                .experience(Integer.valueOf(3))
                .hire_date(LocalDate.of(2021,3,12))
                .salary(Double.valueOf(21000))
                //.appointmentList(List.of(new Appointment(), new Appointment()))
                .build();

        Doctor doctor1 = Doctor.builder()
                .idPerson(UUID.randomUUID())
                .experience(Integer.valueOf(4))
                .hire_date(LocalDate.of(2019,03,12))
                .salary(Double.valueOf(12100))
                //.appointmentList(List.of(new Appointment(), new Appointment()))
                .build();


        DoctorService.addOnlyOne(doctor);
        DoctorService.addOnlyOne(doctor1);
        if ("1".equals(keyboard.next())) {

            DoctorService.addOnlyOne(doctor);
            DoctorService.addOnlyOne(doctor1);

        }

        if("2".equals(keyboard.next())){

            System.out.println("Inainte de stergere: ");
            DoctorService.getAllFromList()
                    .forEach(elementFromList -> System.out.println(elementFromList));

        }

        if("3".equals(keyboard.next())){


            System.out.println("Dupa modificare: ");
            doctor.setExperience(6);
            DoctorService.modificaElementById(doctor.getIdPerson(), doctor);
            DoctorService.getAllFromList()
                    .forEach(elementFromList -> System.out.println(elementFromList));

        }

        if("4".equals(keyboard.next())){

            System.out.println("Dupa stergere: ");
            DoctorService.removeElementById(doctor.getIdPerson());
            DoctorService.getAllFromList()
                    .forEach(elementFromList -> System.out.println(elementFromList));
        }

        if("5".equals(keyboard.next())){

        }

        if("6".equals(keyboard.next())){

        }

        if("7".equals(keyboard.next())){

        }

        if("8".equals(keyboard.next())){

        }

        if("9".equals(keyboard.next())){

        }

        if("10".equals(keyboard.next())){

        }




    }
}
