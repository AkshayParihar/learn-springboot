package com.springboot.restful.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class PostsResponse {
    @Getter
    @Setter
    List<Post> posts = new ArrayList<>();
}
