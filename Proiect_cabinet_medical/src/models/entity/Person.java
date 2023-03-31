package models.entity;
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

    private UUID idPerson;
    private String name;
    private String last_name;
    private String email;

    private String CNP;

    private String phone_number;

    private String adress;

    public Person(String name, String last_name, String CNP,String phone_number, String adress, String email) {
        this.name = name;
        this.last_name = last_name;
        this.CNP = CNP;
        this.adress = adress;
        this.email = email;
        this.phone_number = phone_number;
    }

}
