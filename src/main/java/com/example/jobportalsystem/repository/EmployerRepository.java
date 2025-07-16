package com.example.jobportalsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployerRepository<Employer> extends JpaRepository<Employer, Long> {
}
