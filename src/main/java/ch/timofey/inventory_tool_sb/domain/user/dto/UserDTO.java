package ch.timofey.inventory_tool_sb.domain.user.dto;

import ch.timofey.inventory_tool_sb.core.generic.AbstractDTO;
import ch.timofey.inventory_tool_sb.domain.role.dto.RoleDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Length;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class UserDTO extends AbstractDTO {

    @NotBlank
    @Length(min = 1, max = 255)
    private String firstname;

    @NotBlank
    @Length(min = 1, max = 255)
    private String lastname;

    @Email
    @NotBlank
    @Length(min = 1, max = 255)
    private String email;

    @Valid
    private Set<RoleDTO> roles;
}
