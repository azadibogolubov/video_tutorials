package com.azadibogolubov.annotationsdemo.repository;

import com.azadibogolubov.annotationsdemo.model.BasicModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface BasicModelRepository extends MongoRepository<BasicModel, String> {
    BasicModel findByModelId(String id);
}
