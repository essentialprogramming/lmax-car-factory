package com.model;

import javax.ws.rs.QueryParam;

public class RequestModel {

    @QueryParam("colour")
    private String colour;
    @QueryParam("engineType")
    private String engineType;
    @QueryParam("model")
    private String model;


    public RequestModel() {
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
}
