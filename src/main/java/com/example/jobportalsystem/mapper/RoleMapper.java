package com.example.jobportalsystem.mapper;
import com.example.jobportalsystem.dto.request.RoleRequest;
import com.example.jobportalsystem.dto.response.RoleResponse;
import com.example.jobportalsystem.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

    @Mapper(componentModel = "spring")
    public interface RoleMapper {

  //@Mapping(target = "id", ignore = true)
  // @Mapping(target = "vacancies", ignore = true)
        Role toEntity(RoleRequest request);

        RoleResponse toResponse(Role role);
    }

