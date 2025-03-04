package com.example.demo.Service;

import com.example.demo.Entity.Plantel;
import com.example.demo.Repository.PlantelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlantelService {
    private final PlantelRepository repository;
    public PlantelService(PlantelRepository repository){
        this.repository=repository;
    }
    public List<Plantel>findAll(){
        return repository.findAll();
    }
    public Optional<Plantel> findById(Long id){
        return repository.findById(id);
    }
    public Plantel save(Plantel plantel){
        return repository.save(plantel);
    }
    public Plantel update(Long id,Plantel plantelDetails){
        return repository.findById(id).map(plantel -> {
            plantel.setNombre(plantelDetails.getNombre());
            return repository.save(plantel);
        }).orElseThrow(()->new RuntimeException("Plantel no encontrado"));
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
