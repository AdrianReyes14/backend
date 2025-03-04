package com.example.demo.Service;

import com.example.demo.Entity.Estado;
import com.example.demo.Repository.EstadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {
    private final EstadoRepository repository;

    public EstadoService(EstadoRepository repository){
        this.repository = repository;
    }
    public List<Estado>findAll(){
        return repository.findAll();
    }
    public Optional<Estado>findById(Long id){
        return repository.findById(id);
    }
    public Estado save(Estado estado){
        return repository.save(estado);
    }
    public Estado update(Long id, Estado estadoDetails){
        return repository.findById(id).map(estado -> {
            estado.setNombre(estadoDetails.getNombre());
            return repository.save(estado);
        }).orElseThrow(()-> new RuntimeException("Estado no encontrado"));
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
