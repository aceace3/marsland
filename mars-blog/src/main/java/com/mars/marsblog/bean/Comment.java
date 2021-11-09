package com.mars.marsblog.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * 评论
 */
@Data
@Table(name = "comment")
public class Comment {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 评论时间
     * */
    private Timestamp time;

    /**
     * 内容
     * */
    private String content;

    /**
     * 用户id
     * */
    private Integer userId;

    /**
     * 用户名
     * */
    private String userName;

    /**
     * 文章id
     * */
    private Integer articleId;

    /**
     * 父级评论id
     * */
    private Integer parentCommentId;

}
