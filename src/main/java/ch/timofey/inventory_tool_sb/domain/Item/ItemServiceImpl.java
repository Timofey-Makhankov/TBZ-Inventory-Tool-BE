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
        return repository.findAll();
    }

    @Override
    public Item findById(String id) throws NoSuchElementException {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }
}
