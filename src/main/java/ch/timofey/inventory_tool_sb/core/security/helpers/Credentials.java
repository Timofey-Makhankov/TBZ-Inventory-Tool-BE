package ch.timofey.inventory_tool_sb.core.security.helpers;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Credentials {
    private String email;
    private String password;
}
