package com.example.demo.Controller;

import com.example.demo.Entity.Plantel;
import com.example.demo.Service.PlantelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/planteles")
public class PlantelController {
    private final PlantelService service;

    public PlantelController(PlantelService service){
        this.service = service;
    }
    @GetMapping
    public List<Plantel> getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Plantel>getById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Plantel create(@RequestBody Plantel plantel){
        return service.save(plantel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plantel>update(@PathVariable Long id, @RequestBody Plantel plantelDetails){
        try{
            return ResponseEntity.ok(service.update(id,plantelDetails));
        }catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>delete(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
