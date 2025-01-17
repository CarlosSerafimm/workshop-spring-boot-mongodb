package com.carlos.workshopMongo.service;

import java.util.List;

import com.carlos.workshopMongo.domain.User;
import com.carlos.workshopMongo.dto.UserDTO;
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

    public User insert(User obj){
        return repo.insert(obj);
    }

    public void delete(String id) {
        findById(id);
        repo.deleteById(id);
    }
    public User update(User obj) {
       User newObj = repo.findById(obj.getId()).orElse(null);
       updateData(newObj, obj);
       return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setEmail(obj.getEmail());
        newObj.setName(obj.getName());
    }


    public User fromDTO(UserDTO objDTO){
        return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
    }
}