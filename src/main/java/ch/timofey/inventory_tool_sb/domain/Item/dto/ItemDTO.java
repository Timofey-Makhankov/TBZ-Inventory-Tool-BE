package ch.timofey.inventory_tool_sb.domain.Item.dto;

import ch.timofey.inventory_tool_sb.core.generic.mongodb.AbstractDocumentDTO;

public class ItemDTO extends AbstractDocumentDTO {
    private String name;
    private int quantity;
    private String category;
}
