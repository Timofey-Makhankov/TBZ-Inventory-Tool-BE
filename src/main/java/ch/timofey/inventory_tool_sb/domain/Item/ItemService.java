package ch.timofey.inventory_tool_sb.domain.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAll();
    Item findById(String id);
}
