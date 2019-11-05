package com.model;

import com.lmax.disruptor.EventTranslator;
import javax.ws.rs.container.AsyncResponse;

public class RequestTranslator implements EventTranslator<CarEvent> {

    private RequestModel request;
    private AsyncResponse asyncResponse;

    public RequestTranslator(RequestModel request, AsyncResponse asyncResponse) {
        this.request = request;
        this.asyncResponse = asyncResponse;
    }

    @Override public void translateTo(CarEvent carEvent, long l) {
        carEvent.setColour(request.getColour());
        carEvent.setEngineType(request.getEngineType());
        carEvent.setModel(request.getModel());

        carEvent.setAsyncResponse(asyncResponse);

        carEvent.setEngine(Status.NOT_STARTED);
        carEvent.setDriverSeat(Status.NOT_STARTED);
        carEvent.setPassengerSeat(Status.NOT_STARTED);
        carEvent.setRearSeat(Status.NOT_STARTED);
        carEvent.setFrontDoorOne(Status.NOT_STARTED);
        carEvent.setFrontDoorTwo(Status.NOT_STARTED);
        carEvent.setRearDoorOne(Status.NOT_STARTED);
        carEvent.setRearDoorTwo(Status.NOT_STARTED);
        carEvent.setPaint(Status.NOT_STARTED);
        carEvent.setWheelOne(Status.NOT_STARTED);
        carEvent.setWheelTwo(Status.NOT_STARTED);
        carEvent.setWheelThree(Status.NOT_STARTED);
        carEvent.setWheelFour(Status.NOT_STARTED);
    }
}
