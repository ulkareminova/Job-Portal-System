package com.example.jobportalsystem.service;
import com.example.jobportalsystem.dto.request.EmployerRequest;
import com.example.jobportalsystem.dto.response.EmployerResponse;
import com.example.jobportalsystem.entity.Employer;
import com.example.jobportalsystem.mapper.EmployerMapper;
import com.example.jobportalsystem.repository.EmployerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployerService {
    private final EmployerRepository employerRepository;
    private final EmployerMapper employerMapper;

    public EmployerResponse create(EmployerRequest request){
        Employer employer = employerMapper.toEntity(request);
        return employerMapper.toResponse(Optional.of((Employer) employerRepository.save(employer)));
    }

    public EmployerResponse getById(Long id) throws Throwable {
       Optional<Employer> employer= (Optional<Employer>) employerRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Employer is not found"));
        return employerMapper.toResponse(employer);
    }

    public List<EmployerResponse> getAll(){
      return (List<EmployerResponse>) employerRepository.findAll().stream()
              .map(employerMapper::toResponse)
              .collect(Collectors.toList());
    }
    public EmployerResponse update(Long id,EmployerRequest request) throws Throwable {
        Employer employer= (Employer) employerRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Employer is not found"));
        employer.setName(request.getName());
        employer.setDescription(request.getDescription());
        return (EmployerResponse) employerMapper.toResponse(employerRepository.save(employer));
    }

    public void delete(Long id){
        if (!employerRepository.existsById(id)){
            throw new RuntimeException("Employer is not found");
        }
        employerRepository.deleteById(id);
    }
}
