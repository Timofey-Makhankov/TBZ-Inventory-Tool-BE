package ch.timofey.inventory_tool_sb.domain.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAll();
    Item findById(String id);
    Item create(Item item);
    Item update(String id, Item item);
    void delete(String id);
}
