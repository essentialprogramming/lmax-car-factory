package com.lmax;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.EventTranslator;
import com.lmax.disruptors.OutgoingCarEventDisruptor;
import com.model.CarEvent;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class QualityAssuranceConsumer implements EventHandler<CarEvent> {

    @Inject
    OutgoingCarEventDisruptor outgoingCarEventDisruptor;

    @Override
    public void onEvent(CarEvent carEvent, long sequenceNumber, boolean b) {
        carEvent.setCarCompleted(true);
        //System.out.println("Quality Assurance : PASSED");
        handle(carEvent);
    }

    public void handle(CarEvent carEvent) {

        EventTranslator<CarEvent> eventTranslator = (reqEvent, sequence) -> {
            reqEvent.setModel(carEvent.getModel());
            reqEvent.setEngineType(carEvent.getEngineType());
            reqEvent.setColour(carEvent.getColour());

            reqEvent.setAsyncResponse(carEvent.getAsyncResponse());

            reqEvent.setCarCompleted(carEvent.isCarCompleted());
            reqEvent.setEngine(carEvent.getEngine());
            reqEvent.setDriverSeat(carEvent.getDriverSeat());
            reqEvent.setPassengerSeat(carEvent.getPassengerSeat());
            reqEvent.setRearSeat(carEvent.getRearSeat());
            reqEvent.setFrontDoorOne(carEvent.getFrontDoorOne());
            reqEvent.setFrontDoorTwo(carEvent.getFrontDoorTwo());
            reqEvent.setRearDoorOne(carEvent.getRearDoorOne());
            reqEvent.setRearDoorTwo(carEvent.getRearDoorTwo());
            reqEvent.setPaint(carEvent.getPaint());
            reqEvent.setWheelOne(carEvent.getWheelOne());
            reqEvent.setWheelTwo(carEvent.getWheelTwo());
            reqEvent.setWheelThree(carEvent.getWheelThree());
            reqEvent.setWheelFour(carEvent.getWheelFour());
        };
        outgoingCarEventDisruptor.getDisruptor().publishEvent(eventTranslator);
    }
}
