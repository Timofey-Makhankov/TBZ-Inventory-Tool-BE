package ch.timofey.inventory_tool_sb.core.generic.mongodb;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractDocumentDTO {
    private String Id;
}
