package ch.timofey.inventory_tool_sb.domain.user.dto;

import ch.timofey.inventory_tool_sb.core.generic.AbstractMapper;
import ch.timofey.inventory_tool_sb.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends AbstractMapper<User, UserDTO> {
    User fromUserRegisterDTO(UserRegisterDTO dto);
}
