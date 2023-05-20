package ro.pao.repository;

import ro.pao.model.tool.ToolCardiologist;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ToolCardiologistRepository {

    Optional<ToolCardiologist> getObjectById(UUID id);

    void deleteObjectById(UUID id);

    void updateObjectById(UUID id, ToolCardiologist newObject);

    void addNewObject(ToolCardiologist ToolCardiologist);

    List<ToolCardiologist> getAll();

    void addAllFromGivenList(List<ToolCardiologist> ToolCardiologistList);
}
