package com.example.jobportalsystem.dto.response;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationResponse {
    private String message;
    private String vacancyName;
    private String companyEmail;
}
