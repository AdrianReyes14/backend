package com.example.demo.Service;

import com.example.demo.Entity.UserRol;
import com.example.demo.Repository.UserRolRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRolService {
    private final UserRolRepository repository;
    public UserRolService(UserRolRepository repository){
        this.repository=repository;
    }
    public List<UserRol>findAll(){
        return repository.findAll();
    }
    public Optional<UserRol>findById(Long id){
        return repository.findById(id);
    }
    public UserRol save(UserRol userRol){
        return repository.save(userRol);
    }
    public void deleteById(long id){
        repository.deleteById(id);
    }

}



