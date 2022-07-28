package com.springboot.restful.service;

import com.springboot.restful.model.Feed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Map;


@Service
public class PostFeedService {

    static Logger LOG = LoggerFactory.getLogger(PostFeedService.class);

    @Autowired
    RestTemplate restTemplate;

    public Feed postFeed(Map<String,String> headers, Feed feed){
        headers.forEach((k,v)->{
            LOG.debug("Header key {} , value {}",k,v);
        });
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("AppId",headers.get("AppId"));
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Feed> request = new HttpEntity<>(feed,requestHeaders);
        return restTemplate.exchange("https://jsonplaceholder.typicode.com/posts", HttpMethod.POST,request,Feed.class)
                .getBody();
    }

}
