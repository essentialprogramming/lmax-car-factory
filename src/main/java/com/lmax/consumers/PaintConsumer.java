package com.lmax.consumers;

import com.lmax.disruptor.EventHandler;
import com.model.CarEvent;
import com.model.Status;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaintConsumer implements EventHandler<CarEvent> {

    @Override public void onEvent(CarEvent carEvent, long l, boolean b)  {
        carEvent.setPaint(Status.IN_PROGRESS);
        System.out.println("Working on Car's painting");
        carEvent.setPaint(Status.COMPLETED);
        System.out.println("Car's painting is done successfully.");
    }
}
