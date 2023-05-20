package ro.pao.mapper;


import ro.pao.model.cure.Medicine;
import ro.pao.model.enums.EnumExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class MedicineMapper {

    private static final MedicineMapper INSTANCE = new MedicineMapper();

    private MedicineMapper() {
    }

    public static MedicineMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Medicine> mapToMedicine(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Medicine.builder()
                            .ID(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .price(resultSet.getDouble(3))
                            //enums
                            .MedicineType(resultSet.getString(4))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Medicine> mapToMedicineList(ResultSet resultSet) throws SQLException {
        List<Medicine> MedicineList = new ArrayList<>();
        while (resultSet.next()) {
            MedicineList.add(
                    Medicine.builder()
                            .ID(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .price(resultSet.getDouble(3))
                            //enums
                            .MedicineType(resultSet.getString(4))
                            .build()
            );
        }

        return MedicineList;
    }
}
