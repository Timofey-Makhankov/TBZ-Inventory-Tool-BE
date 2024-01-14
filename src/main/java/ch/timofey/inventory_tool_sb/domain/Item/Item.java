package ch.timofey.inventory_tool_sb.domain.Item;

import ch.timofey.inventory_tool_sb.core.generic.mongodb.AbstractDocumentEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Document("items")
public class Item extends AbstractDocumentEntity {
    private String name;
    private int quantity;
    private String category;

    @Override
    public String toString(){
        return String.format("{id: %s, name: %s, quantity: %d, category: %s}", getId(), name, quantity, category);
    }
}
