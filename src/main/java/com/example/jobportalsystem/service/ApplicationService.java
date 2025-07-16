package com.example.jobportalsystem.service;
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
public class ApplicationService<ApplicationResponse, AppliedVacancyDto> {
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

    public List<AppliedVacancyDto> getMyApplications(User user) {
        List<Application> applications = applicationRepository.findAllByUser(user);

        return applications.stream().map(app -> new AppliedVacancyDto(
                app.getVacancy().getId(),
                app.getVacancy().getName(),
                app.getVacancy().getEmail(),
                app.getVacancy().toString
        )).collect(Collectors.toList());
    }

}

