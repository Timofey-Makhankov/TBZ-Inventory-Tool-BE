package ch.timofey.inventory_tool_sb.core.generic.mongodb;

import ch.timofey.inventory_tool_sb.core.generic.mongodb.AbstractDocumentDTO;
import ch.timofey.inventory_tool_sb.core.generic.mongodb.AbstractDocumentEntity;

import java.util.List;
import java.util.Set;

public interface AbstractDocumentMapper<BO extends AbstractDocumentEntity, DTO extends AbstractDocumentDTO> {
    BO fromDTO(DTO dto);
    List<BO> fromDTOs(List<DTO> dtos);
    Set<BO> fromDTOs(Set<DTO> dtos);
    DTO toDTO(BO BO);
    List<DTO> toDTOs(List<BO> BOs);
    Set<DTO> toDTOs(Set<BO> BOs);
}
