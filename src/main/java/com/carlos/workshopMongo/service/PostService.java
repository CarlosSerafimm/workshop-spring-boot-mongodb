package com.carlos.workshopMongo.service;

import com.carlos.workshopMongo.domain.Post;
import com.carlos.workshopMongo.domain.User;
import com.carlos.workshopMongo.dto.UserDTO;
import com.carlos.workshopMongo.repository.PostRepository;
import com.carlos.workshopMongo.repository.UserRepository;
import com.carlos.workshopMongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostService {

    @Autowired
    private PostRepository repo;



    public Post findById(String id) {
        Post user = repo.findById(id).orElse(null);
        if (user == null) {
            throw new ObjectNotFoundException("Obj não encontrado");
        }
        return user;
    }

    public List<Post> findByTitle(String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }

}