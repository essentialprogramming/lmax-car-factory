package com.lmax.consumers;

import com.lmax.disruptor.EventHandler;
import com.model.CarEvent;
import com.model.Status;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class RearDoorTwoConsumer implements EventHandler<CarEvent> {
    @Override public void onEvent(CarEvent carEvent, long l, boolean b)  {
        carEvent.setRearDoorTwo(Status.IN_PROGRESS);
        System.out.println("Working on Rear Door 2");
        carEvent.setRearDoorTwo(Status.COMPLETED);
        System.out.println("Rear Door 2 is successfully assembled.");
    }
}
