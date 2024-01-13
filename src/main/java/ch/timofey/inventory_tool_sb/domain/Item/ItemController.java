package ch.timofey.inventory_tool_sb.domain.Item;

import ch.timofey.inventory_tool_sb.domain.Item.dto.ItemDTO;
import ch.timofey.inventory_tool_sb.domain.Item.dto.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @Autowired
    public ItemController(ItemService itemService, ItemMapper itemMapper){
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<ItemDTO>> retrieveAll(){
        List<Item> items = itemService.getAll();
        return new ResponseEntity<>(itemMapper.toDTOs(items), HttpStatus.OK);
    }
}
