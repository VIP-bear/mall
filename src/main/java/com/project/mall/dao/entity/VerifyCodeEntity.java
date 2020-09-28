package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * 验证码表（用于用户找回密码，向用户绑定邮箱发送验证邮件）
 */
@Data
@Entity
@Table(name = "mall_verify_code")
public class VerifyCodeEntity {

    /**
     * id,自增长
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * 邮箱
     */
    @Column
    private String email;

    /**
     * 验证码
     */
    @Column
    private Integer code;

    /**
     * 发送时间
     */
    @Column
    private Timestamp send_time;

}
