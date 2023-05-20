package ro.pao.mapper;


import ro.pao.model.tool.ToolOphthalmologist;
import ro.pao.model.enums.EnumExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ToolOphthalmologistMapper {

    private static final ToolOphthalmologistMapper INSTANCE = new ToolOphthalmologistMapper();

    private ToolOphthalmologistMapper() {
    }

    public static ToolOphthalmologistMapper getInstance() {
        return INSTANCE;
    }


    public Optional<ToolOphthalmologist> mapToToolOphthalmologist(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    ToolOphthalmologist.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<ToolOphthalmologist> mapToToolOphthalmologistList(ResultSet resultSet) throws SQLException {
        List<ToolOphthalmologist> ToolOphthalmologistList = new ArrayList<>();
        while (resultSet.next()) {
            ToolOphthalmologistList.add(
                    ToolOphthalmologist.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .build()
            );
        }

        return ToolOphthalmologistList;
    }
}
