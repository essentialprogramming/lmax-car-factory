package com.api.resources;

import com.async.support.Computation;
import com.async.support.ExecutorsProvider;
import com.service.ApiServiceImpl;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

@RequestScoped
@Path("/")
public class TestEndpointRouter {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static int current;
    @Inject
    private ApiServiceImpl apiServiceImpl;
    @Inject
    private ExecutorsProvider executorsProvider;

    @GET
    @Produces("application/json")
    @Path("sync")
    public Response handleRequestSync(@QueryParam("param") String param) {
       return handleRequest(param);
    }

    @GET
    @Produces("application/json")
    @Path("async")
    public void handleRequestAsync(@QueryParam("param") String param, @Suspended AsyncResponse asyncResponse) {
        ExecutorService executorService = executorsProvider.getExecutorService();
        Computation.computeAsync(() -> handleRequest(param), executorService)
                .thenApplyAsync(asyncResponse::resume, executorService)
                .exceptionally(error -> asyncResponse.resume(handleException(error)));
    }

    @GET
    @Produces("application/json")
    @Path("multi-thread")
    public void multipleThreadsAsync(@QueryParam("param") String param, @Suspended AsyncResponse asyncResponse) {
        //executorsProvider.initFixedThreadPool(8);
        ExecutorService executorService = executorsProvider.getExecutorService();
        Computation.computeAsync(() -> handleRequestOneAndFive(param), executorService)
                .thenApplyAsync(asyncResponse::resume, executorService)
                .exceptionally(error -> asyncResponse.resume(handleException(error)));
    }

    @GET
    @Produces("application/json")
    @Path("multi-thread-sync")
    public void multipleThreadSync(@QueryParam("param") String param) {
        handleRequest(param);
    }

    @GET
    @Produces("application/json")
    @Path("memory")
    public void outOfMemory(@QueryParam("param") String param,@Suspended AsyncResponse asyncResponse) {
        //executorsProvider.initCachedThreadPool();
        ExecutorService executorService = executorsProvider.getExecutorService();
        Computation.computeAsync(() -> handleRequestOutOfMemory(param), executorService)
                .thenApplyAsync(asyncResponse::resume, executorService)
                .exceptionally(error -> asyncResponse.resume(handleException(error)));

    }


    private Response handleRequest(String name) {
        try {
            Thread.sleep(3000);
            return Response.ok().entity(apiServiceImpl.buildHelloMessage(name)).build();
        } catch (Exception e) {
            return Response.status(400).build();
        }
    }

    private Response handleRequestOneAndFive(String name) {
        try {
            current = atomicInteger.incrementAndGet();
            if (current < 5) {
                System.out.println(current);
                System.out.println(atomicInteger.get());
                Thread.sleep(5000);
            } else {
                Thread.sleep(1000);
            }

            return Response.ok().entity(apiServiceImpl.buildHelloMessage(name)).build();
        } catch (Exception e) {
            return Response.status(400).build();
        }
    }

    private Response handleRequestOutOfMemory(String name) {
        try {
            Thread.sleep(100000);
            return Response.ok().entity(apiServiceImpl.buildHelloMessage(name)).build();
        } catch (Exception e) {
            return Response.status(400).build();
        }
    }

    private Response handleException(Throwable ex) {
        return Response.serverError().entity(ex).build();
    }

}
