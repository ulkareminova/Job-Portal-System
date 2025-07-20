package com.example.jobportalsystem.controller;
import com.example.jobportalsystem.dto.response.ApplicationResponse;
import com.example.jobportalsystem.dto.response.AppliedVacancyDTO;
import com.example.jobportalsystem.entity.User;
//import com.jayway.jsonpath.internal.path.ArraySliceOperation;
import com.example.jobportalsystem.service.ApplicationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static com.sun.beans.introspect.PropertyInfo.Name.description;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
@Tag(name = "Applications", description=" Vakansiyalara muraciet ve baxis emeliyyatlari")
public class ApplicationController<AppliedVacancyDto> {
    private final ApplicationService applicationService;

@Operation(summary= "Vakansiyaya muraciet et", description="Istifadeci vakansiyaya muraciet edir ve email alir" )
@PostMapping("/apply/{vacancyId}")
public ResponseEntity<ApplicationResponse> applyToVacancy(
        @PathVariable Long vacancyId,
        @AuthenticationPrincipal User user){
    ApplicationResponse response= (ApplicationResponse) applicationService.applyToVacancy(vacancyId, user);
    return ResponseEntity.ok(response);
}
   @Operation(summary= "Muraciet etdiyim vakansiyalar", description = "Istifadeci oz apply etdiyi vakansiyalarin siyahisini gorur.")
    @GetMapping("/my")
    public ResponseEntity<List<AppliedVacancyDTO>> getMyApplications(
            @AuthenticationPrincipal User user){
    List<AppliedVacancyDTO> applications = applicationService.getMyApplications(user);
            return ResponseEntity.ok(applications);
   }
    }

