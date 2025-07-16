package com.example.jobportalsystem.dto.request;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacancyRequest {
private String name;
private String description;
private String email;
private String startDate;
private String endDate;
private Long categoryId;
private Long employerId;
}
