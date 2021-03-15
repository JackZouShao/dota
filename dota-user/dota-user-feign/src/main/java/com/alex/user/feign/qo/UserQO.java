package com.alex.user.feign.qo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * User Parameter
 */
@Data
@Accessors(chain = true)
public class UserQO {
    private static final long serialVersionUID = 1L;
    /**
     * 当前页
     */
    private int currentPage;

    /**
     * 每页记录数
     */
    private int pageSize;

    /**
     * 主键
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 状态(1:正常，0:禁用)
     */
    private Integer statusId;

    /**
     * 用户编号
     */
    private Long userNo;

    /**
     * 手机号码
     */
    private String phone_number;

    /**
     * 密码盐
     */
    private String mobileSalt;

    /**
     * wechat token
     */
    private String wechatToken;

    /**
     * steam token
     */
    private String steamToken;


}
