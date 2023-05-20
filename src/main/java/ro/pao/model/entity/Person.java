package ro.pao.model.entity;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@ToString
@EqualsAndHashCode
public abstract class Person {

    protected UUID idPerson;

    protected String name;
    protected String last_name;
    protected String email;
    protected String CNP;
    protected String phone_number;
    protected String adress;

    @Override
    public String toString() {
        return "Person " + name + " " + last_name + ": " + " email: " + email
                + ", CNP: " + CNP + ", phone_number: " + phone_number + ", adress: ";
    }

}
