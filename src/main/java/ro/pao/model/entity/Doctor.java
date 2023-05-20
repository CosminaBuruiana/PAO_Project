package ro.pao.model.entity;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import lombok.experimental.SuperBuilder;
import ro.pao.model.administration.Appointment;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder

public class Doctor extends Person {

    private LocalDate hire_date;
    private Integer experience;
    private Double salary;
    private List<Appointment> appointmentList = new ArrayList<>();

    public void addAppointment(Appointment ap) {
        appointmentList.add(ap);
    }

    public Doctor(Doctor doctor){

        this.idPerson= doctor.idPerson;
        this.name = doctor.name;
        this.last_name = doctor.last_name;
        this.experience = doctor.experience;
        this.hire_date = doctor.hire_date;
        this.salary = doctor.salary;
        this.email = doctor.email;
        this.CNP = doctor.CNP;
        this.phone_number = doctor.phone_number;
        this.appointmentList = new ArrayList<>(doctor.appointmentList);
    }

    public void showAppointment(){
        for(int i = 0; i < appointmentList.size(); i++){

            System.out.println(appointmentList.get(i).getPrice());
        }
    }

    public void removeAppointment(String data) {
        appointmentList = appointmentList.stream()
                .filter(element -> !data.equals(element.getData()))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Doctor " + getIdPerson()+": "+ getLast_name() + " " + getName() + ": " + " email: " + getEmail()
                + ", CNP: " + getCNP() + ", phone_number: " + getPhone_number() + ", adress: "+getAdress()
                + ", hire_date: " + hire_date + ", experience: " + experience
                + ", salary" + salary + ", Appointments: " + appointmentList;
    }


}
