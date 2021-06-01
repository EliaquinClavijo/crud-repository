package com.javatpoint.model.administrators;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseAdministratorList {

    @JsonProperty("success")
    public boolean success;

    @JsonProperty("Items")
    public List<Administrator> Items;

    @JsonProperty("recordsTotal")
    public Integer recordsTotal;

    @JsonProperty("page")
    public Integer page;

    @JsonProperty("count")
    public Integer count;

    public ResponseAdministratorList(boolean success, List<Administrator> items, Integer recordsTotal, Integer page, Integer count) {
        this.success = success;
        Items = items;
        this.recordsTotal = recordsTotal;
        this.page = page;
        this.count = count;
    }
}
