package com.carlos.workshopMongo.controller;

import com.carlos.workshopMongo.domain.Post;
import com.carlos.workshopMongo.domain.User;
import com.carlos.workshopMongo.dto.UserDTO;
import com.carlos.workshopMongo.service.PostService;
import com.carlos.workshopMongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {

        Post obj = service.findById(id);

        return ResponseEntity.ok().body(obj);
    }


}