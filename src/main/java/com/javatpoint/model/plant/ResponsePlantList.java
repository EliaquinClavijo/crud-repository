package com.javatpoint.model.plant;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponsePlantList {

    @JsonProperty("success")
    public boolean success;

    @JsonProperty("Items")
    public List<Plant> Items;

    @JsonProperty("recordsTotal")
    public Integer recordsTotal;

    @JsonProperty("page")
    public Integer page;

    @JsonProperty("count")
    public Integer count;

    public ResponsePlantList(boolean success, List<Plant> items, Integer recordsTotal, Integer page, Integer count) {
        this.success = success;
        Items = items;
        this.recordsTotal = recordsTotal;
        this.page = page;
        this.count = count;
    }
}
