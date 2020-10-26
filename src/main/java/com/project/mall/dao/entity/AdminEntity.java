package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 管理员表
 */
@Entity
@Data
@Table(name = "mall_admin")
public class AdminEntity {

    /*
    管理员id
     */
    @Id
    private String admin_id;


    /*
    管理员密码
     */
    @Column
    private String admin_pwd;

}
