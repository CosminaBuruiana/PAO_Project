package models.cure;
import lombok.*;


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

    private String MedicineType;

    public Medicine(String name, Double price, String MedicineType)
    {
        this.name = name;
        this.price = price;
        this.MedicineType = MedicineType;
    }
}