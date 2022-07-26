package com.springboot.restful;

import com.springboot.restful.configuration.ProfileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class RestfulApplication {

	@Autowired
	ProfileManager profileManager;

	public static void main(String[] args) {

		SpringApplication.run(RestfulApplication.class, args);

	}

	@Bean
	public RestTemplate getTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@PostConstruct
	public void showProfileManager() {
		profileManager.getPropertyValue();
	}

}
