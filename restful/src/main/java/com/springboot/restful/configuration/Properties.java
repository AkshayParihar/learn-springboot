package com.springboot.restful.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Properties {
    @Value("${posts.common}")
    private String commonPosts;

    @Value("${spring.config.activate.on-profile}")
    private String activatedProfile;

    @Value("${posts.env}")
    private String environment;

}
