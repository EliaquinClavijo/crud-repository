package com.javatpoint.model.catalog;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseCatalogList {

    @JsonProperty("success")
    public boolean success;

    @JsonProperty("Items")
    public List<Catalog> Items;

    @JsonProperty("recordsTotal")
    public Integer recordsTotal;

    @JsonProperty("page")
    public Integer page;

    @JsonProperty("count")
    public Integer count;

    public ResponseCatalogList(boolean success, List<Catalog> items, Integer recordsTotal, Integer page, Integer count) {
        this.success = success;
        Items = items;
        this.recordsTotal = recordsTotal;
        this.page = page;
        this.count = count;
    }
}
