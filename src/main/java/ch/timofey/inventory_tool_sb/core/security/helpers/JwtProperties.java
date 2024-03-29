package ch.timofey.inventory_tool_sb.core.security.helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@NoArgsConstructor
@AllArgsConstructor
@ConfigurationProperties("jwt")
public class JwtProperties {
    private long expirationMillis;
    private String issuer;
    private String secret;
}
