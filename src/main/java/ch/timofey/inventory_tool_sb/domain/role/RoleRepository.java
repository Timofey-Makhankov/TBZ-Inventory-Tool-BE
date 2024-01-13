package ch.timofey.inventory_tool_sb.domain.role;

import ch.timofey.inventory_tool_sb.core.generic.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends AbstractRepository<Role> {
    /**
     * Get Role by its name
     * @param name of Role
     * @return Role Entity
     */
    Role findByName(String name);
}
