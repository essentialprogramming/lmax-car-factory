package com.lmax.disruptors;

import com.lmax.QualityAssuranceConsumer;
import com.lmax.consumers.*;
import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.lmax.disruptor.util.DaemonThreadFactory;
import com.model.CarEvent;
import com.model.CarEventFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;

@ApplicationScoped
public class IncomingCarEventDisruptor {


    @Inject CarEventFactory carEventFactory;
    @Inject EngineConsumer engineConsumer;
    @Inject DriverSeatConsumer driverSeatConsumer;
    @Inject PassengerSeatConsumer passengerSeatConsumer;
    @Inject RearSeatConsumer rearSeatConsumer;
    @Inject FrontDoorOneConsumer frontDoorOneConsumer;
    @Inject FrontDoorTwoConsumer frontDoorTwoConsumer;
    @Inject RearDoorOneConsumer rearDoorOneConsumer;
    @Inject RearDoorTwoConsumer rearDoorTwoConsumer;
    @Inject PaintConsumer paintConsumer;
    @Inject WheelOneConsumer wheelOneConsumer;
    @Inject WheelTwoConsumer wheelTwoConsumer;
    @Inject WheelThreeConsumer wheelThreeConsumer;
    @Inject WheelFourConsumer wheelFourConsumer;

    @Inject QualityAssuranceConsumer qualityAssuranceConsumer;

    private Disruptor<CarEvent> disruptor;
    private int ringBufferSize = (int) Math.pow(2,10);

    @PostConstruct
    public void constructDisruptor() {

        disruptor = new Disruptor<>(carEventFactory, ringBufferSize, DaemonThreadFactory.INSTANCE, ProducerType.SINGLE, new BlockingWaitStrategy());

       disruptor.handleEventsWith(engineConsumer)
                 .and(disruptor.handleEventsWith(driverSeatConsumer,passengerSeatConsumer, rearSeatConsumer)
                                 .then(frontDoorTwoConsumer,frontDoorOneConsumer,rearDoorOneConsumer, rearDoorTwoConsumer)
                ).then(paintConsumer)
                 .then(wheelOneConsumer,wheelTwoConsumer,wheelThreeConsumer,wheelFourConsumer).then(qualityAssuranceConsumer);


        disruptor.start();
    }

    public Disruptor<CarEvent> getDisruptor() {
        return disruptor;
    }
}
