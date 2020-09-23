package com.project.mall.dao.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

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
