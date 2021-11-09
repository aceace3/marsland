package com.mars.marsblog.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * 文章
 */
@Data
@Table(name = "article")
public class Article {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     *标题
     * */
    private String title;

    /**
     *用户id
     * */
    private Integer userId;

    /**
     *用户名
     * */
    private String userName;

    /**
     *创建时间
     * */
    private Timestamp createTime;

    /**
     *更新时间
     * */
    private Timestamp updateTime;

    /**
     *概述
     * */
    private String summary;

    /**
     *点赞数
     * */
    private Integer starCount;

    /**
     *评论数
     * */
    private Integer commentCount;

    /**
     *阅读量
     * */
    private Integer readCount;

    /**
     *分类id
     * */
    private Integer classifyId;

    /**
     *精华帖
     * */
    private Integer isEssence;

    /**
     *置顶
     * */
    private Integer isTop;

    /**
     *删除否
     * */
    private Integer isDel;
}
