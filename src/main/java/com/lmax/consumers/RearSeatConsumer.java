package com.lmax.consumers;

import com.lmax.disruptor.EventHandler;
import com.model.CarEvent;
import com.model.Status;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class RearSeatConsumer implements EventHandler<CarEvent> {

    @Override public void onEvent(CarEvent carEvent, long l, boolean b)  {
        carEvent.setRearSeat(Status.IN_PROGRESS);
        System.out.println("Working on Rear Seat");
        carEvent.setRearSeat(Status.COMPLETED);
        System.out.println("Rear Seat is successfully assembled.");
    }
}
