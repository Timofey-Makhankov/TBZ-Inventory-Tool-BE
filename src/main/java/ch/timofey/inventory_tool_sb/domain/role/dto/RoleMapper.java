package ch.timofey.inventory_tool_sb.domain.role.dto;

import ch.timofey.inventory_tool_sb.core.generic.AbstractMapper;
import ch.timofey.inventory_tool_sb.domain.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends AbstractMapper<Role, RoleDTO> {
}
