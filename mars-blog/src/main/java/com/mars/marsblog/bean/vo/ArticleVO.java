package com.mars.marsblog.bean.vo;

import com.mars.marsblog.bean.Article;
import com.mars.marsblog.bean.Classification;
import com.mars.marsblog.bean.Tag;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ArticleVO {

    /**
     * 分类
     * */
    private String classification;

    /**
     * 标签
     * */
    private String tag;

    /**
     *文章id
     * */
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
