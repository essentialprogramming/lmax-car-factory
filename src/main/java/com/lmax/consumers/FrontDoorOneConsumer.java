package com.lmax.consumers;

import com.lmax.disruptor.EventHandler;
import com.model.CarEvent;
import com.model.Status;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FrontDoorOneConsumer implements EventHandler<CarEvent> {

    @Override public void onEvent(CarEvent carEvent, long l, boolean b)  {
        carEvent.setFrontDoorOne(Status.IN_PROGRESS);
        System.out.println("Working on Front Door 1");
        carEvent.setFrontDoorOne(Status.COMPLETED);
        System.out.println("Front Door 1 is successfully assembled.");
    }
}
