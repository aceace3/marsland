package com.mars.marsusers.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色
 */
@Data
@Table(name = "roles")
public class Roles {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 角色名
     */
    private String roleName;
}
