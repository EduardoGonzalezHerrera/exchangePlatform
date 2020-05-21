package com.altiv.microservices.configserver.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altiv.microservices.configserver.DbSettings;

@RestController
public class GreetingController {

	//@Value("${altiv.greeting:default Altiv greeting }")
	private String greetingMessage;
	
	//@Value("${altiv.exchangeOptions}")
	private List<String> exchangeOptions;
	
	//@Value("#{${altiv.db.connection}}")
	private Map<String,String> dbProperties;
	
	//@Autowired
	private DbSettings dbSettings;
	
	@GetMapping("/greeting")
	public String greeting() {
		return this.greetingMessage + dbSettings.getPort() +this.dbSettings.getConnection() ;
	}
	
	@GetMapping("/exchangeOptions")
	public List<String> exchangeOptions(){
		return this.exchangeOptions;
	}
	
	
	@GetMapping("/dbProperties")
	public Map<String,String> dbProperties(){
		return this.dbProperties;
	}
	
	@GetMapping("/dbSettings")
	public DbSettings DbSettings(){
		return this.dbSettings;
	}
	
}
