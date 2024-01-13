package ch.timofey.inventory_tool_sb.domain.role.dto;

import ch.timofey.inventory_tool_sb.core.generic.AbstractDTO;
import ch.timofey.inventory_tool_sb.domain.authority.dto.AuthorityDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
public class RoleDTO extends AbstractDTO {
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    @Valid
    private Set<AuthorityDTO> authorities;

    public RoleDTO(UUID id, String name, Set<AuthorityDTO> authorities) {
        super(id);
        this.name = name;
        this.authorities = authorities;
    }
}
