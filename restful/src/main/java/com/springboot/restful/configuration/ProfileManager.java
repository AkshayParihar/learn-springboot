package com.springboot.restful.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ProfileManager {

    @Autowired
    private Environment environment;

    @Autowired
    Properties prop;

    public void getActiveProfiles(){
        for(String profileName: environment.getActiveProfiles()){
            System.out.println("Currently activated profile : "+profileName);
        }
    }

    public void getPropertyValue(){
        System.out.println(prop);
    }

}
