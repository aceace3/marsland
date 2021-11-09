package com.mars.marsblog.service;

import com.mars.marsblog.bean.Classification;
import com.mars.marsblog.mapper.ClassificationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationService {

    @Autowired
    private ClassificationMapper classificationMapper;

    public List<Classification> findAll(){
        return classificationMapper.findAll();
    }
}
