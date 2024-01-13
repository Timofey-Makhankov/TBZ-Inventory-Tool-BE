package ch.timofey.inventory_tool_sb.domain.user;

import ch.timofey.inventory_tool_sb.core.generic.AbstractServiceImpl;
import ch.timofey.inventory_tool_sb.domain.role.RoleService;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Log4j2
@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder, RoleService roleService){
        super(repository);
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }
    @Override
    @Transactional
    public User register(User user) {
        log.trace("trying to register a new user");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var role = roleService.findByName("USER");
        user.setRoles(new HashSet<>(Collections.singletonList(role)));
        var savedUser = save(user);
        log.debug("registered a new user");
        return savedUser;
    }

    @Override
    @Transactional
    public User registerUser(User user) {
        log.trace("trying to register a new user");
        user.setPassword(getRandomSpecialChars(20).toString());
        var role = roleService.findByName("USER");
        user.setRoles(new HashSet<>(Collections.singletonList(role)));
        var savedUser = save(user);
        log.debug("registered a new user with random character");
        return savedUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.trace("trying to load User by username");
        return ((UserRepository) repository).findByEmail(username)
                .map(UserDetailsImpl::new)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    /**
     * Generates a stream of random characters from a count
     *
     * @param count amount of characters
     * @return a Stream of characters
     */
    public Stream<Character> getRandomSpecialChars(int count) {
        Random random = new SecureRandom();
        IntStream specialChars = random.ints(count, 33, 45);
        return specialChars.mapToObj(data -> (char) data);
    }
}
