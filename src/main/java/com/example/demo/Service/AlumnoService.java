package com.example.demo.Service;

import com.example.demo.Entity.Alumno;
import com.example.demo.Repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public List<Alumno> listarTodos(){
        return alumnoRepository.findAll();
    }
    public Optional<Alumno> buscarPorId(Long id){
        return alumnoRepository.findById(id);
    }

    public Alumno guardar(Alumno alumno){
        return alumnoRepository.save(alumno);
    }
    public void eliminar(Long id){
        alumnoRepository.deleteById(id);
    }
}
