package ch.timofey.inventory_tool_sb.domain.authority.dto;

import ch.timofey.inventory_tool_sb.core.generic.AbstractDTO;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class AuthorityDTO extends AbstractDTO {
    @NotNull
    @Size(min = 1, max = 255)
    private String name;

    public AuthorityDTO(UUID id, String name){
        super(id);
        this.name = name;
    }
}
