package com.lmax.consumers;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;
import com.model.CarEvent;
import com.model.Status;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EngineConsumer implements EventHandler<CarEvent>, WorkHandler<CarEvent> {

    @Override public void onEvent(CarEvent carEvent, long sequence, boolean endOfBatch) throws InterruptedException {

        if (endOfBatch) System.out.println(".......................................................................................");
        carEvent.setEngine(Status.IN_PROGRESS);
       // System.out.println("Working on Engine");
       // Thread.sleep(5000);
        carEvent.setEngine(Status.COMPLETED);
        System.out.println("Engine is successfully assembled.");
    }

    @Override public void onEvent(CarEvent carEvent) throws Exception {
        carEvent.setEngine(Status.IN_PROGRESS);
        System.out.println("[Worker Pool] Working on Engine");
       // Thread.sleep(5000);
        carEvent.setEngine(Status.COMPLETED);
        System.out.println("Engine is successfully assembled.");
    }
}
