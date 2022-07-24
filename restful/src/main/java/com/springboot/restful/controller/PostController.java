package com.springboot.restful.controller;

import com.springboot.restful.model.Post;
import com.springboot.restful.service.GetPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    @Autowired
    GetPostsService getPostsService;

    @GetMapping("/products")
    public ResponseEntity<Post[]> getProducts(){
        return ResponseEntity.ok().body(getPostsService.getPosts());
    }
}
