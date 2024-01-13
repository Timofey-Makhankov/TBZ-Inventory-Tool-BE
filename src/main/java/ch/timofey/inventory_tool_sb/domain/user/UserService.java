package ch.timofey.inventory_tool_sb.domain.user;

import ch.timofey.inventory_tool_sb.core.generic.AbstractService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService, AbstractService<User> {
    /**
     * Register a User to the repository
     *
     * @param user User
     * @return the registered User from the repository
     */
    User register(User user);

    /**
     * Register a User to the repository with a random generated password
     *
     * @param user User
     * @return the registered User from the repository
     */
    User registerUser(User user);
}
