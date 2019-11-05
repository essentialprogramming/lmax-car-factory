package com.service;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EchoService {//implements EventHandler<RingBufferEvent> {

    private final String echoMessage = "Hello ";

    public String sayHello(String name) throws Exception {
        return echoMessage + name;
    }
}
