package com.mars.marsblog.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 标签
 */
@Data
@Table(name = "tag")
public class Tag {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 标签名
     * */
    private String tagName;

    /**
     * 文章id
     * */
    private Integer articleId;
}
