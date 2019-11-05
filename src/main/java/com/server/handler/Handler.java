package com.server.handler;

@FunctionalInterface
public interface Handler<E> {

    /**
     * Something has happened, so handle it.
     *
     */
    void handle(E event);




}
