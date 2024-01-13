package ch.timofey.inventory_tool_sb.domain.role;

import ch.timofey.inventory_tool_sb.core.generic.AbstractEntity;
import ch.timofey.inventory_tool_sb.domain.authority.Authority;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "role")
@Accessors(chain = true)
public class Role extends AbstractEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_authority",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id")
    )
    private Set<Authority> authorities = new HashSet<>();

    public Role(UUID id, String name, Set<Authority> authorities){
        super(id);
        this.name = name;
        this.authorities = authorities;
    }
}
