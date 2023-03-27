package cure;
import lombok.*;
import cure.enums.MedicineType;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Medicine {
    private UUID ID;

    private String name;

    private Double price;

   // private MedicineType MedicineType;
}