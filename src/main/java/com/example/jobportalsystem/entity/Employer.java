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
   Long id;

   String name;
   String description;

    @OneToMany(mappedBy = "employer")
  List<Vacancy> vacancies;
}


