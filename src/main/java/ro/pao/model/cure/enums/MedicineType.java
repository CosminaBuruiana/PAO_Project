package models.cure.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum MedicineType {
    DROPS("Drops"),
    TABLET("Tablets"),

    CAPSULES("Capsules"),
    INHALERS("Inhalers"),

    LIQUID("Liquid"),
    INJECTIONS("Injections"),
    NONE("none");

    private final String typeString;

    public static MedicineType getEnumByFieldString(String field) {
        return Arrays.stream(MedicineType.values())
                .filter(enumElement -> enumElement.typeString.equals(field))
                .findAny()
                .orElse(NONE);
    }
}