package ch.timofey.inventory_tool_sb.core.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class ResponseError implements Serializable {
    private LocalDate timeStamp;
    private Map<String, String> errors;

    public ResponseError build(){
        return this;
    }
}
