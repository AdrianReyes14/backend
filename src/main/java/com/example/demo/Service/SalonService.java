package com.example.demo.Service;

import com.example.demo.Entity.Salon;
import com.example.demo.Repository.SalonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonService {
    private final SalonRepository repository;
    public SalonService(SalonRepository repository){
        this.repository=repository;
    }
    public List<Salon>findAll(){
        return repository.findAll();
    }
    public Optional<Salon>findById(Long id){
        return repository.findById(id);
    }
    public Salon save(Salon salon){
        return repository.save(salon);
    }
    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
