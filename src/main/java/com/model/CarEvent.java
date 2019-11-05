package com.model;

import javax.ws.rs.container.AsyncResponse;

public class CarEvent {
    private Status engine;
    private Status driverSeat;
    private Status passengerSeat;
    private Status rearSeat;
    private Status frontDoorOne;
    private Status frontDoorTwo;
    private Status rearDoorOne;
    private Status rearDoorTwo;
    private Status paint;
    private Status wheelOne;
    private Status wheelTwo;
    private Status wheelThree;
    private Status wheelFour;

    private String colour;
    private String engineType;
    private String model;
    private boolean carCompleted;
    private AsyncResponse asyncResponse;

    public CarEvent() {

    }


    public CarEvent(Status engine, Status driverSeat, Status passengerSeat, Status rearSeat,
            Status frontDoorOne, Status frontDoorTwo, Status rearDoorOne, Status rearDoorTwo, Status paint,
            Status wheelOne, Status wheelTwo, Status wheelThree, Status wheelFour, String colour,
            String engineType, String model, boolean carCompleted, AsyncResponse asyncResponse) {
        this.engine = engine;
        this.driverSeat = driverSeat;
        this.passengerSeat = passengerSeat;
        this.rearSeat = rearSeat;
        this.frontDoorOne = frontDoorOne;
        this.frontDoorTwo = frontDoorTwo;
        this.rearDoorOne = rearDoorOne;
        this.rearDoorTwo = rearDoorTwo;
        this.paint = paint;
        this.wheelOne = wheelOne;
        this.wheelTwo = wheelTwo;
        this.wheelThree = wheelThree;
        this.wheelFour = wheelFour;
        this.colour = colour;
        this.engineType = engineType;
        this.model = model;
        this.carCompleted = carCompleted;
        this.asyncResponse = asyncResponse;
    }


    public Status getEngine() {
        return engine;
    }

    public void setEngine(Status engine) {
        this.engine = engine;
    }

    public Status getDriverSeat() {
        return driverSeat;
    }

    public void setDriverSeat(Status driverSeat) {
        this.driverSeat = driverSeat;
    }

    public Status getPassengerSeat() {
        return passengerSeat;
    }

    public void setPassengerSeat(Status passengerSeat) {
        this.passengerSeat = passengerSeat;
    }

    public Status getRearSeat() {
        return rearSeat;
    }

    public void setRearSeat(Status rearSeat) {
        this.rearSeat = rearSeat;
    }

    public Status getFrontDoorOne() {
        return frontDoorOne;
    }

    public void setFrontDoorOne(Status frontDoorOne) {
        this.frontDoorOne = frontDoorOne;
    }

    public Status getFrontDoorTwo() {
        return frontDoorTwo;
    }

    public void setFrontDoorTwo(Status frontDoorTwo) {
        this.frontDoorTwo = frontDoorTwo;
    }

    public Status getRearDoorOne() {
        return rearDoorOne;
    }

    public void setRearDoorOne(Status rearDoorOne) {
        this.rearDoorOne = rearDoorOne;
    }

    public Status getRearDoorTwo() {
        return rearDoorTwo;
    }

    public void setRearDoorTwo(Status rearDoorTwo) {
        this.rearDoorTwo = rearDoorTwo;
    }

    public Status getPaint() {
        return paint;
    }

    public void setPaint(Status paint) {
        this.paint = paint;
    }

    public Status getWheelOne() {
        return wheelOne;
    }

    public void setWheelOne(Status wheelOne) {
        this.wheelOne = wheelOne;
    }

    public Status getWheelTwo() {
        return wheelTwo;
    }

    public void setWheelTwo(Status wheelTwo) {
        this.wheelTwo = wheelTwo;
    }

    public Status getWheelThree() {
        return wheelThree;
    }

    public void setWheelThree(Status wheelThree) {
        this.wheelThree = wheelThree;
    }

    public Status getWheelFour() {
        return wheelFour;
    }

    public void setWheelFour(Status wheelFour) {
        this.wheelFour = wheelFour;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isCarCompleted() {
        return carCompleted;
    }

    public void setCarCompleted(boolean carCompleted) {
        this.carCompleted = carCompleted;
    }

    public AsyncResponse getAsyncResponse() {
        return asyncResponse;
    }

    public void setAsyncResponse(AsyncResponse asyncResponse) {
        this.asyncResponse = asyncResponse;
    }
}
