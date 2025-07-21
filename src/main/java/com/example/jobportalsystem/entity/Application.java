package com.example.jobportalsystem.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;
@Entity
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "applications")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
   @JoinColumn(name = "job_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Vacancy vacancy;
@NotNull
    private LocalDateTime appliedAt;

public LocalDateTime getAppliedAt(){
//    appliedAt = LocalDateTime.now();
return appliedAt;
}
    public void setvacancy(Vacancy vacancy) {
        this.vacancy = vacancy;
    }
}


//    public ZipEntry getVacancy() {
//        return null;
//    }
//
//    public void setUser(User user) {
//    }
//
//    public void setvacancy(Vacancy vacancy) {
//    }
//
//    public void setAppliedAt(LocalDateTime now) {
//
//  }
//
//    public Object getAppliedAt() {
//        return null;
//    }
//
//    public void setUser(User user) {
//    }




