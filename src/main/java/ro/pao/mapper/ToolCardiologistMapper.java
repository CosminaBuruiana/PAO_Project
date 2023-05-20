package ro.pao.mapper;


import ro.pao.model.tool.ToolCardiologist;
import ro.pao.model.enums.EnumExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ToolCardiologistMapper {

    private static final ToolCardiologistMapper INSTANCE = new ToolCardiologistMapper();

    private ToolCardiologistMapper() {
    }

    public static ToolCardiologistMapper getInstance() {
        return INSTANCE;
    }


    public Optional<ToolCardiologist> mapToToolCardiologist(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    ToolCardiologist.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<ToolCardiologist> mapToToolCardiologistList(ResultSet resultSet) throws SQLException {
        List<ToolCardiologist> ToolCardiologistList = new ArrayList<>();
        while (resultSet.next()) {
            ToolCardiologistList.add(
                    ToolCardiologist.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .build()
            );
        }

        return ToolCardiologistList;
    }
}
