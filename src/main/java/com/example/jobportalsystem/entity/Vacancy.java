package com.example.jobportalsystem.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vacancy")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String description;
    String startDate;
    String endDate;
    String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    Role role;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employer_id")
    Employer employer;

    public Long getId(){
        return String.valueOf(id);
    }
//    public Vacancy orElseThrow(Object vacancyIsNotFound) {
//        return null;
//    }

//    @Override
//    public String toString() {
//        return "Vacancy{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
//                ", startDate='" + startDate + '\'' +
//                ", endDate='" + endDate + '\'' +
//                ", email='" + email + '\'' +
//                ", role=" + role +
//                ", employer=" + employer +
//                '}';
//    }
//    public Vacancy orElseThrow(Object o) {
//        return null;
    }




