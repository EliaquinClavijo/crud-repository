package com.javatpoint.model.company;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseCompany {

    @JsonProperty("success")
    private final boolean success;
    @JsonProperty("Item")
    private final Company Item;

    public ResponseCompany(boolean success, Company item) {
        this.success = success;
        Item = item;
    }
}
