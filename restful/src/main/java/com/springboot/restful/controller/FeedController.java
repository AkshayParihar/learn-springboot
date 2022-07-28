package com.springboot.restful.controller;

import com.springboot.restful.model.Feed;
import com.springboot.restful.service.GetFeedsService;
import com.springboot.restful.service.PostFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@RestController
public class FeedController {

    @Autowired
    GetFeedsService getFeedsService;

    @Autowired
    PostFeedService postFeedService;

    @GetMapping("/feeds")
    public ResponseEntity<Feed[]> getFeeds(){
        return ResponseEntity.ok().body(getFeedsService.getFeeds());
    }

    @PostMapping("/feed")
    public ResponseEntity<Feed> postFeed(
            @RequestBody Feed feed,
            @RequestHeader Map<String,String> headers){
        Feed responseBody = postFeedService.postFeed(headers,feed);
        return ResponseEntity.created(URI.create("/feeds/"+feed.getUserId())).body(responseBody);
    }
}
