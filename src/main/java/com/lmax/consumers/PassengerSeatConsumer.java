package com.lmax.consumers;

import com.lmax.disruptor.EventHandler;
import com.model.CarEvent;
import com.model.Status;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PassengerSeatConsumer implements EventHandler<CarEvent> {

    @Override public void onEvent(CarEvent carEvent, long l, boolean b)  {
        carEvent.setPassengerSeat(Status.IN_PROGRESS);
        System.out.println("Working on Passenger's seat");
        carEvent.setPassengerSeat(Status.COMPLETED);
        System.out.println("Passenger's seat is successfully assembled.");
    }
}
