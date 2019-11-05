package com.api.resources;

import com.model.RequestModel;
import com.model.RequestTranslator;
import com.lmax.DisruptorProducer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;

@RequestScoped
@Path("/")
public class LmaxDisruptorEndpointRouter {

    @Inject
    private DisruptorProducer disruptorProducer;

    @GET
    @Produces("application/json")
    @Path("lmax")
    public void testLmaxDisruptor( final RequestModel param,
                                  @Suspended AsyncResponse asyncResponse) {
        final RequestTranslator requestTranslator = new RequestTranslator(param, asyncResponse);
        disruptorProducer.publishToDisruptor(requestTranslator);
    }
}
