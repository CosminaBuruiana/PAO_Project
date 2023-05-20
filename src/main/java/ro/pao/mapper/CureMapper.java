package ro.pao.mapper;


import ro.pao.model.cure.Cure;
import ro.pao.model.cure.Medicine;
import ro.pao.model.enums.EnumExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class CureMapper {

    private static final CureMapper INSTANCE = new CureMapper();

    private CureMapper() {
    }

    public static CureMapper getInstance() {
        return INSTANCE;
    }


    public Optional<Cure> mapToCure(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    Cure.builder()
                            .idCure(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .start_date(resultSet.getDate(3))
                            .end_date(resultSet.getDate(4))
                            .medicineList((List<Medicine>) resultSet.getArray(5))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<Cure> mapToCureList(ResultSet resultSet) throws SQLException {
        List<Cure> CureList = new ArrayList<>();
        while (resultSet.next()) {
            CureList.add(
                    Cure.builder()
                            .idCure(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .start_date(resultSet.getDate(3))
                            .end_date(resultSet.getDate(4))
                            .medicineList((List<Medicine>) resultSet.getArray(5))
                            .build()
            );
        }

        return CureList;
    }
}
