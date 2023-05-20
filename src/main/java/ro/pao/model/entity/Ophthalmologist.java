package ro.pao.model.entity;
import ro.pao.model.cure.Medicine;
import java.util.List;
import lombok.experimental.SuperBuilder;
import lombok.*;
import ro.pao.model.tool.ToolOphthalmologist;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder


public class Ophthalmologist extends Doctor{
    private ToolOphthalmologist tool;

    @Override
    public String toString() {
        return "Ophthalmologist " + getLast_name() + " " + getName() + ": " + " email: " + getEmail()
                + ", CNP: " + getCNP() + ", phone_number: " + getPhone_number() + ", adress: " + getAdress()
                + ", hire_date: " + getHire_date() + ", experience: " + getExperience()
                + ", salary" + getSalary() + ", Appointments: " + getAppointmentList()
                + "Tool Ophthalmologist: " + tool;
    }
}
