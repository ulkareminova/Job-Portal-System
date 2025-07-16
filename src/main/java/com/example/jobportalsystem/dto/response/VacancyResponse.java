package com.example.jobportalsystem.dto.response;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacancyResponse {
    private Long id;
    private String name;
    private String description;
    private String email;
    private String startDate;
    private String endDate;
    private String categoryName;
    private String employerName;
}
