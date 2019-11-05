package com.service;

import com.model.Message;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped 
public class ApiServiceImpl implements ApiService {

	public Message buildHelloMessage(String name)
			throws Exception {
		if (name == null) {
			throw new Exception("Name parameter must not be null!");
		}
		
		return new Message("Hello " + name);
	}

}
