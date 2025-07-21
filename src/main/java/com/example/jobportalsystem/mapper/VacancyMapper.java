package com.example.jobportalsystem.mapper;

import com.example.jobportalsystem.dto.request.VacancyRequest;
import com.example.jobportalsystem.dto.response.VacancyResponse;
import com.example.jobportalsystem.entity.Employer;
import com.example.jobportalsystem.entity.Role;
import com.example.jobportalsystem.entity.Vacancy;
import com.example.jobportalsystem.repository.EmployerRepository;
import com.example.jobportalsystem.repository.RoleRepository;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VacancyMapper {
    private final RoleRepository roleRepository;
    private final EmployerRepository employerRepository;

    public VacancyMapper(RoleRepository roleRepository, EmployerRepository employerRepository) {
        this.roleRepository = roleRepository;
        this.employerRepository = employerRepository;

    }
    public Vacancy toEntity(VacancyRequest request)  {
        if (request == null){
            return null;
        }
        Vacancy vacancy = new Vacancy();
        vacancy.setId(request.getEmployerId());
        vacancy.setName(request.getName());
        vacancy.setDescription(request.getDescription());
        vacancy.setStartDate(request.getStartDate());
        vacancy.setEndDate(request.getEndDate());
        vacancy.setEmail(request.getEmail());

        if (request.getRoleId() != null){
            Role role = roleRepository.findById(request.getRoleId())
                    .orElseThrow(()-> new RuntimeException("Role not found"));
                  vacancy.setRole(role);
        }
        if (request.getEmployerId() != null){
            Employer employer = employerRepository.findById(request.getEmployerId())
                    .orElseThrow(()-> new RuntimeException("Employer not found"));
            vacancy.setEmployer(employer);
        }
        return vacancy;
    }
    public VacancyResponse toResponse(Vacancy vacancy){
        if (vacancy == null){
            return null;
        }
        VacancyResponse response = new VacancyResponse();
        response.setId(vacancy.getId());
        response.setName(vacancy.getName());
        response.setDescription(vacancy.getDescription());
        response.setStartDate(vacancy.getStartDate());
        response.setEndDate(vacancy.getEndDate());
        response.setEmail(vacancy.getEmail());

        if (vacancy.getRole() != null){
            response.setRoleName(vacancy.getRole().getRoleName());
        }
        if (vacancy.getEmployer() != null){
            response.setEmployerName(vacancy.getEmployer().getName());
        }
        return response;
    }

    public void updateEntity(Vacancy vacancy, VacancyRequest request) {
        if (request == null){
            return;
        }
        vacancy.setName(request.getName());
        vacancy.setDescription(request.getDescription());
        vacancy.setStartDate(request.getStartDate());
        vacancy.setEndDate(request.getEndDate());
        vacancy.setEmail(request.getEmail());

        if (request.getRoleId() != null){
            Role role = roleRepository.findById(request.getRoleId())
                    .orElseThrow(()-> new RuntimeException("Role not found"));
            vacancy.setRole(role);
        }
        if (request.getEmployerId() != null){
            Employer employer = employerRepository.findById(request.getEmployerId())
                    .orElseThrow(()-> new RuntimeException("Employer not found"));
            vacancy.setEmployer(employer);
        }
    }

}
