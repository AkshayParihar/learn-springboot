package com.springboot.restful.service;

import com.springboot.restful.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class GetPostsService {

    @Autowired
    RestTemplate restTemplate;

    public Post[] getPosts(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);

        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.GET, entity, Post[].class).getBody();
    }
}
