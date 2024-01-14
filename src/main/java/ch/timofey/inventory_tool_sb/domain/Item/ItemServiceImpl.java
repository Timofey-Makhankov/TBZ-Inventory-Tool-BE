package ch.timofey.inventory_tool_sb.domain.Item;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Log4j2
@Service
public class ItemServiceImpl implements ItemService{

    private final ItemRepository repository;

    @Autowired
    public ItemServiceImpl(ItemRepository repository){
        this.repository = repository;
    }

    @Override
    public List<Item> getAll() {
        log.trace("trying to get all items");
        List<Item> items = repository.findAll();
        log.debug("items where found");
        return items;
    }

    @Override
    public Item findById(String id) throws NoSuchElementException {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Item create(Item item) {
        return repository.save(item);
    }

    @Override
    public Item update(String id, Item item) {
        item.setId(id);
        return repository.save(item);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
