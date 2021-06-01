package com.javatpoint.model.company;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseCompanyList {

    @JsonProperty("success")
    public boolean success;

    @JsonProperty("Items")
    public List<Company> Items;

    @JsonProperty("recordsTotal")
    public Integer recordsTotal;

    @JsonProperty("page")
    public Integer page;

    @JsonProperty("count")
    public Integer count;

    public ResponseCompanyList(boolean success, List<Company> items, Integer recordsTotal, Integer page, Integer count) {
        this.success = success;
        Items = items;
        this.recordsTotal = recordsTotal;
        this.page = page;
        this.count = count;
    }
}
