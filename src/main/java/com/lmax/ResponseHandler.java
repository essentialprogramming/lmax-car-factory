package com.lmax;

import com.lmax.disruptor.EventHandler;
import com.model.CarEvent;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ResponseHandler implements EventHandler<CarEvent> {

    @Override public void onEvent(CarEvent carEvent, long l, boolean b)  {
        String message ="Car with [signature: " + carEvent.hashCode() + "] and the following attributes: [" +
                        carEvent.getColour() + ", " + carEvent.getEngineType() + ", " + carEvent.getModel() +
                        "] has [Completed Status]: " + carEvent.isCarCompleted()  + ".\nWaiting for delivery!";
        System.out.println("Response sent!");
        carEvent.getAsyncResponse().resume(message);
    }
}
