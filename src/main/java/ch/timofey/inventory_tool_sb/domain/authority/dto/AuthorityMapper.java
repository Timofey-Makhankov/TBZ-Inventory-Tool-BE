package ch.timofey.inventory_tool_sb.domain.authority.dto;

import ch.timofey.inventory_tool_sb.core.generic.AbstractMapper;
import ch.timofey.inventory_tool_sb.domain.authority.Authority;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AuthorityMapper extends AbstractMapper<Authority, AuthorityDTO> {
}
