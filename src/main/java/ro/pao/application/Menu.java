package ro.pao.application;

import ro.pao.model.ExampleClass;
import ro.pao.model.administration.Appointment;
import ro.pao.model.cure.Medicine;
import ro.pao.model.entity.*;
import ro.pao.repository.impl.*;
import ro.pao.service.*;
import ro.pao.service.impl.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

    public boolean intro() {
        String intro = """
                Intro example
                """;

        System.out.println(intro);

        System.out.println("Choose an option: ");
       // System.out.println("0. Create a list of doctor");
        System.out.println("1. Add a doctor");
        System.out.println("2. List of doctors");
        System.out.println("3. Modify the doctor experience");
        System.out.println("4. Delete doctor");
        System.out.println("5. Sort the doctors by salary");
        System.out.println("6. Sort the medicines by price");
//        System.out.println("7. Create an appointment");
//        System.out.println("8. Remove an appointment for a doctor");
//        System.out.println("9. Add an appointment for a doctor");
//        System.out.println("10. Appointments list by a date");
//        System.out.println("11. Appointments list by a doctor");


        Scanner keyboard = new Scanner(System.in);

        List<Person> listPerson = new ArrayList<>();

        listPerson.add(Patient.builder()
                //.idPerson(UUID.randomUUID())
                .idPerson(("22"))
                .name("Singh")
                .last_name("Andrew")
                .email("singh.andrew@gmail.com")
                .CNP("6011217392288")
                .adress("Str.Ulmului, nr.6")
                .disease("cancer")
                .status("critical")
                .bloodType("B3")
                .medical_insurance("No")
                .phone_number("0786234123")
                .build());

        listPerson.add(Patient.builder()
                //.idPerson(UUID.randomUUID())
                .idPerson(("21"))
                .name("Sava")
                .last_name("Maria")
                .email("sava.maria@gmail.com")
                .CNP("6013865392288")
                .adress("Str.Narcisei, nr.9")
                .disease("anorexia")
                .status("critical")
                .bloodType("AB4")
                .medical_insurance("No")
                .phone_number("0754234983")
                .build());

        listPerson.add(Patient.builder()
                //.idPerson(UUID.randomUUID())
                .idPerson(("20"))
                .name("Ionescu")
                .last_name("Ana")
                .email("ionescu.ana@gmail.com")
                .CNP("6065217392232")
                .adress("Str.Ulmului, nr.11")
                .disease("gastritis")
                .status("mild")
                .bloodType("A2")
                .medical_insurance("No")
                .phone_number("0786236523")
                .build());

        listPerson.add(Cardiologist.builder()
                //.idPerson(UUID.randomUUID())
                .idPerson("19")
                .name("Weed")
                .last_name("Roxanne")
                .email("weed.roxanne@gmail.com")
                .CNP("6011217387435")
                .adress("Str. Pinului, nr.98")
                .experience(12)
               // .hire_date(DateFormat.getDateInstance().setCalendar(12-dec-2001))
                .salary(Double.valueOf(10000))
                .phone_number("0786234123")
                .build());

        listPerson.add(ORL_Doctor.builder()
                //.idPerson(UUID.randomUUID())
                        .idPerson("1")
                .name("Cernica")
                .last_name("Sergiu")
                .email("cernica.sergiu@gmail.com")
                .CNP("6011217398764")
                .adress("Str. Lalelelor, nr.14")
                .experience(10)
                //.hire_date(LocalDate.of(2013, 4, 23))
                .salary(Double.valueOf(12000))
                .phone_number("0786290875")
                .build());

        listPerson.add(Ophthalmologist.builder()
                //.idPerson(UUID.randomUUID())
                .idPerson(("2"))
                .name("Zanfir")
                .last_name("Radu")
                .email("zanfir.radu@gmail.com")
                .CNP("6011217309873")
                .adress("Str. Zambilei, nr.6")
                .experience(4)
               // .hire_date(LocalDate.of(2019, 2, 12))
                .salary(Double.valueOf(12000))
                .phone_number("0798634123")
                .build());

        listPerson.add(Cardiologist.builder()
                //.idPerson(UUID.randomUUID())
                .idPerson(("3"))
                .name("Mircescu")
                .last_name("Vlad")
                .email("mircescu.vlad@gmail.com")
                .CNP("6011217987635")
                .adress("Str. Pinului, nr.10")
                .experience(25)
                //.hire_date(LocalDate.now())
                .salary(Double.valueOf(109000))
                .phone_number("0799874123")
                .build());


        Doctor doctor = Doctor.builder()
                //.idPerson(UUID.randomUUID())
                .idPerson(("4"))
                .name("Buzatu")
                .last_name("Maria")
                .email("buzatu.maria@gmail.com")
                .CNP("6011217932115")
                .adress("str. Zambilei")
                .phone_number("0799878954")
                .hire_date("1-12-2001")
                .experience(Integer.valueOf(5))
                .salary(Double.valueOf(4000))

                .appointmentList(List.of(new Appointment(), new Appointment()))
                .build();

        Doctor doctor1 = Doctor.builder()
                //.idPerson(UUID.randomUUID())
                .idPerson(("5"))
                .name("Grigorescu")
                .last_name("Sorana")
                .email("grigorescu.sorana@gmail.com")
                .CNP("6011217875390")
                .adress("str. Vaniliei")
                .phone_number("0790979823")
                .hire_date("12-12-2001")
                .experience(Integer.valueOf(1))
                .salary(Double.valueOf(3000))
                .appointmentList(List.of(new Appointment(), new Appointment()))
                .build();

        Doctor doctor2 = Doctor.builder()
                //.idPerson(UUID.randomUUID())
                .idPerson(("6"))
                .name("Andronache")
                .last_name("Crina")
                .email("mircescu.crina@gmail.com")
                .CNP("6011209000635")
                .adress("str. Pacii")
                .phone_number("0799090043")
                .hire_date("21-01-2001")
                .experience(Integer.valueOf(3))
                .salary(Double.valueOf(29000 ))
                .appointmentList(List.of(new Appointment(), new Appointment()))
                .build();


        Doctor doctor3 = Doctor.builder()
                //.idPerson(UUID.randomUUID())
                .idPerson("7")
                .name("Simulescu")
                .last_name("Matei")
                .email("simulescu.matei@gmail.com")
                .CNP("6011217980094")
                .adress("str. Rozelor")
                .phone_number("0799874123")
                .hire_date("12-12-2001")
                .experience(Integer.valueOf(3))
                .salary(Double.valueOf(21000))
                .appointmentList(List.of(new Appointment(), new Appointment()))
                .build();

        Doctor doctor4 = Doctor.builder()
                .idPerson("23")
                .name("Balan")
                .last_name("Victoria")
                .email("balan.victoria@gmail.com")
                .CNP("6011217097895")
                .adress("Str. Iasomiei")
                .phone_number("0790935123")
                .hire_date("12-12-2001")
                .experience(Integer.valueOf(6))
                .salary(Double.valueOf(17000))
                //.appointmentList(List.of(new Appointment(), new Appointment()))
                .build();



        String Keyboard = keyboard.next();
        if ("0".equals(Keyboard)) {
            doctorService.addOnlyOne(doctor);
//            doctorService.addOnlyOne(doctor1);
//            doctorService.addOnlyOne(doctor2);
//            doctorService.addOnlyOne(doctor3);
//            doctorService.addOnlyOne(doctor4);
        }

        if ("1".equals(Keyboard)) {

            Scanner id_doc1 = new Scanner(System.in);
            System.out.println("Enter the id of doctor:");
            String id_doc = id_doc1.nextLine();

            Scanner name1 = new Scanner(System.in);
            System.out.println("Enter the name of doctor:");
            String nameValue = name1.nextLine();

            Scanner name2 = new Scanner(System.in);
            System.out.println("Enter the lastname of doctor:");
            String nameValue1 = name2.nextLine();

            Scanner email1 = new Scanner(System.in);
            System.out.println("Enter the email of doctor:");
            String email = email1.nextLine();

            Scanner cnp = new Scanner(System.in);
            System.out.println("Enter the CNP of doctor:");
            String cnpValue = cnp.nextLine();

            Scanner experience = new Scanner(System.in);
            System.out.println("Enter the experience of doctor(years):");
            int expValue = experience.nextInt();


            Scanner salary = new Scanner(System.in);
            System.out.println("Enter the salary of doctor:");
            Double salValue = salary.nextDouble();

            Scanner phone = new Scanner(System.in);
            System.out.println("Enter the phone_number of doctor:");
            String phoneValue = phone.nextLine();


            Doctor doctor5 = Doctor.builder()
                    .idPerson(id_doc)
                    .name(nameValue)
                    .last_name(nameValue1)
                    .email(email)
                    .CNP(cnpValue)
                    .adress("Str. Margaretelor")
                    .phone_number(phoneValue)
                    .hire_date("12-12-2001")
                    .experience(expValue)
                    .salary(salValue)

                    //.appointmentList(List.of(new Appointment(), new Appointment()))
                    .build();

            doctorService.addOnlyOne(doctor5);
            System.out.println(doctorService.getByName(nameValue));

        } else if ("2".equals(Keyboard)) {

            System.out.println("The list of doctors: ");

            var it = doctorService.getAllFromList().iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }

//            doctorService.getAllFromList()
//                    .forEach(elementFromList -> System.out.println(elementFromList));

        } else if ("3".equals(Keyboard)) {

            Scanner scan = new Scanner(System.in);
            System.out.print("Doctor ID: ");
            String id = scan.nextLine();
          //  System.out.print("Modify the doctor's salary: ");



            for(Doctor doc:doctorService.getAllFromList()){
                    if (id.equals(doc.getIdPerson())){
                        System.out.print("Modify the doctor's salary: ");
                        double num = scan.nextDouble();
                        doc.setSalary(num);
                        doctorService.modificaElementById(doc.getIdPerson(), doc);
                        System.out.println("After modify: ");
                        doctorService.getAllFromList()
                                .forEach(elementFromList -> System.out.println(elementFromList));
                    }
            }


        } else if ("4".equals(Keyboard)) {

            System.out.println("Remove a doctor: ");
//            String PersonID = keyboard.next();
//            for(Doctor doc:doctorService.getAllFromList()){
//                System.out.println(doc.getIdPerson());
//                if (PersonID == doc.getIdPerson()){
//                    System.out.println("id");
//                    doctorService.removeElementById(PersonID);
//                    doctorService.getAllFromList()
//                            .forEach(elementFromList ->System.out.println(elementFromList.toString()));
//
//                }
//            }

            Scanner scan1 = new Scanner(System.in);
            System.out.print("Doctor ID: ");
            String id1 = scan1.nextLine();
            //  System.out.print("Modify the doctor's salary: ");



            for(Doctor doc:doctorService.getAllFromList()){
                if (id1.equals(doc.getIdPerson())){

                    doctorService.removeElementById(id1);
                    System.out.println("After deleting: ");
                    doctorService.getAllFromList()
                            .forEach(elementFromList -> System.out.println(elementFromList));
                }
            }

        } else if ("5".equals(Keyboard)) {
            List<Doctor> DoctorList = List.of(
                    Doctor.builder()
                            //.idPerson(UUID.randomUUID())
                            .idPerson(("18"))
                            .name("Buzatu")
                            .last_name("Maria")
                            .email("buzatu.maria@gmail.com")
                            .CNP("6011217932115")
                            .experience(Integer.valueOf(5))
                            //.hire_date(LocalDate.of(2018, 1, 12))
                            .salary(Double.valueOf(4000))
                            .phone_number("0799878954")
                            .appointmentList(List.of(new Appointment(), new Appointment()))
                            .build(),

                    Doctor.builder()
                            .idPerson("10")
                            .name("Grigorescu")
                            .last_name("Sorana")
                            .email("grigorescu.sorana@gmail.com")
                            .CNP("6011217875390")
                            .experience(Integer.valueOf(1))
                            //.hire_date(LocalDate.of(2022, 6, 7))
                            .salary(Double.valueOf(3000))
                            .phone_number("0790979823")
                            //.appointmentList(List.of(new Appointment(), new Appointment()))
                            .build(),

                    Doctor.builder()
                            .idPerson("11")
                            .name("Andronache")
                            .last_name("Crina")
                            .email("mircescu.crina@gmail.com")
                            .CNP("6011209000635")
                            .experience(Integer.valueOf(3))
                            //.hire_date(LocalDate.of(2021, 3, 12))
                            .salary(Double.valueOf(29000))
                            .phone_number("0799090043")
                            //.appointmentList(List.of(new Appointment(), new Appointment()))
                            .build(),

                    Doctor.builder()
                            //.idPerson(UUID.randomUUID())
                            .idPerson(("8"))
                            .name("Simulescu")
                            .last_name("Matei")
                            .email("simulescu.matei@gmail.com")
                            .CNP("6011217980094")
                            .experience(Integer.valueOf(3))
                           // .hire_date(LocalDate.of(2021, 3, 12))
                            .salary(Double.valueOf(21000))
                            .phone_number("0799874123")
                            //.appointmentList(List.of(new Appointment(), new Appointment()))
                            .build(),

                    Doctor.builder()
                            //.idPerson(UUID.randomUUID())
                            .idPerson(("7"))
                            .name("Balan")
                            .last_name("Victoria")
                            .email("balan.victoria@gmail.com")
                            .CNP("6011217097895")
                            .experience(Integer.valueOf(6))
                           // .hire_date(LocalDate.of(2020, 1, 12))
                            .salary(Double.valueOf(17000))
                            .phone_number("0790935123")
                            .appointmentList(List.of(new Appointment(), new Appointment()))
                            .build()

            );

            List<Doctor> DoctorList1 = DoctorList.stream()
                    .sorted(Comparator.comparingDouble(Doctor::getSalary))
                    .collect(Collectors.toList());

            DoctorList1.forEach((n) -> System.out.println(n));


        } else if ("6".equals(Keyboard)) {

            List<Medicine> MedicineList = List.of(

                    Medicine.builder()
                            .ID(UUID.randomUUID())
                            .name("Fervex")
                            .MedicineType("Liquid")
                            .price(Double.valueOf(45))
                            .build(),

                    Medicine.builder()
                            .ID(UUID.randomUUID())
                            .name("Forcapil")
                            .MedicineType("Capsules")
                            .price(Double.valueOf(80))
                            .build(),

                    Medicine.builder()
                            .ID(UUID.randomUUID())
                            .name("Nurofen")
                            .MedicineType("Drops")
                            .price(Double.valueOf(25))
                            .build(),

                    Medicine.builder()
                            .ID(UUID.randomUUID())
                            .name("Antinevralgic")
                            .MedicineType("Capsules")
                            .price(Double.valueOf(12))
                            .build(),

                    Medicine.builder()
                            .ID(UUID.randomUUID())
                            .name("Paracetamol")
                            .MedicineType("Drops")
                            .price(Double.valueOf(15))
                            .build()

            );


            List<Medicine> medicinesSort = MedicineList.stream()
                    .sorted(Comparator.comparingDouble(Medicine::getPrice))
                    .collect(Collectors.toList());

            medicinesSort.forEach((n) -> System.out.println(n));


        } else if ("7".equals(Keyboard)) {

            System.out.println("Create an appointment");
            System.out.println("Enter the data of appointment: ");

            Scanner s = new Scanner(System.in);
            String data = s.nextLine();

            System.out.println("Enter the price of appointment: ");
            Scanner price1 = new Scanner(System.in);
            Double price = price1.nextDouble();

            Appointment ap = Appointment.builder()
                    .idAppointment(UUID.randomUUID())
                    .data(data)
                    .price(price)
                    .build();

            appointmentService.addOnlyOne(ap);
            System.out.println("The appointment has been recorded!");


        } else if ("8".equals(Keyboard)) {
            System.out.println("Enter the name of doctor");
            Scanner val = new Scanner(System.in);
            String nameValue = val.nextLine();

            boolean foundDoctor = false;

            for (Doctor doc : doctorService.getAllFromList()) {
                if (nameValue.equals(doc.getName())) {

                    System.out.println("Enter the data of appointment: ");
                    Scanner s = new Scanner(System.in);
                    String data = s.nextLine();
                    doc.removeAppointment(data);
                    foundDoctor = true;
                    break;

                }
            }

            if (!foundDoctor) {
                System.out.println("Not found the doctor!");
            }

        }

        if ("9".equals(Keyboard)) {

            System.out.println("Enter the name of doctor");
            Scanner val = new Scanner(System.in);
            String nameValue = val.nextLine();

            for (int i = 0; i < doctorService.getAllFromList().size(); i++) {

                Doctor doc = new Doctor(doctorService.getAllFromList().get(i));

                if (nameValue.equals(doc.getName())) {
                    System.out.println("Create an appointment\n" +
                            "Enter the data of appointment: ");

                    String data = val.nextLine();

                    System.out.println("Enter the price of appointment: ");
                    Scanner price1 = new Scanner(System.in);
                    Double price = price1.nextDouble();

                    Appointment ap = Appointment.builder()
                            .idAppointment(UUID.randomUUID())
                            .data(data)
                            .price(price)
                            .build();

                   // doctorService.removeElementById(doc.getIdPerson());
                    doc.addAppointment(ap);
                    doctorService.addOnlyOne(doc);
                    System.out.println("The appointment has been recorded!");

                    break;
                }


            }

        } else if ("10".equals(Keyboard)) {

            System.out.println("Enter the data:");
            Scanner val = new Scanner(System.in);
            String nameValue = val.nextLine();

            System.out.println(appointmentService.getByData(nameValue));

        } else if ("11".equals(Keyboard)) {


            System.out.println("Enter the name of doctor");
            Scanner val = new Scanner(System.in);
            String nameValue = val.nextLine();

            for (int i = 0; i < doctorService.getAllFromList().size(); i++) {

                Doctor doc = new Doctor(doctorService.getAllFromList().get(i));

                if (nameValue.equals(doc.getName())) {

                    doc.showAppointment();
                }

            }


        }
        else if("exit".equals(Keyboard)){
            return true;
        }

        return false;
    }
}