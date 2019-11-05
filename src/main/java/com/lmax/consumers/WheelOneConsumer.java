package com.lmax.consumers;

import com.lmax.disruptor.EventHandler;
import com.model.CarEvent;
import com.model.Status;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WheelOneConsumer implements EventHandler<CarEvent> {

    @Override public void onEvent(CarEvent carEvent, long l, boolean b)  {
        carEvent.setWheelOne(Status.IN_PROGRESS);
        System.out.println("Working on Car's Wheel 1");
        carEvent.setWheelOne(Status.COMPLETED);
        System.out.println("Car's Wheel 1 is successfully assembled..");
    }
}
