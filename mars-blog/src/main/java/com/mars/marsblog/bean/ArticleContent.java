package com.mars.marsblog.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 文章内容
 */
@Data
@Table(name = "article_content")
public class ArticleContent {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 文章id
     * */
    private Integer article_id;

    /**
     * 内容
     * */
    private String content;

}
