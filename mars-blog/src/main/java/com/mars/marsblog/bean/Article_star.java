package com.mars.marsblog.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * 文章点赞
 */
@Data
@Table(name = "article_star")
public class Article_star {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 点赞时间
     * */
    private Timestamp time;

    /**
     * 文章id
     * */
    private Integer article_id;

    /**
     * 用户id
     * */
    private Integer user_id;
}
