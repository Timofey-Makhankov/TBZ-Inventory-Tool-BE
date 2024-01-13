package ch.timofey.inventory_tool_sb.domain.user;

import ch.timofey.inventory_tool_sb.domain.user.dto.UserDTO;
import ch.timofey.inventory_tool_sb.domain.user.dto.UserMapper;
import ch.timofey.inventory_tool_sb.domain.user.dto.UserRegisterDTO;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService, UserMapper userMapper){
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER_READ') or @userPermissionEvaluator.isSameUser(authentication.principal.user, #id)")
    public ResponseEntity<UserDTO> retrieveById(@Valid @PathVariable UUID id) {
        User user = userService.findById(id);
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
    }

    @GetMapping({"", "/"})
    @PreAuthorize("hasAuthority('USER_READ_ALL')")
    public ResponseEntity<List<UserDTO>> retrieveAll(){
        List<User> users = userService.findAll();
        return new ResponseEntity<>(userMapper.toDTOs(users), HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserRegisterDTO userRegisterDTO){
        User user = userService.register(userMapper.fromUserRegisterDTO(userRegisterDTO));
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.CREATED);
    }

    @PostMapping("/registerUser")
    public ResponseEntity<UserDTO> registerWithoutPassword(@Valid @RequestBody UserDTO userDTO) {
        User user = userService.registerUser(userMapper.fromDTO(userDTO));
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('USER_MODIFY') or @userPermissionEvaluator.isSameUser(authentication.principal.user, #userDTO)")
    public ResponseEntity<UserDTO> updateById(@PathVariable UUID id, @Valid @RequestBody UserDTO userDTO){
        User user = userService.updateById(id, userMapper.fromDTO(userDTO));
        return new ResponseEntity<>(userMapper.toDTO(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('USER_DELETE') or @userPermissionEvaluator.isSameUser(authentication.principal.user, #id)")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
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

    /**
     * This Exception handler will run, when the ConstraintViolationException Exception is thrown
     *
     * @param e Exception
     * @return an Error Response Entity with message
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage().replace("getMembersFromGroupId.", ""));
    }
}
