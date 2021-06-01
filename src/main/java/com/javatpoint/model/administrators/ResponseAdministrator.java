package com.javatpoint.model.administrators;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseAdministrator {
    @JsonProperty("success")
    private final boolean success;
    @JsonProperty("Item")
    private final Administrator Item;

    public ResponseAdministrator(boolean success, Administrator item) {
        this.success = success;
        Item = item;
    }
}
