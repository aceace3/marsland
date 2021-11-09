package com.mars.marsblog.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 分类
 */
@Data
@Table(name = "classification")
public class Classification {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 分类名称
     * */
    private String classifyName;

}
