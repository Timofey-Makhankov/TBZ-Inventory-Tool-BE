package ch.timofey.inventory_tool_sb.core.generic.mongodb;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
//@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractDocumentEntity {
    @Id
    private String id;
}
