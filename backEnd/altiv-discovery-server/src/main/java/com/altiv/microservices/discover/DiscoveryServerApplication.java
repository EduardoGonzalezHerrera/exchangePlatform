package com.altiv.microservices.discover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;


@EnableZuulProxy
@EnableEurekaServer
//@EnableResourceServer
@SpringBootApplication
public class DiscoveryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerApplication.class, args);
	}
	
	

}
