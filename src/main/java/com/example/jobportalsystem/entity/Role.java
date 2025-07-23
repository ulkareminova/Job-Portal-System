package com.example.jobportalsystem.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
@Getter
@Setter
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Role {

  @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String roleName;
    @OneToMany(mappedBy = "role")
    List<Vacancy> vacancies;
}
