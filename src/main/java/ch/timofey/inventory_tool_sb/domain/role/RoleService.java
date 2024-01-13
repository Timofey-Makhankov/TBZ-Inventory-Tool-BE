package ch.timofey.inventory_tool_sb.domain.role;

import ch.timofey.inventory_tool_sb.core.generic.AbstractRepository;
import ch.timofey.inventory_tool_sb.core.generic.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractServiceImpl<Role> {
    public RoleService(AbstractRepository<Role> repository){
        super(repository);
    }

    /**
     * {@inheritDoc}
     */
    public Role findByName(String name) {
        return ((RoleRepository) repository).findByName(name);
    }
}
