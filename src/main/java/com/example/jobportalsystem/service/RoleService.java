package com.example.jobportalsystem.service;
import com.example.jobportalsystem.dto.request.RoleRequest;
import com.example.jobportalsystem.dto.response.RoleResponse;
import com.example.jobportalsystem.entity.Role;
import com.example.jobportalsystem.mapper.RoleMapper;
import com.example.jobportalsystem.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleResponse create(RoleRequest request){
        Role role =RoleMapper.toEntity(request);
        return roleMapper.toResponse(roleRepository.save(role));
    }

    public RoleResponse getById(Long id){
        Role role = roleRepository.findById(id)
                .orElseThrow(
                        ()-> new RuntimeException("Rol tapilmadi"));
        return roleMapper.toResponse(role);
    }
    public List<RoleResponse> getAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toResponse).
                collect(Collectors.toList());
    }
    public RoleResponse update(Long id, RoleRequest request){
        Role role = roleRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Rol tapilmadi"));
        role.setRoleName(request.getRoleName());
        return roleMapper.toResponse(roleRepository.save(role));
    }
    public void delete(Long id){roleRepository.deleteById(id);}
}
