package models.cure;
import lombok.*;
import models.cure.enums.MedicineType;

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

    private MedicineType MedicineType;

    public Medicine(String name, Double price, MedicineType MedicineType)
    {
        this.name = name;
        this.price = price;
        this.MedicineType = MedicineType;
    }
}