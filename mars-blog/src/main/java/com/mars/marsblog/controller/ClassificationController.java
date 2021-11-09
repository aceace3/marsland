package com.mars.marsblog.controller;

import com.mars.marsblog.bean.Classification;
import com.mars.marsblog.service.ClassificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;

    @GetMapping("/findAllClassification")
    public List<Classification> findAll(){
        return classificationService.findAll();
    }

}
