package com.example.jobportalsystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private String location;
    private LocalDate postedDate;
    @ManyToOne
    private User employeId;


}
