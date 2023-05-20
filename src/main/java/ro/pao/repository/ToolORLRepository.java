package ro.pao.repository;

import ro.pao.model.tool.ToolORL;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ToolORLRepository {

    Optional<ToolORL> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, ToolORL newObject);

    void addNewObject(ToolORL ToolORL);

    List<ToolORL> getAll();

    void addAllFromGivenList(List<ToolORL> ToolORLList);
}
