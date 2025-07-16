package com.example.jobportalsystem.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import org.springframework.data.annotation.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Getter
    @Setter
    @jakarta.persistence.Id
    @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String roleName;

}
