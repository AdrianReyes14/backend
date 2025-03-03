package com.example.demo.Controller;


import com.example.demo.Entity.Alumno;
import com.example.demo.Service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {
    @Autowired
    private AlumnoService alumnoService;

    @GetMapping
    public List<Alumno> obtenerTodos(){
        return alumnoService.listarTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Alumno> obtenerPorId(@PathVariable Long id){
        Optional<Alumno> alumno = alumnoService.buscarPorId(id);
        return alumno.map(ResponseEntity:: ok).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Alumno crear(@RequestBody Alumno alumno){
        return alumnoService.guardar(alumno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alumno> actualizar(@PathVariable Long id, @RequestBody Alumno alumno) {
        if (!alumnoService.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();

        }
        alumno.setId(id);
        return ResponseEntity.ok(alumnoService.guardar(alumno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        if(!alumnoService.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        alumnoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

}
