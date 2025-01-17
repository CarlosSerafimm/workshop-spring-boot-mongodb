package com.carlos.workshopMongo.service;

import java.util.List;

import com.carlos.workshopMongo.domain.User;
import com.carlos.workshopMongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}