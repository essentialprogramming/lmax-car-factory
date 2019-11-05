package com.lmax.consumers;

import com.lmax.disruptor.EventHandler;
import com.model.CarEvent;
import com.model.Status;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class DriverSeatConsumer implements EventHandler<CarEvent> {

    @Override public void onEvent(CarEvent carEvent, long l, boolean b)  {
        carEvent.setDriverSeat(Status.IN_PROGRESS);
        System.out.println("Working on Driver's seat");
        carEvent.setDriverSeat(Status.COMPLETED);
        System.out.println("Driver's seat is successfully assembled.");
    }
}
