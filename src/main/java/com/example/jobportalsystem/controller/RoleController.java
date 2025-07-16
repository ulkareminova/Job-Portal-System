package com.example.jobportalsystem.controller;
import com.example.jobportalsystem.dto.response.RoleResponse;
import com.example.jobportalsystem.repository.RoleRepository;
import com.example.jobportalsystem.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.support.ResourceTransactionManager;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("v1/role")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;
    private final ResourceTransactionManager resourceTransactionManager;

    @PostMapping
    public ResponseEntity<RoleResponse> create(RequestBody RoleRequest request){
        return ResponseEntity.ok(roleService.create(request));
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(roleService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<RoleResponse>> getAll() {
        return ResponseEntity.ok(roleService.getAll());
    }

    @PutMapping("/{id}")
    public <CategoryRequest> ResponseEntity<RoleResponse> update(@PathVariable Long id, @RequestBody CategoryRequest request) {
        return ResponseEntity.ok(roleService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
    roleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}



