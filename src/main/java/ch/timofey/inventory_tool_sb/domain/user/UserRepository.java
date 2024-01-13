package ch.timofey.inventory_tool_sb.domain.user;

import ch.timofey.inventory_tool_sb.core.generic.AbstractRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractRepository<User> {
    Optional<User> findByEmail(String email);
}
