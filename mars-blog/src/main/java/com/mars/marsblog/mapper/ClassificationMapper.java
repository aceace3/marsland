package com.mars.marsblog.mapper;

import com.mars.marsblog.bean.Classification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassificationMapper {

    List<Classification> findAll();

}
