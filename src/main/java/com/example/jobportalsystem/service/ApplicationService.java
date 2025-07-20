package com.example.jobportalsystem.service;
import com.example.jobportalsystem.dto.response.ApplicationResponse;
import com.example.jobportalsystem.dto.response.AppliedVacancyDTO;
import com.example.jobportalsystem.entity.Application;
import com.example.jobportalsystem.entity.User;
import com.example.jobportalsystem.entity.Vacancy;
import com.example.jobportalsystem.repository.ApplicationRepository;
import com.example.jobportalsystem.repository.VacancyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;
    private final VacancyRepository vacancyRepository;

    public ApplicationResponse applyToVacancy(Long vacancyId, User user) {
        Vacancy vacancy = vacancyRepository.findById(vacancyId).orElseThrow(() -> new RuntimeException("Vakansiya tapilmadi"));
        boolean alreadyApplied = applicationRepository.exsistsByUserAndVacancy(user, vacancy);
        if (alreadyApplied) {
            throw new RuntimeException("Bu vakansiyaya artiq muraciet etmisiniz");
        }
        Application application = new Application();
        application.setUser(user);
        application.setvacancy(vacancy);
        application.setAppliedAt(LocalDateTime.now());
        applicationRepository.save(application);
        return new ApplicationResponse(
                "CV gondermek ucun email unvanini kopyaliyin.",
                vacancy.getName(),
                vacancy.getEmail());
    }

    public List<AppliedVacancyDTO> getMyApplications(User user) {
        List<Application> applications = applicationRepository.findAllByUser(user);

        return applications.stream().map(app -> new AppliedVacancyDTO(
                app.getVacancy().getId(),
                app.getVacancy().getName(),
                app.getVacancy().getEmail(),
                app.getAppliedAt().toString
        )).collect(Collectors.toList());
    }
}

