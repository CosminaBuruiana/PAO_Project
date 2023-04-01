package application;
import models.administration.Appointment;
import models.entity.*;
import models.cure.Medicine;
import models.cure.enums.MedicineType;
import service.AppointmentService;
import service.DoctorService;
import service.MedicineService;
import service.impl.AppointmentServiceImpl;
import service.impl.DoctorServiceImpl;
import service.impl.MedicineServiceImpl;

import javax.xml.crypto.Data;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


public class Menu {

    private DoctorService DoctorService = new DoctorServiceImpl();

    private final MedicineService MedicineService = new MedicineServiceImpl();

    private final AppointmentService AppointmentService = new AppointmentServiceImpl();



    private static Menu INSTANCE;

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }


    public void intro() throws ParseException {


        System.out.println("Choose an option: ");
        System.out.println("1. Add a doctor");
        System.out.println("2. List of doctors");
        System.out.println("3. Modify the doctor experience");
        System.out.println("4. Delete doctor");
        System.out.println("5. Sort the doctors by salary");
        System.out.println("6. Sort the medicines by price");
        System.out.println("7. Create an appointment");
        System.out.println("8. Remove an appointment for a doctor");
        System.out.println("9. Add an appointment for a doctor");
        System.out.println("10. Appointments list by a date");


        Scanner keyboard = new Scanner(System.in);

        List<Person> listPerson = new ArrayList<>();

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


        Doctor doctor = Doctor.builder()
                .idPerson(UUID.randomUUID())
                .name("Buzatu")
                .last_name("Maria")
                .email("buzatu.maria@gmail.com")
                .CNP("6011217932115")
                .experience(Integer.valueOf(5))
                .hire_date(LocalDate.of(2018,1,12))
                .salary(Double.valueOf(4000))
                .phone_number("0799878954")
                .appointmentList(List.of(new Appointment(), new Appointment()))
                .build();

        Doctor doctor1 = Doctor.builder()
                .name("Grigorescu")
                .last_name("Sorana")
                .email("grigorescu.sorana@gmail.com")
                .CNP("6011217875390")
                .experience(Integer.valueOf(1))
                .hire_date(LocalDate.of(2022,6,7))
                .salary(Double.valueOf(3000))
                .phone_number("0790979823")
                .appointmentList(List.of(new Appointment(), new Appointment()))
                .build();

        Doctor doctor2 = Doctor.builder()
                .name("Andronache")
                .last_name("Crina")
                .email("mircescu.crina@gmail.com")
                .CNP("6011209000635")
                .experience(Integer.valueOf(3))
                .hire_date(LocalDate.of(2021,3,12))
                .salary(Double.valueOf(29000))
                .phone_number("0799090043")
                .appointmentList(List.of(new Appointment(), new Appointment()))
                .build();


        Doctor doctor3 = Doctor.builder()
                .idPerson(UUID.randomUUID())
                .name("Simulescu")
                .last_name("Matei")
                .email("simulescu.matei@gmail.com")
                .CNP("6011217980094")
                .experience(Integer.valueOf(3))
                .hire_date(LocalDate.of(2021,3,12))
                .salary(Double.valueOf(21000))
                .phone_number("0799874123")
                .appointmentList(List.of(new Appointment(), new Appointment()))
                .build();

        Doctor doctor4 = Doctor.builder()
                .idPerson(UUID.randomUUID())
                .name("Balan")
                .last_name("Victoria")
                .email("balan.victoria@gmail.com")
                .CNP("6011217097895")
                .experience(Integer.valueOf(6))
                .hire_date(LocalDate.of(2020,1,12))
                .salary(Double.valueOf(17000))
                .phone_number("0790935123")
                .appointmentList(List.of(new Appointment(), new Appointment()))
                .build();


        DoctorService.addOnlyOne(doctor);
        DoctorService.addOnlyOne(doctor1);
        DoctorService.addOnlyOne(doctor2);
        DoctorService.addOnlyOne(doctor3);
        DoctorService.addOnlyOne(doctor4);



        String Keyboard = keyboard.next();

        if ("1".equals(Keyboard)) {

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
                    .idPerson(UUID.randomUUID())
                    .name(nameValue)
                    .last_name(nameValue1)
                    .email(email)
                    .CNP(cnpValue)
                    .experience(expValue)
                    .hire_date(LocalDate.now())
                    .salary(salValue)
                    .phone_number(phoneValue)
                    //.appointmentList(List.of(new Appointment(), new Appointment()))
                    .build();

            DoctorService.addOnlyOne(doctor5);
            System.out.println(DoctorService.getByName(nameValue));

        }
        else
        if("2".equals(Keyboard)){

            System.out.println("The list of doctors: ");
            DoctorService.getAllFromList()
                    .forEach(elementFromList -> System.out.println(elementFromList));

        }
        else
        if("3".equals(Keyboard)){

            Scanner scan = new Scanner(System.in);
            System.out.print("Modify the doctor's experience: ");
            int num = scan.nextInt();

            System.out.println("After modify: ");
            doctor.setExperience(num);
            DoctorService.modificaElementById(doctor.getIdPerson(), doctor);
            DoctorService.getAllFromList()
                    .forEach(elementFromList -> elementFromList.toString());

        }
        else
        if("4".equals(Keyboard)){

            System.out.println("Remove a doctor: ");
            DoctorService.removeElementById(doctor.getIdPerson());
            DoctorService.getAllFromList()
                    .forEach(elementFromList -> elementFromList.toString());
        }
        else
        if("5".equals(Keyboard)) {
            List<Doctor> DoctorList = List.of(
                    Doctor.builder()
                            .idPerson(UUID.randomUUID())
                            .name("Buzatu")
                            .last_name("Maria")
                            .email("buzatu.maria@gmail.com")
                            .CNP("6011217932115")
                            .experience(Integer.valueOf(5))
                            .hire_date(LocalDate.of(2018, 1, 12))
                            .salary(Double.valueOf(4000))
                            .phone_number("0799878954")
                            .appointmentList(List.of(new Appointment(), new Appointment()))
                            .build(),

                    Doctor.builder()
                            .name("Grigorescu")
                            .last_name("Sorana")
                            .email("grigorescu.sorana@gmail.com")
                            .CNP("6011217875390")
                            .experience(Integer.valueOf(1))
                            .hire_date(LocalDate.of(2022, 6, 7))
                            .salary(Double.valueOf(3000))
                            .phone_number("0790979823")
                            //.appointmentList(List.of(new Appointment(), new Appointment()))
                            .build(),

                    Doctor.builder()
                            .name("Andronache")
                            .last_name("Crina")
                            .email("mircescu.crina@gmail.com")
                            .CNP("6011209000635")
                            .experience(Integer.valueOf(3))
                            .hire_date(LocalDate.of(2021, 3, 12))
                            .salary(Double.valueOf(29000))
                            .phone_number("0799090043")
                            //.appointmentList(List.of(new Appointment(), new Appointment()))
                            .build(),

                    Doctor.builder()
                            .idPerson(UUID.randomUUID())
                            .name("Simulescu")
                            .last_name("Matei")
                            .email("simulescu.matei@gmail.com")
                            .CNP("6011217980094")
                            .experience(Integer.valueOf(3))
                            .hire_date(LocalDate.of(2021, 3, 12))
                            .salary(Double.valueOf(21000))
                            .phone_number("0799874123")
                            //.appointmentList(List.of(new Appointment(), new Appointment()))
                            .build(),

                    Doctor.builder()
                            .idPerson(UUID.randomUUID())
                            .name("Balan")
                            .last_name("Victoria")
                            .email("balan.victoria@gmail.com")
                            .CNP("6011217097895")
                            .experience(Integer.valueOf(6))
                            .hire_date(LocalDate.of(2020, 1, 12))
                            .salary(Double.valueOf(17000))
                            .phone_number("0790935123")
                            .appointmentList(List.of(new Appointment(), new Appointment()))
                            .build()

            );

            List<Doctor> DoctorList1 = DoctorList.stream()
                    .sorted(Comparator.comparingDouble(Doctor::getSalary))
                    .collect(Collectors.toList());

            DoctorList1.forEach((n) -> System.out.println(n));


        }
        else
        if("6".equals(Keyboard)){

            List<Medicine> MedicineList = List.of(

            Medicine.builder()
                            .ID(UUID.randomUUID())
                            .name("Fervex")
                            .MedicineType(MedicineType.LIQUID.getTypeString())
                            .price(Double.valueOf(45))
                            .build(),

           Medicine.builder()
                    .ID(UUID.randomUUID())
                    .name("Forcapil")
                    .MedicineType(MedicineType.CAPSULES.getTypeString())
                    .price(Double.valueOf(80))
                    .build(),

           Medicine.builder()
                    .ID(UUID.randomUUID())
                    .name("Nurofen")
                    .MedicineType(MedicineType.DROPS.getTypeString())
                    .price(Double.valueOf(25))
                    .build(),

           Medicine.builder()
                    .ID(UUID.randomUUID())
                    .name("Antinevralgic")
                    .MedicineType(MedicineType.CAPSULES.getTypeString())
                    .price(Double.valueOf(12))
                    .build(),

            Medicine.builder()
                    .ID(UUID.randomUUID())
                    .name("Paracetamol")
                    .MedicineType(MedicineType.DROPS.getTypeString())
                    .price(Double.valueOf(15))
                    .build()

            );


            List<Medicine> medicinesSort = MedicineList.stream()
                    .sorted(Comparator.comparingDouble(Medicine::getPrice))
                    .collect(Collectors.toList());

            medicinesSort.forEach((n) -> System.out.println(n));


        }
        else
        if("7".equals(Keyboard)){

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

            AppointmentService.addOnlyOne(ap);
            System.out.println("The appointment has been recorded!");


        }
        else
        if("8".equals(Keyboard)){
            System.out.println("Enter the name of doctor");
            Scanner val = new Scanner(System.in);
            String nameValue = val.nextLine();

            boolean foundDoctor = false;

            for(Doctor doc: DoctorService.getAllFromList()){
                if(nameValue.equals(doc.getName())){

                    System.out.println("Enter the data of appointment: ");
                    Scanner s = new Scanner(System.in);
                    String data = s.nextLine();
                    doc.removeAppointment(data);

                    foundDoctor = true;
                }
            }

            if (!foundDoctor) {
                System.out.println("Not found the doctor!");
            }

        }

        if("9".equals(Keyboard)){

            System.out.println("Enter the name of doctor");
            Scanner val = new Scanner(System.in);
            String nameValue = val.nextLine();

            for (int i = 0; i < DoctorService.getAllFromList().size(); i++) {

                Doctor doc = new Doctor(DoctorService.getAllFromList().get(i));

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

                    DoctorService.removeElementById(doc.getIdPerson());
                    doc.addAppointment(ap);
                    DoctorService.addOnlyOne(doc);
                    System.out.println("The appointment has been recorded!");

                    break;
                }


            }

        }
        else
        if("10".equals(Keyboard)){

            System.out.println("Enter the data:");
            Scanner val = new Scanner(System.in);
            String nameValue = val.nextLine();

            System.out.println(AppointmentService.getByData(nameValue));

        }


    }
}
