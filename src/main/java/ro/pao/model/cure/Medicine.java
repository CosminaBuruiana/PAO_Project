package ro.pao.model.cure;
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

    @Override
    public String toString() {
        return "Medicine: " + name + ", price: " + price + ": " + ", MedicineType: " + MedicineType;

    }


}