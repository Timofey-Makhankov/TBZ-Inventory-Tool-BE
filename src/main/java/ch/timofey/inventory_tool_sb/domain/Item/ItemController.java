package ch.timofey.inventory_tool_sb.domain.Item;

import ch.timofey.inventory_tool_sb.domain.Item.dto.ItemDTO;
import ch.timofey.inventory_tool_sb.domain.Item.dto.ItemMapper;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Log4j2
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
    @PreAuthorize("hasAuthority('ITEM_READ_ALL')")
    public ResponseEntity<List<ItemDTO>> retrieveAll(){
        List<Item> items = itemService.getAll();
        System.out.printf("Items: %s", items);
        return new ResponseEntity<>(itemMapper.toDTOs(items), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ITEM_READ')")
    public ResponseEntity<ItemDTO> retrieveById(@Valid @PathVariable String id){
        Item item = itemService.findById(id);
        return new ResponseEntity<>(itemMapper.toDTO(item), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    @PreAuthorize("hasAuthority('ITEM_CREATE')")
    public ResponseEntity<ItemDTO> create(@Valid @RequestBody ItemDTO itemDTO){
        Item item = itemService.create(itemMapper.fromDTO(itemDTO));
        return new ResponseEntity<>(itemMapper.toDTO(item), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ITEM_UPDATE')")
    public ResponseEntity<ItemDTO> updateById(@Valid @PathVariable String id, @Valid @RequestBody ItemDTO itemDTO){
        Item item = itemService.update(id, itemMapper.fromDTO(itemDTO));
        return new ResponseEntity<>(itemMapper.toDTO(item), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ITEM_DELETE')")
    public ResponseEntity<Void> deleteById(@Valid @PathVariable String id){
        itemService.delete(id);
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    /**
     * This Exception handler will run, when the MethodArgumentNotValid Exception is thrown
     *
     * @param e Exception
     * @return an Error Response Entity with message
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Objects.requireNonNull(e.getFieldError()).getDefaultMessage());
    }
}
