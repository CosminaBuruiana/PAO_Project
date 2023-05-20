package ro.pao.model.entity;
import lombok.experimental.SuperBuilder;
import ro.pao.model.cure.Medicine;
import java.util.List;
import lombok.*;
import ro.pao.model.tool.ToolCardiologist;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder


public class Cardiologist extends Doctor {

   private ToolCardiologist tool;

   @Override
   public String toString() {
      return "Cardiologist " + getLast_name() + " " + getName() + ": " + " email: " + getEmail()
              + ", CNP: " + getCNP() + ", phone_number: " + getPhone_number() + ", adress: " + getAdress()
              + ", hire_date: " + getHire_date() + ", experience: " + getExperience()
              + ", salary" + getSalary() + ", Appointments: " + getAppointmentList()
              + "Tool Cardiologist: " + tool;
   }

}

