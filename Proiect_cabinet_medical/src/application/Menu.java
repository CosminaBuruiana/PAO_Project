package application;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import cure.Cure;
import cure.Medicine;
import cure.enums.MedicineType;
import entity.Patient;
import entity.Doctor;
import administration.Appointment;
import service.CureService;
import service.PatientService;
import service.DoctorService;
import service.AppointmentService;
import service.impl.CureServiceImpl;
import service.impl.AppointmentServiceImpl;
import service.impl.DoctorServiceImpl;
import service.impl.PatientServiceImpl;



public class Menu {

    private static Menu INSTANCE;

    //private final ExampleService exampleService = new ExampleServiceImpl();

    public static Menu getInstance() {
        return (INSTANCE == null ? new Menu() : INSTANCE);
    }

    public void intro() {
        String intro = """
                Intro example:
                """;

        System.out.println(intro);
//
//        Medicine medicine = Medicine.builder()
//                .ID(UUID.randomUUID())
//                .MedicineType(MedicineType.NONE)
//                .price(Double.valueOf(123))
//                .build();

//        Cure cure = Cure.builder()
//                .IdCure(UUID.randomUUID())
//                .start_date(LocalDate.now())
//                .end_date(LocalDate.of(2024,6,12))// data de azi
//                .build();
    }
}
