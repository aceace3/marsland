package com.mars.marsusers.bean;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 权限
 */
@Data
@Table(name = "permissions")
public class Permissions {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    /**
     * 权限名
     */
    private String permissionName;
}
