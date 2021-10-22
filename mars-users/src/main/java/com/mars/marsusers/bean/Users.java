package com.mars.marsusers.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 用户
 */
@Data
@Table(name = "users")
public class Users {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String alias;

    /**
     * 性别
     */
    private Integer gender;

    /**
     * 个签
     */
    private String motto;

    /**
     * 头像路径
     */
    private String headImg;

    /**
     * 注册时间
     */
    private Date regTime;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 是否注销
     */
    private Integer isDel;
}
