package com.springboot.restful.controller;

import com.springboot.restful.model.Feed;
import com.springboot.restful.service.GetFeedsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeedController {

    @Autowired
    GetFeedsService getFeedsService;

    @GetMapping("/feeds")
    public ResponseEntity<Feed[]> getFeeds(){
        return ResponseEntity.ok().body(getFeedsService.getFeeds());
    }
}
