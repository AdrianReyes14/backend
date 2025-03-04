package com.example.demo.Controller;

import com.example.demo.Entity.Estado;
import com.example.demo.Service.EstadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estados")
public class EstadoController {
    private final EstadoService service;
    public EstadoController(EstadoService service){
        this.service = service;
    }
    @GetMapping
    public List<Estado>getAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Estado> getById(@PathVariable Long id){
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Estado create(@RequestBody Estado estado){
        return service.save(estado);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Estado> update(@PathVariable Long id, @RequestBody Estado estadoDetails){
        try{
            return ResponseEntity.ok(service.update(id,estadoDetails));
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
