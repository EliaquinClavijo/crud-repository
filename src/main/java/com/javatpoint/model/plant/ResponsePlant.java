package com.javatpoint.model.plant;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponsePlant {

    @JsonProperty("success")
    private final boolean success;
    @JsonProperty("Item")
    private final Plant Item;

    public ResponsePlant(boolean success, Plant item) {
        this.success = success;
        Item = item;
    }
}
