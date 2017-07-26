package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;


/**
 * Created by annakim on 7/26/17.
 */
public class RestExModel {

    private final long id;
    private final String name;

    public RestExModel(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The name of the user", required = true)
    public String getName() {
        return name;
    }

}
