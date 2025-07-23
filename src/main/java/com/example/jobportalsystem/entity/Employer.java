package com.example.jobportalsystem.entity;
import com.example.jobportalsystem.entity.Vacancy;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employer")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private  Long id;

   private String name;
  private String description;

    @OneToMany(mappedBy = "employer")
  private List<Vacancy> vacancies;
}


