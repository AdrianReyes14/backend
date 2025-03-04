package com.example.demo.Controller;

import com.example.demo.Entity.UserRol;
import com.example.demo.Service.UserRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user_roles")
public class UserRolController {
    private final UserRolService service;
    public UserRolController(UserRolService service){
        this.service=service;
    }
    @GetMapping
    public List<UserRol>getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserRol>getById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PostMapping
    public UserRol create(@RequestBody UserRol userRol){
        return service.save(userRol);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

