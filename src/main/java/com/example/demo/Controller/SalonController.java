package com.example.demo.Controller;

import com.example.demo.Entity.Plantel;
import com.example.demo.Entity.Salon;
import com.example.demo.Service.SalonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/salones")
public class SalonController {
    private final SalonService service;

    public SalonController(SalonService service){
        this.service = service;
    }
    @GetMapping
    public List<Salon>getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Salon>getById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Salon create(@RequestBody Salon salon){
        return service.save(salon);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
