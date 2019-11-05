package com.lmax.consumers;

import com.lmax.disruptor.EventHandler;
import com.model.CarEvent;
import com.model.Status;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class FrontDoorTwoConsumer implements EventHandler<CarEvent> {

    @Override public void onEvent(CarEvent carEvent, long l, boolean b) {
        carEvent.setFrontDoorTwo(Status.IN_PROGRESS);
        System.out.println("Working on Front Door 2");
        carEvent.setFrontDoorTwo(Status.COMPLETED);
        System.out.println("Front Door 2 is successfully assembled.");
    }
}
