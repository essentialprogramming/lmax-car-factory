package com.service;

import com.model.Message;

public interface ApiService {

	Message buildHelloMessage(String name)
			throws Exception;

}
