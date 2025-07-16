package com.example.jobportalsystem.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.zip.ZipEntry;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private User candidate;

    private String resume;

    private LocalDate applicationDate;

    private String status;

    public ZipEntry getVacancy() {
        return null;
    }

    public void setUser(User user) {
    }

    public void setvacancy(Vacancy vacancy) {
    }

    public void setAppliedAt(LocalDateTime now) {
        
    }

//    public void setUser(User user) {
//    }
}



