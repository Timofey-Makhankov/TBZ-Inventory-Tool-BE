package ch.timofey.inventory_tool_sb.domain.Item;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    @Query("{name: '?0'}")
    Item findItemByName(String name);

    @Query(value = "{category: '?0'}", fields = "{'name': 1, 'quantity': 1}")
    List<Item> findAllByCategory(String category);

}
