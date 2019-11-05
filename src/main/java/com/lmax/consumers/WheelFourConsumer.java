package com.lmax.consumers;

import com.lmax.disruptor.EventHandler;
import com.model.CarEvent;
import com.model.Status;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class WheelFourConsumer implements EventHandler<CarEvent> {

    @Override public void onEvent(CarEvent carEvent, long l, boolean b)  {
        carEvent.setWheelFour(Status.IN_PROGRESS);
        System.out.println("Working on Car's Wheel 4");
        carEvent.setWheelFour(Status.COMPLETED);
        System.out.println("Car's Wheel 4 is successfully assembled.");
        //carEvent.getAsyncResponse().resume(carEvent.getPaint());

    }
}
