package com.example.jobportalsystem.repository;

import com.example.jobportalsystem.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}
