package com.lmax.consumers;

import com.lmax.disruptor.EventHandler;
import com.model.CarEvent;
import com.model.Status;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RearDoorOneConsumer implements EventHandler<CarEvent> {

    @Override public void onEvent(CarEvent carEvent, long l, boolean b) throws InterruptedException {
        carEvent.setRearDoorOne(Status.IN_PROGRESS);
        System.out.println("Working on Rear Door 1");
        carEvent.setRearDoorOne(Status.COMPLETED);
        System.out.println("Rear Door 1 is successfully assembled.");
    }
}
