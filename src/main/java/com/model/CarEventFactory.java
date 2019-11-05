package com.model;

import com.lmax.disruptor.EventFactory;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CarEventFactory implements EventFactory<CarEvent> {

    @Override
    public CarEvent newInstance() {
        return new CarEvent();
    }
}
