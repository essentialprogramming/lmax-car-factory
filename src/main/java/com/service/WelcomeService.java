package com.service;

import javax.enterprise.context.ApplicationScoped;
import com.model.*;

@ApplicationScoped
public class WelcomeService {

    private final String echoMessage = ". Welcome!";

    public String  welcome(String message) {
        return message + echoMessage;
    }
}
