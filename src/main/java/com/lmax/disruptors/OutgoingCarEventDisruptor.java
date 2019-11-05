package com.lmax.disruptors;

import com.lmax.ResponseHandler;
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
public class OutgoingCarEventDisruptor {
    @Inject CarEventFactory carEventFactory;

    @Inject
    ResponseHandler responseHandler;

    private Disruptor<CarEvent> disruptor;
    private int ringBufferSize = (int) Math.pow(2,10);


    @PostConstruct
    public void constructDisruptorSingleConsumer() {
        System.out
                .println("[constructDisruptor] PostConstruct called now. Time : " + LocalDateTime.now());
        disruptor = new Disruptor<>(carEventFactory, ringBufferSize, DaemonThreadFactory.INSTANCE, ProducerType.SINGLE, new BlockingWaitStrategy());
        disruptor.handleEventsWith(responseHandler);

        disruptor.start();
    }
    public Disruptor<CarEvent> getDisruptor() {
        return disruptor;
    }

}
