package com.javatpoint.model.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseCatalog {

    @JsonProperty("success")
    private final boolean success;
    @JsonProperty("Item")
    private final Catalog Item;

    public ResponseCatalog(boolean success, Catalog item) {
        this.success = success;
        Item = item;
    }
}
