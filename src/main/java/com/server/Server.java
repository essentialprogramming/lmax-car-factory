package com.server;

import com.config.ApplicationConfig;
import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.DeploymentManager;
import io.undertow.servlet.api.ListenerInfo;
import io.undertow.servlet.api.ServletInfo;
import org.glassfish.jersey.servlet.ServletContainer;
import org.jboss.weld.environment.servlet.Listener;

import javax.servlet.ServletException;

import static io.undertow.servlet.Servlets.defaultContainer;
import static io.undertow.servlet.Servlets.deployment;
import static io.undertow.servlet.Servlets.servlet;


public class Server {

    public static void main(final String[] args) throws ServletException {
        Undertow.builder()
                .addHttpListener(8080, "localhost")
                .setHandler(createHttpHandler())
                //.setIoThreads(1)
                .setWorkerThreads(1)
                .build()
                .start();



    }

    private static HttpHandler createHttpHandler() throws ServletException {
        final DeploymentManager manager = defaultContainer().addDeployment(createDeploymentInfo());
        manager.deploy();
        final HttpHandler handler = manager.start();
        return Handlers.gracefulShutdown(Handlers.path(Handlers.redirect("/"))
                .addPrefixPath("/", handler));
    }

    private static DeploymentInfo createDeploymentInfo() {
        return deployment()
                .setClassLoader(Server.class.getClassLoader())
                .setContextPath("/")
                .setDeploymentName("registry.war")
                .addListener(new ListenerInfo(Listener.class))
                .addServlets(createServlet());
    }

    private static ServletInfo createServlet() {
        return servlet("servlet", ServletContainer.class)
                .addInitParam("javax.ws.rs.Application", ApplicationConfig.class.getName())
                .addMapping("/*")
                .setLoadOnStartup(1)
                .setAsyncSupported(true);
    }

}
