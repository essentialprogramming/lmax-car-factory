package com.lmax;

import com.lmax.disruptors.IncomingCarEventDisruptor;
import com.model.RequestTranslator;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class DisruptorProducer {

   @Inject
   IncomingCarEventDisruptor incomingCarEventDisruptor;

    public void publishToDisruptor(RequestTranslator requestEvent) {
        incomingCarEventDisruptor.getDisruptor().publishEvent(requestEvent);
    }

}
