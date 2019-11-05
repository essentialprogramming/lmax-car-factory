package com.lmax.consumers;

import com.lmax.disruptor.EventHandler;
import com.model.CarEvent;
import com.model.Status;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WheelThreeConsumer implements EventHandler<CarEvent> {

    @Override public void onEvent(CarEvent carEvent, long l, boolean b)  {
        carEvent.setWheelThree(Status.IN_PROGRESS);
        System.out.println("Working on Car's Wheel 3");
        carEvent.setWheelThree(Status.COMPLETED);
        System.out.println("Car's Wheel 3 is successfully assembled..");
    }
}
