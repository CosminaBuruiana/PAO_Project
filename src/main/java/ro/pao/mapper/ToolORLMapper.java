package ro.pao.mapper;


import ro.pao.model.tool.ToolORL;
import ro.pao.model.enums.EnumExample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ToolORLMapper {

    private static final ToolORLMapper INSTANCE = new ToolORLMapper();

    private ToolORLMapper() {
    }

    public static ToolORLMapper getInstance() {
        return INSTANCE;
    }


    public Optional<ToolORL> mapToToolORL(ResultSet resultSet) throws SQLException {
        if (resultSet.next()) {
            return Optional.of(
                    ToolORL.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .build()
            );
        } else {
            return Optional.empty();
        }
    }

    public List<ToolORL> mapToToolORLList(ResultSet resultSet) throws SQLException {
        List<ToolORL> ToolORLList = new ArrayList<>();
        while (resultSet.next()) {
            ToolORLList.add(
                    ToolORL.builder()
                            .id(UUID.fromString(resultSet.getString(1)))
                            .name(resultSet.getString(2))
                            .build()
            );
        }

        return ToolORLList;
    }
}
