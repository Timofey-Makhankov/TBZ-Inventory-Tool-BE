package ch.timofey.inventory_tool_sb.domain.Item.dto;

import ch.timofey.inventory_tool_sb.core.generic.mongodb.AbstractDocumentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ItemDTO extends AbstractDocumentDTO {
    private String name;
    private int quantity;
    private String category;
}
