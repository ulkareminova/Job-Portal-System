package com.example.jobportalsystem.controller;
import com.example.jobportalsystem.dto.security.AuthResponse;
import com.example.jobportalsystem.dto.security.LoginDTO;
import com.example.jobportalsystem.dto.security.RegisterDTO;
import com.example.jobportalsystem.service.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auths")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterDTO request) {
        AuthResponse response= authService.register(request);
                return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginDTO request){
        AuthResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }
}


