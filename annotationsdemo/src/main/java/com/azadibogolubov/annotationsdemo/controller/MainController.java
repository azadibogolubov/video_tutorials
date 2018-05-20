package com.azadibogolubov.annotationsdemo.controller;

import com.azadibogolubov.annotationsdemo.annotations.JsonGetMapping;
import com.azadibogolubov.annotationsdemo.annotations.JsonPostMapping;
import com.azadibogolubov.annotationsdemo.model.BasicModel;
import com.azadibogolubov.annotationsdemo.repository.BasicModelRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {
    @Autowired
    private BasicModelRepository basicModelRepository;

    @JsonGetMapping(value = "/getById/{id}")
    public String getMethod(@PathVariable String id) throws JsonProcessingException  {
        ObjectMapper mapper = new ObjectMapper();
        BasicModel basicModel = basicModelRepository.findByModelId(id);
        JSONObject returnObj = new JSONObject();
        if (basicModel == null) {
            returnObj.put("result", "No records found");
            return returnObj.toString();
        }
        returnObj.put("result", mapper.writeValueAsString(basicModel));
        return returnObj.toString();
    }

    @JsonPostMapping(value = "postJson")
    public String postMethod(@RequestBody BasicModel basicModel) {
        BasicModel modelToSave = new BasicModel();
        modelToSave.modelId = basicModel.modelId;
        modelToSave.value = basicModel.value;
        basicModelRepository.save(basicModel);

        JSONObject returnObj = new JSONObject();
        returnObj.put("status", "successfully posted");
        return returnObj.toString();
    }
}
