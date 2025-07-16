package com.example.jobportalsystem.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppliedVacancyDTO {
private String vacancyId;
private String vacancyName;
private String companyEmail;
private String appliedDate;
}
