package com.carlos.workshopMongo.service;

import java.util.List;

import com.carlos.workshopMongo.domain.User;
import com.carlos.workshopMongo.repository.UserRepository;
import com.carlos.workshopMongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }

    public User findById(String id){
        User user = repo.findById(id).orElse(null);
        if(user == null){
            throw new ObjectNotFoundException("Obj não encontrado");
        }
        return user;
    }
}