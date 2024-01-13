package ch.timofey.inventory_tool_sb.core.security.permissions_evaluators;

import ch.timofey.inventory_tool_sb.domain.user.User;
import ch.timofey.inventory_tool_sb.domain.user.dto.UserDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@NoArgsConstructor
public class UserPermissionEvaluator {
    /**
     * Check, if the requested user is the Same user as the user given
     *
     * @param principal get the principal from the request
     * @param userDTO   get the user from the request
     * @return true, if the user given is the same as requested, otherwise return false
     * @since 1.0
     */
    public boolean isSameUser(User principal, UserDTO userDTO) {
        return principal.getEmail().equals(userDTO.getEmail());
    }

    /**
     * Check, if the requested user is the Same user as the user given
     *
     * @param principal get the principal from the request
     * @param id        The User id from the request
     * @return true, if the user given is the same as requested, otherwise return false
     * @since 1.0
     */
    public boolean isSameUser(User principal, UUID id) {
        return principal.getId().equals(id);
    }
}
