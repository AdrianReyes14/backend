package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service){
        this.service=service;
    }
    @GetMapping
    public List<User>getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<User>getById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PostMapping
    public User create(@RequestBody User user){
        return service.save(user);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.deleteByid(id);
        return ResponseEntity.noContent().build();
    }

}
