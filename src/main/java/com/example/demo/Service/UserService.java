package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;
    public UserService(UserRepository repository){
        this.repository=repository;
    }
    public List<User>findAll(){
        return repository.findAll();
    }
    public Optional<User>findById(Long id){
        return repository.findById(id);
    }
    public User save(User user){
        return repository.save(user);
    }
    public void deleteByid(Long id){
        repository.deleteById(id);
    }
}
