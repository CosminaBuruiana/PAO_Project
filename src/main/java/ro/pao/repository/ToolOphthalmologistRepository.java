package ro.pao.repository;

import ro.pao.model.tool.ToolOphthalmologist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ToolOphthalmologistRepository {

    Optional<ToolOphthalmologist> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, ToolOphthalmologist newObject);

    void addNewObject(ToolOphthalmologist ToolOphthalmologist);

    List<ToolOphthalmologist> getAll();

    void addAllFromGivenList(List<ToolOphthalmologist> ToolOphthalmologistList);
}
