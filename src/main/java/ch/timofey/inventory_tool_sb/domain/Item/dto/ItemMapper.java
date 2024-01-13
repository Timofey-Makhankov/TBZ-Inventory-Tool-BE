package ch.timofey.inventory_tool_sb.domain.Item.dto;

import ch.timofey.inventory_tool_sb.core.generic.mongodb.AbstractDocumentMapper;
import ch.timofey.inventory_tool_sb.domain.Item.Item;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ItemMapper extends AbstractDocumentMapper<Item, ItemDTO> {
}
