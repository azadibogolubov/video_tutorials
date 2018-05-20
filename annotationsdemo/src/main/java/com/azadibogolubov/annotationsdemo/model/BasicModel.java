package com.azadibogolubov.annotationsdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "basicModel")
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class BasicModel {
    public BasicModel() {}

//    @JsonIgnore
    public ObjectId id;
    public String modelId;
    public String value;
}
